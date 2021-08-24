package mainApp.service;
import java.util.List;
import mainApp.dto.Fabricantes;

public interface IFabricanteService {

	public List<Fabricantes> listarFabricantes();
	
	public Fabricantes guardarFabricantes(Fabricantes fabricantes);
	
	public Fabricantes FabricanteXID(int codigo);
	
	public Fabricantes actualizarFabricantes(Fabricantes fabricantes);
	
	public void borrarFabricantes(int codigo);
}
