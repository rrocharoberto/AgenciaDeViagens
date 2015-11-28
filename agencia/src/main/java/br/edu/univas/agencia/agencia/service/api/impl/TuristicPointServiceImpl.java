package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import br.edu.univas.agencia.agencia.service.api.TuristicPointService;
import br.edu.univas.agencia.agencia.service.api.domain.AtractionsReservation;
import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.PontoTuristico;

/**
 * Implementation of services defined in {@link TuristicPointService}.
 * 
 * @author edilson
 *
 */
@Path("/atractions")
public class TuristicPointServiceImpl implements TuristicPointService {

	@GET
	@Override
	public List<PontoTuristico> listTuristicPoints(@QueryParam("packageId") int packageId) {
		List<PontoTuristico> pontos = new ArrayList<PontoTuristico>();
		PontoTuristico ponto = new PontoTuristico();
		ponto.setId(1);
		ponto.setDescricao("Cristo Redentor");
		
		Map<Date, Boolean> days = new HashMap<Date, Boolean>();
		days.put(new Date(), false);
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		
		days.put(dt, true);
		ponto.setDaysAvailable(days);
		
		ponto.setCidade(new Cidade());
		
		ponto.setNumeroVagas(10);
		
		pontos.add(ponto);
		return pontos;
	}

	@POST
	@Path("/reservation")
	@Override
	public void createTuristicPointReservation(AtractionsReservation atractionsReservation) {
		//TODO: convert to a list of TuristicPoint
		//TODO: save turisticPointReservation
	}

}
