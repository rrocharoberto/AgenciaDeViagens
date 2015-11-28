package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Restaurante;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Class responsible by perform operations of restaurant module in data base.
 */
public class RestaurantDAO extends GenericDAO<Restaurante, Long> implements IRestaurantDAO{
    
    EntityManager entityManager;

    public RestaurantDAO(EntityManager entityManager) {
        super(entityManager);
    }
/**
 * 
 * @param inicio
 * @param fim
 * @param idCidade
 * @return
 * @throws AgencyException
 */
    @Override
    public List<Restaurante> getRestaurantsAvailable(Date inicio, Date fim, int idCidade) throws AgencyException {
     String sql = "select re.*\n" +
        "	, sum(p.quantidade_pessoas) as soma\n" +
        "from pacote p\n" +
        "join restaurante_reserva rr on p.id = rr.pacote_id\n" +
        "join restaurante re on re.id = rr.restaurante_id\n" +
        "join cidade ci on ci.id = :cidade_id\n" +
        "where rr.data_reserva between :inicio and :fim\n" +
        "and re.cidade_id = 1\n" +
        "group by re.id, re.nome, re.numero_vagas, re.valor, re.cidade_id";  
     return null;
     //TODO: not implemented.  Verificar como fazer isso via nativo usando Hibernate...
        
    }

    @Override
    public Restaurante getById(int id) {
        
        String sql = "Select * from restaurante re where  re.id = :idRestaurante";
        Query query = entityManager.createQuery(sql);
	query.setParameter("idCidade", id);
        return (Restaurante) query.getSingleResult();
    }


}
