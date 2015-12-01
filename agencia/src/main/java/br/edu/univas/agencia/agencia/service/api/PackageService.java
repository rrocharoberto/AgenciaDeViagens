package br.edu.univas.agencia.agencia.service.api;

import java.util.Collection;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;

/**
 * Interface to define the services related to Package.
 * 
 * @author edilson
 */
public interface PackageService {

	/**
	 * Get list of packages concluded.
	 * 
	 * @return
	 * @throws AgencyException
	 */
	Collection<Pacote> listPackages() throws AgencyException;

	/**
	 * Create package.
	 * 
	 * @param pacote
	 * @throws AgencyException
	 */
	Pacote createPackage(Pacote pacote) throws AgencyException;
}
