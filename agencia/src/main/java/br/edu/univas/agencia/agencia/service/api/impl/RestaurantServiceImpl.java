package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import br.edu.univas.agencia.agencia.business.PackageBusiness;
import br.edu.univas.agencia.agencia.business.RestaurantBussiness;
import br.edu.univas.agencia.agencia.service.api.RestaurantService;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.model.RestauranteReserva;

/**
 * Implementation of services defined in {@link RestaurantService}.
 * 
 * @author edilson
 *
 */
@Path("/restaurant")
public class RestaurantServiceImpl implements RestaurantService {

	PackageBusiness packageBusiness = new PackageBusiness();
	RestaurantBussiness restaurantBusiness = new RestaurantBussiness();

	@GET
	@Override
	public Collection<Restaurante> listRestaurants(
			@QueryParam("packageId") int packageId) throws AgencyException {

		Pacote pacote = packageBusiness.retrievePackage(packageId);
		return restaurantBusiness.listRestaurants(pacote);
	}

	@POST
	@Path("/reservation")
	@Override
	public void createRestaurantReservation(
			RestauranteReserva restauranteReserva) throws AgencyException {
		restaurantBusiness.createReservation(restauranteReserva);

	}

}
