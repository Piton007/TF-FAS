package pe.com.NutriSoft.service;



import pe.com.NutriSoft.entities.Usuario;



public interface IUsuarioService extends ICRUDService<Usuario> {
	public Usuario  buscarPorCorreo(String correo,String contraseña);

}
