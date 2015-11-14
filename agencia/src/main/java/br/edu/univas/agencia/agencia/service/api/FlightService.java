package br.edu.univas.agencia.agencia.service.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Voo;
import br.edu.univas.agencia.model.VooReserva;

/**
 * Interface to define the services related to flight.
 * 
 * @author edilson
 *
 */
public interface FlightService {

	/**
	 * 
	 * @param pacote
	 * @return the list of the flight types ("Economic", "Executive", ...)
	 * @throws AgencyException
	 */
	List<Integer> listFlightTypes(Pacote pacote) throws AgencyException;

	/**
	 * 
	 * @param pacote
	 * @return a map containing two objects: First one: <"go", collection of
	 *         flight> Second one <"back", collection of flight>
	 * 
	 * @throws AgencyException
	 */
	Map<String, Collection<Voo>> listFlights(Pacote pacote)
			throws AgencyException;

	/**
	 * 
	 * @param pacote
	 * @param vooReserva
	 * @throws AgencyException
	 */
	void createFlightReservation(Pacote pacote, VooReserva vooReserva)
			throws AgencyException;
}
