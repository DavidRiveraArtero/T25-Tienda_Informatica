package mainApp.service;
import java.util.List;
import mainApp.dto.Articulos;
public interface IArticulosService {

	public List<Articulos> listarArticulos();
	
	public Articulos guardarArticulos(Articulos articulos);
	
	public Articulos BuscarPorID(int codigo_a);
	
	public Articulos ActualizarArt(Articulos articulos);
	
	public void BorrarArt(int codigo_a);
	
}
