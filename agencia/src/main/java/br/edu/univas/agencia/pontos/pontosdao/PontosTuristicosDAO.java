package br.edu.univas.agencia.pontos.pontosdao;

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
			System.out.println("Problema ao add ponto turístico");
		}
	}
	
	public void updateCostureira(PontoTuristico pontoTuristico){
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(pontoTuristico);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Problema ao atualizar Ponto Turistico");
		}
	}
	
	public void removePontoTuristico(PontoTuristico pontoTuristico) throws Exception {
		try {
			entityManager.getTransaction().begin();
			String query = "DELETE from ponto_turistico where id = :idPonto";
			Query query2 = entityManager.createNativeQuery(query);
			query2.setParameter("idPonto", pontoTuristico.getId());
			query2.executeUpdate();
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Problema ao remover Ponto Turístico");
			throw e;
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
			System.out.println("Problema ao add reserva");
		}
	}
	
	public Pacote getPacoteById(int id){
		String queryPct = "Select p from Pacote p where p.id = :id";
		Query query = entityManager.createQuery(queryPct);
		query.setParameter("id", id);
		return (Pacote)query.getSingleResult();
	}
	
	public List<PontoTuristico> getAttractionsByCity(Cidade cidade){
		String queryPTur = "SELECT pt from PontoTuristico pt join pt.cidade c where c.id = :idCidade";
		Query query = entityManager.createQuery(queryPTur);
		query.setParameter("idCidade", cidade.getId());
		return query.getResultList();
	}
	
	public List<ReservaPontosTuristicos> getReservationAttractions(PontoTuristico attraction, Date date){
		
		String queryReserva = "SELECT rpt from ReservaPontosTuristicos rpt join rpt.pontoTuristico pt"
				+ " where rpt.date = :dateReceived and pt.id = :pontoTuristicoId";
		Query query = entityManager.createQuery(queryReserva);
		query.setParameter("dateReceived", date);
		query.setParameter("pontoTuristicoId", attraction.getId());
		
		try{
			return query.getResultList();
		}catch(NoResultException e){
			return new ArrayList<ReservaPontosTuristicos>();
		}
	}
	
	public List<PontoTuristico> listAllAttractions(){
		String queryPt = "SELECT p from PontoTuristico p";
		Query query = entityManager.createQuery(queryPt);
		
		try{
			return query.getResultList();
		}catch(NoResultException e){
			return new ArrayList<PontoTuristico>();
		}
	}
	
	public List<ReservaPontosTuristicos> getVisitedAttractions(Date dataInicio, Date dataFim){
		String queryRPT = "SELECT rpt from ReservaPontosTuristicos rpt where rpt.date between :dataInicio and :dataFim";
		Query query = entityManager.createQuery(queryRPT);
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		
		try{
			return query.getResultList();
		}catch(NoResultException e){
			return new ArrayList<ReservaPontosTuristicos>();
		}
	}
}
