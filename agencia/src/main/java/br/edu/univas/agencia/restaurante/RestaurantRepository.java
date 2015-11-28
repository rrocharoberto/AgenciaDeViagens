package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import java.util.List;
import javax.persistence.EntityManager;
import util.HibernateUtil;

/**
 * Class responsible by perform operations in the restaurant module data.
 */
public class RestaurantRepository implements IRestaurantRepository{

    private IRestaurantDAO restaurantDAO;
    private EntityManager entityManager;
    
    /**
     * Initialize variables necessary for the operation of the class
     */
    public RestaurantRepository() {
        entityManager = HibernateUtil.getEntityManager();
        restaurantDAO = new RestaurantDAO(entityManager);
    }
    /**
     * Method responsible for saving the entity
     * @param restaurante
     * @throws AgencyException 
     */
    @Override
    public void create(Restaurante restaurante) throws AgencyException {
        restaurantDAO.save(restaurante);
    }

    /**
     * Method responsible for updating the entity
     * @param restaurante
     * @throws AgencyException 
     */
    @Override
    public void update(Restaurante restaurante) throws AgencyException {
        restaurantDAO.update(restaurante);        
    }

    /**
     * Method responsible to obtain entity by id
     * @param id
     * @return
     * @throws AgencyException 
     */
    @Override
    public Restaurante getById(int id) throws AgencyException {
        return restaurantDAO.getById(id);
    }

    /**
     * Method responsible to obtain all the entities
     * @return
     * @throws AgencyException 
     */
    @Override
    public List<Restaurante> getAll() throws AgencyException {
        return restaurantDAO.getAll();
    }

    /**
     * Method responsible to obtain the list of restaurants and the sum of scheduled vacancies for him
     * @param pacote
     * @return
     * @throws AgencyException 
     */
    @Override
    public List<Restaurante> getRestaurantsAvailable(Pacote pacote) throws AgencyException {
        return restaurantDAO.getRestaurantsAvailable(pacote.getDataInicio(), pacote.getDataFim(), pacote.getCidade().getId());
    }

}
