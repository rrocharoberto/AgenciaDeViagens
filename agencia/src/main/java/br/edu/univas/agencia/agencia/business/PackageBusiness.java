package br.edu.univas.agencia.agencia.business;

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

	public Pacote retrivePackage(int packageId) throws AgencyException {
		return packageDAO.getById(packageId, entityManager);
	}

}
