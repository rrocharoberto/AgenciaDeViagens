package br.edu.univas.agencia.agencia.business;

import java.util.ArrayList;
import java.util.Collection;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.Estado;

/**
 * 
 * @author edilson
 *
 */
public class CityBusiness {
	
	public Collection<Cidade> listCities() throws AgencyException {
		Collection<Cidade> cities = new ArrayList<Cidade>();
		cities.add(new Cidade(new Estado("MG", "Minas Gerais"), "Pouso Alegre"));
		cities.add(new Cidade(new Estado("MG", "Minas Gerais"), "Borda da Mata"));
		return cities;
	}

}
