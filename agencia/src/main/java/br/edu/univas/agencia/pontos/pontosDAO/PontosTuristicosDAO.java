package br.edu.univas.agencia.pontos.pontosDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.PontoTuristico;

public class PontosTuristicosDAO {

	private EntityManager entityManager;
	
	public PontosTuristicosDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public List<PontoTuristico> getAttractionsByCity(Cidade cidade){
		String q = "Select pt from PontoTuristico pt join pt.cidade c where c.id = :idCidade";
		Query query = entityManager.createQuery(q);
		query.setParameter("idCidade", cidade.getId());
		return query.getResultList();
	}
}
