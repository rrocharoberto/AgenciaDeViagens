package br.edu.univas.agencia.agencia.service.api;

import java.util.Collection;

import br.edu.univas.agencia.model.Cidade;

/**
 * Interface to define the services related to City.
 * @author edilson
 *
 */
public interface CityService {
	
	Collection<Cidade> retrieve();

}
