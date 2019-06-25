package pe.com.NutriSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.NutriSoft.entities.Ejercicio;

public interface IEjercicioRepository extends JpaRepository<Ejercicio, Integer> {

}
