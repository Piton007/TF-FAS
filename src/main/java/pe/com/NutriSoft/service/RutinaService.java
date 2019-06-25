package pe.com.NutriSoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.NutriSoft.entities.Rutina;
import pe.com.NutriSoft.repository.IRutinaRepository;
@Service
public class RutinaService implements IRutinaService {
	@Autowired
	IRutinaRepository repository;

	@Override
	public Rutina registrar(Rutina t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Rutina modificar(Rutina t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Rutina> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Rutina getOne(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	

}
