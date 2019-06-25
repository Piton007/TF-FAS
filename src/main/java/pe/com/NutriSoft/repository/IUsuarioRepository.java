package pe.com.NutriSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.NutriSoft.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public Usuario  buscarPorCorreo(String correo,String contraseña);

}
