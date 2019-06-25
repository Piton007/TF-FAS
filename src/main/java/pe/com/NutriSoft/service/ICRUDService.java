package pe.com.NutriSoft.service;

import java.util.List;

public interface ICRUDService <T>{
	T registrar(T t);
	
	T modificar(T t);
	
	void eliminar(int id);
	
	List<T> listar();
	
	T getOne(int id);
}
