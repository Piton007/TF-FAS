package pe.com.NutriSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.NutriSoft.entities.PlanCalorico;

public interface IPlanCaloricoRepository extends JpaRepository<PlanCalorico, Integer> {

}
