package pe.com.NutriSoft.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Rutina")
public class Rutina {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	private double tiempoRutina;
	
	/*@OneToMany(mappedBy="rutina")
	private List<PlanCalorico> plancalorico;
	*/
	@ManyToOne
	private Ejercicio ejercicio;
	
	@ManyToOne
	private Gimnasio gimnasio;

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

	public double getTiempoRutina() {
		return tiempoRutina;
	}

	public void setTiempoRutina(double tiempoRutina) {
		this.tiempoRutina = tiempoRutina;
	}

	/*public List<PlanCalorico> getPlancalorico() {
		return plancalorico;
	}

	public void setPlancalorico(List<PlanCalorico> plancalorico) {
		this.plancalorico = plancalorico;
	}
*/
	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Gimnasio getGimnasio() {
		return gimnasio;
	}

	public void setGimnasio(Gimnasio gimnasio) {
		this.gimnasio = gimnasio;
	}
	
	

}
