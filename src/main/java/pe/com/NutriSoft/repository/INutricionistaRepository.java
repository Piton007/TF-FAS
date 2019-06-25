package pe.com.NutriSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.NutriSoft.entities.Nutricionista;

public interface INutricionistaRepository extends JpaRepository<Nutricionista, Integer> {

}
