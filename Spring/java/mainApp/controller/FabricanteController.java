package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.dto.Fabricantes;
import mainApp.service.FabricanteSeviceImpl;

@RestController
@RequestMapping("/api")
public class FabricanteController {
	
	@Autowired
	FabricanteSeviceImpl fabricanteServiceImpl;
	
	//LISTAR TODOS LOS FABRICANTES
	@GetMapping("/fabricantes")
	public List<Fabricantes> listarFabricantes(){
		return fabricanteServiceImpl.listarFabricantes();
	}
	
	//GUARDAR FABRICANTES
	@PostMapping("/fabricantes")
	public Fabricantes guardarFabricantes(@RequestBody Fabricantes fabricantes) {
		return fabricanteServiceImpl.guardarFabricantes(fabricantes);
	}
	
	//BUSCAR POR ID
	@GetMapping("/fabricantes/{codigo}")
	public Fabricantes buscarID(@PathVariable(name="codigo")int codigo) {
		Fabricantes buscarID = new Fabricantes();
		
		buscarID=fabricanteServiceImpl.FabricanteXID(codigo);
		
		return buscarID;
	}
	
	//ACTUALIZAR
	@PutMapping("/fabricantes/{codigo}")
	public Fabricantes actualizarFabricantes(@PathVariable(name="codigo") int codigo, @RequestBody Fabricantes fabricantes) {
		
		Fabricantes Fabricante_Seleccionado= new Fabricantes();
		Fabricantes Fabricante_Actualizar = new Fabricantes();
		
		Fabricante_Seleccionado= fabricanteServiceImpl.FabricanteXID(codigo);
		
		Fabricante_Seleccionado.setArticulos(fabricantes.getArticulos());
		Fabricante_Seleccionado.setNombre(fabricantes.getNombre());
		
		Fabricante_Actualizar = fabricanteServiceImpl.actualizarFabricantes(Fabricante_Seleccionado);
		
		return Fabricante_Actualizar;
		
	}
	
	@DeleteMapping("fabricantes/delete/{codigo}")
	public void eliminarFabricante(@PathVariable(name="codigo")int codigo) {
		fabricanteServiceImpl.borrarFabricantes(codigo);
	}

}
