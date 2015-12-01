package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.edu.univas.agencia.agencia.business.PackageBusiness;
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

	private PackageBusiness packageBusiness = new PackageBusiness();
	
	@GET
	@Override
	public Collection<Pacote> listPackages() throws AgencyException {
		return packageBusiness.listPackages();
	}

	@POST
	@Override
	public Pacote createPackage(Pacote pacote) throws AgencyException {
		packageBusiness.createPackage(pacote);
		return pacote;
	}

}
