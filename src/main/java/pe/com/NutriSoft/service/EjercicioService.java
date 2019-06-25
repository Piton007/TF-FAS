package pe.com.NutriSoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.NutriSoft.entities.Ejercicio;
import pe.com.NutriSoft.repository.IEjercicioRepository;

@Service
public class EjercicioService implements IEjercicioService {
	@Autowired
	IEjercicioRepository repository;

	@Override
	public Ejercicio registrar(Ejercicio t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Ejercicio modificar(Ejercicio t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Ejercicio> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Ejercicio getOne(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	

}
