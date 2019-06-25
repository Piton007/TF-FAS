package pe.com.NutriSoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.NutriSoft.entities.Usuario;
import pe.com.NutriSoft.repository.IUsuarioRepository;
@Service
public class UsuarioService implements IUsuarioService {
	@Autowired
	IUsuarioRepository repository;

	@Override
	public Usuario registrar(Usuario t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Usuario getOne(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	@Override
	public Usuario buscarPorCorreo(String correo, String contraseña) {
		// TODO Auto-generated method stub
		return repository.buscarPorCorreo(correo, contraseña);
	}

	

}
