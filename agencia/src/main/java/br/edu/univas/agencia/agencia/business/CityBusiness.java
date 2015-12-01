package br.edu.univas.agencia.agencia.business;

import java.util.Collection;

import javax.persistence.EntityManager;

import util.HibernateUtil;
import br.edu.univas.agencia.agencia.dao.CityDAO;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;

/**
 * 
 * @author edilson
 *
 */
public class CityBusiness {

	private final CityDAO cityDao;
	private final EntityManager entityManager;

	public CityBusiness() {
		this.cityDao = new CityDAO();
		this.entityManager = HibernateUtil.getEntityManager();
	}

	public Collection<Cidade> listCities() throws AgencyException {
		return cityDao.getAll(entityManager);
	}

}
