package pe.com.NutriSoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.NutriSoft.entities.Nutricionista;
import pe.com.NutriSoft.repository.INutricionistaRepository;
@Service
public class NutricionistaService implements INutricionistaService {
	@Autowired
	INutricionistaRepository repository;

	@Override
	public Nutricionista registrar(Nutricionista t) {
		Nutricionista obj=null;
		try {
			 obj= repository.save(t);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return obj;
	}

	@Override
	public Nutricionista modificar(Nutricionista t) {
		return repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Nutricionista> listar() {
		return repository.findAll();
	}

	@Override
	public Nutricionista getOne(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
		
	}

	

}
