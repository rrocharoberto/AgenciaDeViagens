package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import br.edu.univas.agencia.agencia.service.api.PackageService;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;

/**
 * Implementation of services defined in {@link PackageService}.
 * @author edilson
 *
 */
@Path("/package")
public class PackageServiceImpl implements PackageService {

	@GET
	@Override
	public Collection<Pacote> listPackages() throws AgencyException {
		//TODO  return packageBusiness.listPackages();
		return null;
	}

	@POST
	@Override
	public void createPackage(Pacote pacote) throws AgencyException {
		// TODO packageValidator.createPackage();
		// TODO packageBusiness.createPackage();
	}

}
