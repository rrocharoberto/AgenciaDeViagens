package br.edu.univas.agencia.pontos.pontosDAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.PontoTuristico;

public class PontosTuristicosDAO {

	private EntityManager entityManager;
	
	public PontosTuristicosDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public List<PontoTuristico> getAttractionsByCity(Cidade cidade){
		return null;
	}
}
