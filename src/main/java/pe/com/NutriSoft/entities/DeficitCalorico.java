package pe.com.NutriSoft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DeficitCalorico")
public class DeficitCalorico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double consumoCalorico;
	private double deficitCalorico;
	private double quemaCalorica;
	
	@ManyToOne
	private PlanCalorico plancalorico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getConsumoCalorico() {
		return consumoCalorico;
	}

	public void setConsumoCalorico(double consumoCalorico) {
		this.consumoCalorico = consumoCalorico;
	}

	public double getDeficitCalorico() {
		return deficitCalorico;
	}

	public void setDeficitCalorico(double deficitCalorico) {
		this.deficitCalorico = deficitCalorico;
	}

	public double getQuemaCalorica() {
		return quemaCalorica;
	}

	public void setQuemaCalorica(double quemaCalorica) {
		this.quemaCalorica = quemaCalorica;
	}

	public PlanCalorico getPlancalorico() {
		return plancalorico;
	}

	public void setPlancalorico(PlanCalorico plancalorico) {
		this.plancalorico = plancalorico;
	}
	
	

}
