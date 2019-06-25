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
@Table(name="Dieta")
public class Dieta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	private String comidas;
	private double calorias;
	
	/*@OneToMany(mappedBy="dieta")
	private List<PlanCalorico> plancalorico;*/
	
	@ManyToOne
	private Nutricionista nutricionista;

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

	public String getComidas() {
		return comidas;
	}

	public void setComidas(String comidas) {
		this.comidas = comidas;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	/*public List<PlanCalorico> getPlancalorico() {
		return plancalorico;
	}

	public void setPlancalorico(List<PlanCalorico> plancalorico) {
		this.plancalorico = plancalorico;
	}
*/
	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}
	
}
