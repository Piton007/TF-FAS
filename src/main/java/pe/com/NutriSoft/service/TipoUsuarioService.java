package pe.com.NutriSoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.NutriSoft.entities.TipoUsuario;
import pe.com.NutriSoft.repository.ITipoUsuarioRepository;
@Service
public class TipoUsuarioService implements ITipoUsuarioService {
	@Autowired
	ITipoUsuarioRepository repository;

	@Override
	public TipoUsuario registrar(TipoUsuario t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public TipoUsuario modificar(TipoUsuario t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<TipoUsuario> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public TipoUsuario getOne(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	

}
