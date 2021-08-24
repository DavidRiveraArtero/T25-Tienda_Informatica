package mainApp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="articulos")
public class Articulos {

	//ATRIBUTOS DE ENTIDAD ARTICULOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_a;
	
	@Column(name="nombre_a")
	private String nombre_a;
	
	@Column(name="precio")
	private int precio;
	
	@ManyToOne
	@JoinColumn(name = "codigo")
	Fabricantes codigo;
	
	//CONSTRUCTORES
	
	public Articulos() {
		
	}
	
	/**
	 * 
	 * @param codigo_a
	 * @param nombre_a
	 * @param precio
	 * @param fabricantes
	 */
	
	public Articulos(int codigo_a, String nombre_a, int precio, Fabricantes codigo) {
		this.codigo_a=codigo_a;
		this.nombre_a= nombre_a;
		this.precio=precio;
		this.codigo = codigo;
	}

	//GETTERS Y SETTERS
	
	public int getCodigo_a() {
		return codigo_a;
	}

	public void setCodigo_a(int codigo_a) {
		this.codigo_a = codigo_a;
	}

	public String getNombre_a() {
		return nombre_a;
	}

	public void setNombre_a(String nombre_a) {
		this.nombre_a = nombre_a;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	

	public Fabricantes getCodigo() {
		return codigo;
	}

	public void setCodigo(Fabricantes codigo) {
		this.codigo = codigo;
	}

	//METODO TO STRING
	@Override
	public String toString() {
		return "Articulos [codigo_a=" + codigo_a + ", nombre_a=" + nombre_a + ", precio=" + precio + ", codigo="
				+ codigo + "]";
	}

	
	
	
}
