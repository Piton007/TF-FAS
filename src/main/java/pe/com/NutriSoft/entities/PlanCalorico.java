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
@Table(name="PlanCalorico")
public class PlanCalorico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double peso;
	private double talla;
	private double IMC;
	private double porcentajeGrasa;
	private double metaCalorias;
	private int dias;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Dieta dieta;
	
	@ManyToOne
	private Rutina rutina;
	
	/*@OneToMany(mappedBy="plancalorico")
	private List<DeficitCalorico> deficitcalorico;
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getTalla() {
		return talla;
	}

	public void setTalla(double talla) {
		this.talla = talla;
	}

	public double getIMC() {
		return IMC;
	}

	public void setIMC(double iMC) {
		IMC = iMC;
	}

	public double getPorcentajeGrasa() {
		return porcentajeGrasa;
	}

	public void setPorcentajeGrasa(double porcentajeGrasa) {
		this.porcentajeGrasa = porcentajeGrasa;
	}

	public double getMetaCalorias() {
		return metaCalorias;
	}

	public void setMetaCalorias(double metaCalorias) {
		this.metaCalorias = metaCalorias;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	/*public List<DeficitCalorico> getDeficitcalorico() {
		return deficitcalorico;
	}

	public void setDeficitcalorico(List<DeficitCalorico> deficitcalorico) {
		this.deficitcalorico = deficitcalorico;
	}
	*/
	
	
}
