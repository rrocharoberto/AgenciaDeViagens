package br.edu.univas.agencia.service.api;

import java.util.List;

import br.edu.univas.agencia.model.AgencyException;

public interface Service <T> {
	
	List<T> findAll() throws AgencyException;
	T findById(Integer id);
	T findByName(String name);

}
