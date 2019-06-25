package pe.com.NutriSoft.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Gimnasio")
public class Gimnasio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String ServicioDestacado;
	private double precio;
	
	/*@OneToMany(mappedBy="gimnasio")
	private List<Rutina> rutina;
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getServicioDestacado() {
		return ServicioDestacado;
	}

	public void setServicioDestacado(String servicioDestacado) {
		ServicioDestacado = servicioDestacado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

/*	public List<Rutina> getRutina() {
		return rutina;
	}

	public void setRutina(List<Rutina> rutina) {
		this.rutina = rutina;
	}
	*/
	

}
