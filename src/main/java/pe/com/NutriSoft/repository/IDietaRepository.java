package pe.com.NutriSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.NutriSoft.entities.Dieta;

public interface IDietaRepository extends  JpaRepository<Dieta, Integer> {

}
