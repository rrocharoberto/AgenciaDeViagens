package br.edu.univas.agencia.hotel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.HibernateUtil;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

/**
 * 
 * Class responsible by perform operations of hotel module in database
 * 
 * @extends GenericHotelDAO
 *
 */
public class HotelDAO extends GenericHotelDAO<Hotel, Integer> {

	/**
	 * Superclass default constructor.
	 * 
	 * @param {@link EntityManager} em
	 */
	public HotelDAO(EntityManager em) {
		super(em);
	}

	/**
	 * method responsible for the search of hotels are available in the database
	 * 
	 * @param {@link Pacote} bundle
	 * 
	 * @return {@link List<Hotel>} availableHotelList
	 */
	public List<Hotel> getAvailableHotelList(Pacote bundle) {
		String sql = "select ht.*, sum(p.quantidade_pessoas) as soma " +
					 "from pacote p " + 
					 "join hotel_reserva hr on p.id = hr.pacote_id " +
					 "join hotel ht on ht.id = hr.hotel_id " +
					 "join cidade cd on cd.id = :cidadeID " +
					 "where hr.data_reserva between :inicio and :fim " +
					 "and ht.active = 1 " +
					 "group by ht.id, ht.nome, ht.numero_vagas, ht.valor, ht.cidade_id";
		
		Query query = HibernateUtil.getEntityManager().createQuery(sql);
		
		query.setParameter("cidadeID", bundle.getCidade().getId());
		query.setParameter("inicio", bundle.getDataInicio());
		query.setParameter("fim", bundle.getDataFim());
		 
		List<Hotel> availableHotelList =  query.getResultList();
		return availableHotelList;
	}
	
	/**
	 * Method responsible for generation of hotel module report 
	 * @param {@link Hotel} hotel
	 * @return TODO: RETURN COMMENT
	 */
	public List<Hotel> generateHotelReport(Hotel hotel) {
		//TODO: generateHotelReport logic
		return null;
	}
}