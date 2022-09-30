package com.ejercicio.AdministracionEmpresa.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ejercicio.AdministracionEmpresa.Dao.EmpresaDao;
import com.ejercicio.AdministracionEmpresa.Dao.PersonaDao;
import com.ejercicio.AdministracionEmpresa.Dao.SucursalDao;
import com.ejercicio.AdministracionEmpresa.Entities.Empresa;
import com.ejercicio.AdministracionEmpresa.Entities.Persona;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.AdministracionEmpresa.Dao.ColaboradorDao;
import com.ejercicio.AdministracionEmpresa.Dto.ColaboradorDto;
import com.ejercicio.AdministracionEmpresa.Dto.EmpresasDto;
import com.ejercicio.AdministracionEmpresa.Dto.SucursalDto;
import com.ejercicio.AdministracionEmpresa.Entities.Colaborador;
import com.ejercicio.AdministracionEmpresa.Entities.Sucursal;

@Service
public class ColaboradorServiceImpl implements ColaboradorService{

	
	
	private final ColaboradorDao colaboradorDao;

	private final EmpresaDao empresaDao;
	
	private final SucursalDao sucursalDao;
	
	private final ModelMapper modeloObject;

	private final PersonaDao personaDao;


	@Autowired
	public ColaboradorServiceImpl(SucursalDao sucursalDao,ColaboradorDao colaboradorDao, EmpresaDao empresaDao, PersonaDao personaDao) {
		this.modeloObject = new ModelMapper();
		this.colaboradorDao = colaboradorDao;
		this.empresaDao = empresaDao;
		this.sucursalDao = sucursalDao;
		this.personaDao = personaDao;
	}
	
	public ColaboradorDto mappedColaboradorDto(Colaborador colaborador) {
		
		return modeloObject.map(colaborador, ColaboradorDto.class);
	}

	public Colaborador mappedColaborador(ColaboradorDto colaboradorDto){
		return modeloObject.map(colaboradorDto, Colaborador.class);
	}
	
	@Override
	public List<ColaboradorDto> listarColaborador() {

		// TODO Auto-generated method stub
		List<Colaborador> colaboradores = (List<Colaborador>) colaboradorDao.findAll();
		List<ColaboradorDto> colaboradorDto = new ArrayList<>();
		for (Colaborador colaborador : colaboradores) {
			ColaboradorDto colaboradorDtoTemp = mappedColaboradorDto(colaborador);
			colaboradorDtoTemp.setSucursal_id(colaborador.getSucursal().getId_sucursal());
			colaboradorDtoTemp.setEmpresa_id(colaborador.getSucursal().getEmpresa().getId_empresa());
			if(colaborador.getPersona()!=null){
				colaboradorDtoTemp.setPersona_id(colaborador.getPersona().getId_Persona());
			}
			colaboradorDto.add(colaboradorDtoTemp);
		}
		return colaboradorDto;
	}

	@Override
	public ColaboradorDto buscarColaborador(Long id) {
		// TODO Auto-generated method stub

		Colaborador colaborador = colaboradorDao.findById(id).orElse(null);
		
		ColaboradorDto colaboradorTemp = mappedColaboradorDto(colaborador);

		colaboradorTemp.setSucursal_id(colaborador.getSucursal().getId_sucursal());
		colaboradorTemp.setEmpresa_id(colaborador.getSucursal().getEmpresa().getId_empresa());


		return colaboradorTemp;

	}

	@Override
	public ColaboradorDto crearColaborador(ColaboradorDto colaboradorDto) {

		Colaborador colaborador = mappedColaborador(colaboradorDto);
		
		Optional <Sucursal> sucursal = sucursalDao.findById(colaboradorDto.getSucursal_id());

		Optional <Persona> persona = personaDao.findById(colaboradorDto.getPersona_id());

		if(sucursal.isEmpty()){
			colaboradorDto.setCodigoError(1);
			colaboradorDto.setMensajeError("No se encontro la sucursal");
			return colaboradorDto;
		}

		//verificacion de clase persona
		persona.ifPresent(colaborador::setPersona);
		colaborador.setSucursal(sucursal.get());
		
		Colaborador colaboradorSave = null;
		if(colaborador.validacionDatos()) {
			colaboradorSave= colaboradorDao.save(colaborador);
		}
		
		if(colaboradorSave!=null) {
			colaboradorDto.setCodigoError(0);
			colaboradorDto.setId_Colaborador(colaboradorSave.getId_Colaborador());
			colaboradorDto.setMensajeError("Guardado Correctamente");
			return colaboradorDto;
		}
		
		colaboradorDto.setCodigoError(1);
		colaboradorDto.setMensajeError("No se pudo guardar el colaborador");
		return colaboradorDto;
	}

	
	@Override 
	public void editarColaborador(ColaboradorDto colaboradorDto) {

		Optional<Colaborador> colaborador = colaboradorDao.findById(colaboradorDto.getId_Colaborador());

		if(colaborador.isPresent()){
			Colaborador colaboradorGet = colaborador.get();
			if(!colaboradorGet.getNombre().equals(colaboradorDto.getNombre())){
				colaboradorGet.setNombre(colaboradorDto.getNombre());
			}
			if(!colaboradorGet.getCui().equals(colaboradorDto.getCui())){
				colaboradorGet.setCui(colaboradorDto.getCui());
			}
			if(colaboradorGet.getSucursal().getId_sucursal()!=colaboradorDto.getSucursal_id()){
				Optional<Sucursal> sucursal = sucursalDao.findById(colaboradorDto.getSucursal_id());
				sucursal.ifPresent(colaboradorGet::setSucursal);
			}

			if(colaboradorGet.getSucursal().getEmpresa().getId_empresa()!=colaboradorDto.getEmpresa_id()){
				Optional<Empresa> empresa = empresaDao.findById(colaboradorDto.getEmpresa_id());
				empresa.ifPresent(colaboradorGet.getSucursal()::setEmpresa);
			}
			colaboradorDao.save(colaboradorGet);
		}
	}

	@Override
	public void borrarColaborador(Long id) {
		// TODO Auto-generated method stub
		if(colaboradorDao.existsById(id)){
			colaboradorDao.deleteById(id);
        }
	}

}
