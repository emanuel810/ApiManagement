package com.ejercicio.AdministracionEmpresa.Services;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejercicio.AdministracionEmpresa.Dao.EmpresaDao;
import com.ejercicio.AdministracionEmpresa.Dto.EmpresasDto;
import com.ejercicio.AdministracionEmpresa.Entities.Empresa;


@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	private final EmpresaDao empresaDao;
	
	private final ModelMapper modeloObject;
	
	@Autowired
	public EmpresaServiceImpl(EmpresaDao empresaDao) {
		this.empresaDao = empresaDao;
		this.modeloObject = new ModelMapper();
		
	}
	
	
	public EmpresasDto mappedEmpresaDto(Empresa empresa) {
		
		return modeloObject.map(empresa, EmpresasDto.class);
	}

	public Empresa mappedEmpresa(EmpresasDto empresaDto){
		return modeloObject.map(empresaDto, Empresa.class);
	}
	
	@Override
	public List<EmpresasDto> listarEmpresa() {
		List<Empresa> empresa = (List<Empresa>) empresaDao.findAll();
		List<EmpresasDto> empresaDto = new ArrayList<>();
		for (Empresa empresas : empresa) {
			empresaDto.add(mappedEmpresaDto(empresas));
		}
		return empresaDto;
		
	}

	@Override
	public EmpresasDto buscarEmpresa(Long id) {
		Empresa empresa1 = empresaDao.findById(id).orElse(null);
		EmpresasDto empresa =new EmpresasDto();
		if(empresa1==null) {
			
			empresa.setCodigoError(1);
			empresa.setMensajeError("Empresa no encontrada");
			return empresa;
		}
		empresa = mappedEmpresaDto(empresa1);
		empresa.setCodigoError(0);
		return empresa;
	}
	
	

	@Override
	public EmpresasDto crearEmpresa(EmpresasDto empresa) {
		Empresa empresa1 = mappedEmpresa(empresa);
		
		if(empresa1.validarDatos()) {
			Empresa empresaSave= empresaDao.save(empresa1);
			empresa.setId_empresa(empresaSave.getId_empresa());
			empresa.setMensajeError("Guardado correctamente");
			empresa.setCodigoError(0);
			return empresa;
		}else {
			empresa.setCodigoError(1);
			empresa.setMensajeError("No fue posible guardar el objeto");
			return empresa;
		}
	}


	@Override
	public void editarEmpresa(Empresa empresa, Long id) {
		 if(empresaDao.existsById(id)){
			 	empresa.setId_empresa(id);
	            empresaDao.save(empresa);
	        }
	}

	@Override
	public void borrarEmpresa(Long id) {
		if(empresaDao.existsById(id)){
			empresaDao.deleteById(id);
        }
	}

}
