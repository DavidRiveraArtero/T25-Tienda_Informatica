package mainApp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import mainApp.dto.Articulos;
public interface IArticulos extends JpaRepository<Articulos, Integer>{

}
