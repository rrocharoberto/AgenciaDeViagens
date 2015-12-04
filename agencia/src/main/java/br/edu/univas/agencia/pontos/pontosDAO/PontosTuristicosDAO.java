package br.edu.univas.agencia.pontos.pontosDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;
import br.edu.univas.agencia.model.ReservaPontosTuristicos;
import br.edu.univas.agencia.pontos.bean.ReportBean;

public class PontosTuristicosDAO {

	private EntityManager entityManager;
	
	public PontosTuristicosDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void addPontoTuristico(PontoTuristico pontoTuristico){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(pontoTuristico);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Problema ao add ponto turístico");
		}
	}
	
	public void doReservations(List<ReservaPontosTuristicos> reservations){
		try {
			entityManager.getTransaction().begin();
			for(ReservaPontosTuristicos reservation : reservations){
				entityManager.persist(reservation);
				entityManager.flush();
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Problema ao add reserva");
		}
	}
	
	public Pacote getPacoteById(int id){
		String q = "Select p from Pacote p where p.id = :id";
		Query query = entityManager.createQuery(q);
		query.setParameter("id", id);
		return (Pacote)query.getSingleResult();
	}
	
	public List<PontoTuristico> getAttractionsByCity(Cidade cidade){
		String q = "SELECT pt from PontoTuristico pt join pt.cidade c where c.id = :idCidade";
		Query query = entityManager.createQuery(q);
		query.setParameter("idCidade", cidade.getId());
		return query.getResultList();
	}
	
	public List<ReservaPontosTuristicos> getReservationAttractions(PontoTuristico attraction, Date date){
		
		String q = "SELECT rpt from ReservaPontosTuristicos rpt join rpt.pontoTuristico pt"
				+ " where rpt.date = :dateReceived and pt.id = :pontoTuristicoId";
		Query query = entityManager.createQuery(q);
		query.setParameter("dateReceived", date);
		query.setParameter("pontoTuristicoId", attraction.getId());
		
		try{
			return query.getResultList();
		}catch(NoResultException e){
			return new ArrayList<ReservaPontosTuristicos>();
		}
	}
	
	public List<PontoTuristico> listAllAttractions(){
		String q = "SELECT p from PontoTuristico p";
		Query query = entityManager.createQuery(q);
		
		try{
			return query.getResultList();
		}catch(NoResultException e){
			return new ArrayList<PontoTuristico>();
		}
	}
	
	public List<ReservaPontosTuristicos> getVisitedAttractions(Date dataInicio, Date dataFim){
		String q = "SELECT rpt from ReservaPontosTuristicos rpt where rpt.date between :dataInicio and :dataFim";
		Query query = entityManager.createQuery(q);
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		
		try{
			return query.getResultList();
		}catch(NoResultException e){
			return new ArrayList<ReservaPontosTuristicos>();
		}
	}
}
