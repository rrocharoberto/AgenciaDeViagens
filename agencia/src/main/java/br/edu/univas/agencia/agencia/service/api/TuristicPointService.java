package br.edu.univas.agencia.agencia.service.api;

import java.util.List;

import br.edu.univas.agencia.model.Pacote;
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
	 */
	List<PontoTuristico> listTuristicPoints(Pacote pacote);
	
	/**
	 * save turistic point.
	 * @param pontosTuristicos
	 */
	void createTuristicPointReservation(List<PontoTuristico> pontosTuristicos);
}
