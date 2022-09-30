package com.ejercicio.AdministracionEmpresa.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ejercicio.AdministracionEmpresa.Dao.EmpresaDao;
import com.ejercicio.AdministracionEmpresa.Entities.Empresa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejercicio.AdministracionEmpresa.Dao.SucursalDao;
import com.ejercicio.AdministracionEmpresa.Dto.EmpresasDto;
import com.ejercicio.AdministracionEmpresa.Dto.SucursalDto;
import com.ejercicio.AdministracionEmpresa.Entities.Sucursal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SucursalServiceImpl implements SucursalService {
	
	private final SucursalDao sucursalDao;
	
	private final ModelMapper modeloObject;
	
	private final EmpresaServiceImpl empresaServiceImpl;

	private final EmpresaDao empresaDao;
	
	@Autowired
	public SucursalServiceImpl(SucursalDao sucursalDao, EmpresaServiceImpl empresaServiceImpl, EmpresaDao empresaDao){
		this.modeloObject = new ModelMapper();
		this.empresaServiceImpl = empresaServiceImpl;
		this.sucursalDao = sucursalDao;
		this.empresaDao = empresaDao;
		
	}
	
	public SucursalDto mappedSucursalDto(Sucursal sucursal) {
		
		return modeloObject.map(sucursal, SucursalDto.class);
	}

	public Sucursal mappedSucursal(SucursalDto sucursalDto){
		return modeloObject.map(sucursalDto, Sucursal.class);
	}

	@Override
	public List<SucursalDto> listarSucursales() {
		List<Sucursal> sucursales = (List<Sucursal>) sucursalDao.findAll();
		List<SucursalDto> sucursalDto = new ArrayList<>();
		for (Sucursal sucursal : sucursales) {
			SucursalDto sucursalDtoTemp = mappedSucursalDto(sucursal);
			sucursalDtoTemp.setEmpresa_id(sucursal.getEmpresa().getId_empresa());
			sucursalDto.add(sucursalDtoTemp);
		}
		return sucursalDto;
	}

	@Override
	public SucursalDto buscarSucursales(Long id) {
		
		Sucursal sucursal =sucursalDao.findById(id).orElse(null);
		SucursalDto sucursalTemp = mappedSucursalDto(sucursal);
		sucursalTemp.setEmpresa_id(sucursal.getEmpresa().getId_empresa());
		
		return sucursalTemp;
	}
 
	@Override
	public void editarSucursales(SucursalDto sucursalDto) {

		 Optional<Sucursal> sucursal = sucursalDao.findById(sucursalDto.getId_sucursal());

		 if(sucursal.isPresent()){
			 	Sucursal sucursal2 = sucursal.get();
				if(!sucursal2.getNombre().equals(sucursalDto.getNombre())){
					sucursal2.setNombre(sucursalDto.getNombre());
				}
				if(!sucursal2.getDireccion().equals(sucursalDto.getDireccion())){
					sucursal2.setDireccion(sucursalDto.getDireccion());
				}
				if(!sucursal2.getTelefono().equals(sucursalDto.getTelefono())){
					sucursal2.setTelefono(sucursalDto.getTelefono());
				}
				if(sucursal2.getEmpresa().getId_empresa()!=sucursalDto.getEmpresa_id()){
					Optional<Empresa> empresa = empresaDao.findById(sucursalDto.getEmpresa_id());
					empresa.ifPresent(sucursal2::setEmpresa);
				}
			 	sucursalDao.save(sucursal2);
		 }
	}

	@Override
	public void borrarSucursales(Long id) {

		if(sucursalDao.existsById(id)){
			sucursalDao.deleteById(id);
        }
	}

	@Override
	public SucursalDto crearSucursales(SucursalDto sucursales) {

		Sucursal sucursal = mappedSucursal(sucursales);
		
		EmpresasDto empresaDto = empresaServiceImpl.buscarEmpresa(sucursales.getEmpresa_id());
		
		if(empresaDto.getCodigoError()!=0) {
			sucursales.setMensajeError(empresaDto.getMensajeError());
			sucursales.setCodigoError(empresaDto.getCodigoError());
			return sucursales;
		}
	
		log.info(empresaDto.toString());
		
		
		sucursal.setEmpresa(empresaServiceImpl.mappedEmpresa(empresaDto));
		log.info(sucursal.toString());
		Sucursal sucursalSave = null;
		if(sucursal.validacionDatos()) {
			sucursalSave= sucursalDao.save(sucursal);
		}
		
		if(sucursalSave!=null) {
			sucursales.setCodigoError(0);
			sucursales.setId_sucursal(sucursalSave.getId_sucursal());
			sucursales.setMensajeError("Guardado Correctamente");
			return sucursales;
		}
		
		sucursales.setCodigoError(1);
		sucursales.setMensajeError("No se pudo guardar la sucursal");
		return sucursales;
		
	}
}
