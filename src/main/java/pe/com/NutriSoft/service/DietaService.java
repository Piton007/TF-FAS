package pe.com.NutriSoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.NutriSoft.entities.Dieta;
import pe.com.NutriSoft.repository.IDietaRepository;

@Service
public class DietaService implements IDietaService {
	@Autowired
	IDietaRepository repository;

	@Override
	public Dieta registrar(Dieta t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Dieta modificar(Dieta t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Dieta> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Dieta getOne(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	

}
