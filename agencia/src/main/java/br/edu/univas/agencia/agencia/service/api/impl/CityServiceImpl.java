package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.univas.agencia.agencia.business.CityBusiness;
import br.edu.univas.agencia.agencia.service.api.CityService;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;

/**
 * Implementation of services defined in {@link CityService}.
 * 
 * @author edilson
 *
 */
@Path("/city")
public class CityServiceImpl implements CityService {

	private CityBusiness cityBusiness = new CityBusiness();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Collection<Cidade> listCities() throws AgencyException {
		return cityBusiness.listCities();
	}
}
