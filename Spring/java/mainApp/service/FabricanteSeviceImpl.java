package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IFabricantes;
import mainApp.dto.Fabricantes;

@Service
public class FabricanteSeviceImpl implements IFabricanteService{
	@Autowired
	IFabricantes iFabricantes;
	
	//LISTAR TODO
	public List<Fabricantes> listarFabricantes(){
		return iFabricantes.findAll();
	}
	
	//GUARDAR FABRICANTES
	public Fabricantes guardarFabricantes(Fabricantes fabricantes) {
		return iFabricantes.save(fabricantes);
	}
	
	//BUSCAR POR ID
	public Fabricantes FabricanteXID(int codigo) {
		return iFabricantes.findById(codigo).get();
	}
	
	//ACTUALIZAR FABRICANTES
	public Fabricantes actualizarFabricantes(Fabricantes fabricantes) {
		return iFabricantes.save(fabricantes);
	}
	
	//ELIMINAR FABRICANTES
	public void borrarFabricantes(int codigo) {
		iFabricantes.deleteById(codigo);
	}

}
