package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.edu.univas.agencia.agencia.service.api.RestaurantService;
import br.edu.univas.agencia.agencia.service.api.TuristicPointService;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;

/**
 * Implementation of services defined in {@link TuristicPointService}.
 * @author edilson
 *
 */
@Path("/turisticPoint")
public class TuristicPointServiceImpl implements TuristicPointService{

	@GET
	@Override
	public List<PontoTuristico> listTuristicPoints(Pacote pacote) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Override
	public void createTuristicPointReservation(
			List<PontoTuristico> pontosTuristicos) {
		// TODO Auto-generated method stub
		
	}

}
