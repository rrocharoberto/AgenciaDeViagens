package br.edu.univas.agencia.agencia.service.api;

import java.util.Collection;
import java.util.List;

import br.edu.univas.agencia.exception.AgencyException;
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
	List<Integer> listFlightTypes(int packageId) throws AgencyException;

	/**
	 * 
	 * @param pacote
	 * @return a map containing two objects: First one: <"go", collection of
	 *         flight> Second one <"back", collection of flight>
	 * 
	 * @throws AgencyException
	 */
	Collection<Voo> listFlights(int packageId) throws AgencyException;

	/**
	 * 
	 * @param pacote
	 * @param vooReserva
	 * @throws AgencyException
	 */
	void createFlightReservation(VooReserva vooReserva) throws AgencyException;
}
