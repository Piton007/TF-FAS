package pe.com.NutriSoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.NutriSoft.entities.Gimnasio;
import pe.com.NutriSoft.repository.IGimnasioRepository;
@Service
public class GimnasioService implements IGimnasioService {
	@Autowired
	IGimnasioRepository repository;

	@Override
	public Gimnasio registrar(Gimnasio t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Gimnasio modificar(Gimnasio t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Gimnasio> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Gimnasio getOne(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	
}
