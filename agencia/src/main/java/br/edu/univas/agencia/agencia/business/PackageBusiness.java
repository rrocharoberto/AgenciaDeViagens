package br.edu.univas.agencia.agencia.business;

import java.util.Collection;

import javax.persistence.EntityManager;

import util.HibernateUtil;
import br.edu.univas.agencia.agencia.dao.PackageDAO;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;

public class PackageBusiness {

	private final PackageDAO packageDAO;
	private EntityManager entityManager;

	public PackageBusiness() {
		this.packageDAO = new PackageDAO();
		this.entityManager = HibernateUtil.getEntityManager();
	}

	public Pacote retrievePackage(int packageId) throws AgencyException {
		return packageDAO.getById(packageId, entityManager);
	}
	
	public void createPackage(Pacote pacote) throws AgencyException {
		packageDAO.save(pacote, entityManager);
	}
	
	public Collection<Pacote> listPackages() {
		return packageDAO.getAll(entityManager);
	}

}
