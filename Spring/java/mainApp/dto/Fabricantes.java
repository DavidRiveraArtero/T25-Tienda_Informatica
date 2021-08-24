package mainApp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="fabricantes")
public class Fabricantes {

	//ATRIBUTO DE ENTIDAD
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Articulos> Articulos;
	
	
	/**
	 * @param codigo
	 * @param nombre
	 * 
	 */
	
	
	
	//CONSTRUCTORES
	public Fabricantes() {
		
	}
	
	public Fabricantes (int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		
	}
	
	//GETTERS Y SETTERS


	public int getCodigo() {
		return codigo;
	}
	


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void setArticulos(List<Articulos> articulos) {
		this.Articulos = articulos;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "RegistroCurso")
	public List<Articulos> getArticulos() {
		return Articulos;
	}


	//METODO TOSTRING
	@Override
	public String toString() {
		return "Fabricantes [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	

	
	
	
	
}
