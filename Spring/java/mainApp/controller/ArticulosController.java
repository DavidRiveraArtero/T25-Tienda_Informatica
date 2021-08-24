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

import mainApp.dto.Articulos;

import mainApp.service.ArticuloServiceImpl;

@RestController
@RequestMapping("/api")
public class ArticulosController {
	
	@Autowired
	ArticuloServiceImpl articuloServiceImpl;
	
	//LISTAR ARTICULOS
	@GetMapping("/articulos")
	public List<Articulos> listarArticulos(){
		return articuloServiceImpl.listarArticulos();
	}
	
	//AÑADIR ARTICULOS
	@PostMapping("/articulos")
	public Articulos añadirArticulo(@RequestBody Articulos articulos) {
		return articuloServiceImpl.guardarArticulos(articulos);
	}
	
	//BUSCAR POR ID
	@GetMapping("/articulos/{codigo_a}")
	public Articulos buscarID(@PathVariable(name="codigo_a")int codigo_a) {
		Articulos buscarID = new Articulos();
		buscarID= articuloServiceImpl.BuscarPorID(codigo_a);
		return buscarID;
	}
	
	//ACTUALIZAR ID
	@PutMapping("/articulos/{codigo_a}")
	public Articulos actualizarArtiulos(@PathVariable(name="codigo_a") int codigo_a, @RequestBody Articulos articulos) {
		Articulos Articulos_Seleccionados = new Articulos();
		Articulos Articulos_Actualizar = new Articulos();
		
		Articulos_Seleccionados = articuloServiceImpl.BuscarPorID(codigo_a);
		
		Articulos_Seleccionados.setNombre_a(articulos.getNombre_a());
		Articulos_Seleccionados.setPrecio(articulos.getPrecio());
		
		Articulos_Actualizar = articuloServiceImpl.ActualizarArt(Articulos_Seleccionados);
		
		return Articulos_Actualizar;
		
		
	}
	
	//ELIMINAR ARTICULO
	@DeleteMapping("articulos/{codigo_a}")
	public void eliminarArticulo(@PathVariable(name="codigo_a")int codigo_a) {
		articuloServiceImpl.BorrarArt(codigo_a);
	}
	

}
