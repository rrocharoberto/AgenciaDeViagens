package br.edu.univas.agencia.agencia.service.api;

import java.text.ParseException;
import java.util.List;

import br.edu.univas.agencia.agencia.service.api.domain.AtractionsReservation;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.PontoTuristico;

/**
 * Interface to define the services related to turistic points.
 * 
 * @author edilson
 *
 */
public interface TuristicPointService {

	/**
	 * 
	 * @param pacote
	 * @return the list of available turistic points.
	 * @throws AgencyException 
	 * @throws ParseException 
	 */
	List<PontoTuristico> listTuristicPoints(int packageId) throws AgencyException, ParseException;
	
	/**
	 * save turistic point.
	 * @param pontosTuristicos
	 */
	void createTuristicPointReservation(AtractionsReservation atractionsReservation);
}
