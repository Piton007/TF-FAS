package pe.com.NutriSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.NutriSoft.entities.TipoUsuario;

public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

}
