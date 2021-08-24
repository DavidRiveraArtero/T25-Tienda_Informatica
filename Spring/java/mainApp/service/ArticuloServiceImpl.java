package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IArticulos;
import mainApp.dto.Articulos;


@Service
public class ArticuloServiceImpl implements IArticulosService{

	@Autowired
	IArticulos iArticulos;
	
	//LISTAR TODO EL CONTENIDO ARTICULOS
	public List<Articulos> listarArticulos(){
		return iArticulos.findAll();
	}
	
	//GUARDAR ARTICULOS
	public Articulos guardarArticulos(Articulos articulos) {
		return iArticulos.save(articulos);
	}
	
	//BUSCAR POR ID
	public Articulos BuscarPorID(int codigo_a) {
		return iArticulos.findById(codigo_a).get();
	}
	
	//ACTUALIZAR REGISTRO
	public Articulos ActualizarArt(Articulos articulos) {
		return iArticulos.save(articulos);
	}
	
	//BORRAR
	public void BorrarArt(int codigo_a) {
		iArticulos.deleteById(codigo_a);
	}

	
}
