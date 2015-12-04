package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Restaurante;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Class responsible by perform operations of restaurant module in data base.
 */
public class RestaurantDAO extends GenericDAO<Restaurante, Long> implements IRestaurantDAO {

    public RestaurantDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Method responsible to obtain the list of restaurants and the sum of scheduled vacancies for him
     * @param inicio
     * @param fim
     * @param idCidade
     * @return
     * @throws AgencyException
     */
    @Override
    public Map<Restaurante, Float> getRestaurantsAvailable(Date inicio, Date fim, int idCidade) throws AgencyException {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        String sql = "select "
                + "re.id, re.nome, re.numero_vagas, re.valor, re.cidade_id "
                + ", sum(p.quantidade_pessoas) as soma "
                + "from restaurante re "
                + "left join restaurante_reserva rr on rr.restaurante_id = re.id "
                + "left join pacote p on p.id = rr.pacote_id "
                + "where (rr.data_reserva between '" + df.format(inicio) + "' and '" + df.format(fim) + "' or rr.data_reserva is null) "
                + "and re.cidade_id = " + idCidade 
                + " group by re.id, re.nome, re.numero_vagas, re.valor, re.cidade_id";
 
        Map<Restaurante, Float> reserveList = new HashMap<Restaurante, Float>();
        Query q = em.createNativeQuery(sql);
        List<Object[]> result = q.getResultList();
        
        for (Object[] register : result) {
            Restaurante re = new Restaurante();
            Float value;
            
            re.setId(Integer.parseInt(register[0].toString()));
            re.setNome(register[1].toString());
            re.setNumeroVagas(Integer.parseInt(register[2].toString()));
            re.setValor(Float.parseFloat(register[3].toString()));
            value = Float.parseFloat(register[5].toString());
            reserveList.put(re, value);
        }
        
        
        return reserveList;
    }

    /**
     * Method responsible for get the restaurant by id
     * @param id
     * @return 
     */
    @Override
    public Restaurante getById(int id) {

        String sql = "Select * from restaurante re where  re.id = :idRestaurante";
        Query query = em.createQuery(sql);
        query.setParameter("idCidade", id);
        return (Restaurante) query.getSingleResult();
    }

}
