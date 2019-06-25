package pe.com.NutriSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.NutriSoft.entities.DeficitCalorico;

public interface IDeficitCaloricoRepository extends JpaRepository<DeficitCalorico, Integer> {

}
