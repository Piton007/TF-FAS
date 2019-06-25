package pe.com.NutriSoft.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ejercicio")
public class Ejercicio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	private String musculoTrabajado;
	private double calorias_quemadas;
	
	/*@OneToMany(mappedBy="ejercicio")
	private List<Rutina> rutina;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMusculoTrabajado() {
		return musculoTrabajado;
	}

	public void setMusculoTrabajado(String musculoTrabajado) {
		this.musculoTrabajado = musculoTrabajado;
	}

	public double getCalorias_quemadas() {
		return calorias_quemadas;
	}

	public void setCalorias_quemadas(double calorias_quemadas) {
		this.calorias_quemadas = calorias_quemadas;
	}

/*	public List<Rutina> getRutina() {
		return rutina;
	}

	public void setRutina(List<Rutina> rutina) {
		this.rutina = rutina;
	}
	
	*/

}
