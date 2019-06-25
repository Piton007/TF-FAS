package pe.com.NutriSoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.NutriSoft.entities.PlanCalorico;
import pe.com.NutriSoft.repository.IPlanCaloricoRepository;
@Service
public class PlanCaloricoService implements IPlanCaloricoService {
	@Autowired
	IPlanCaloricoRepository repository;

	@Override
	public PlanCalorico registrar(PlanCalorico t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public PlanCalorico modificar(PlanCalorico t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<PlanCalorico> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public PlanCalorico getOne(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	

}
