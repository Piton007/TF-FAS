package pe.com.NutriSoft.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.NutriSoft.entities.DeficitCalorico;
import pe.com.NutriSoft.repository.IDeficitCaloricoRepository;
@Service
public class DeficitCaloricoService implements IDeficitCaloricoService {
	@Autowired
	IDeficitCaloricoRepository repository;

	@Override
	public DeficitCalorico registrar(DeficitCalorico t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public DeficitCalorico modificar(DeficitCalorico t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<DeficitCalorico> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public DeficitCalorico getOne(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	

}
