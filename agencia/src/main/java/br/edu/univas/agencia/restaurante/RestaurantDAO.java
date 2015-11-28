package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Restaurante;
import java.sql.Connection;
import java.util.List;

/**
 * Class responsible by perform operations of restaurant module in data base.
 */
public class RestaurantDAO implements IRestaurantDAO{


    @Override
    public void setConnection(Connection connection) {
        
    }

    @Override
    public int create(Restaurante restaurante) throws AgencyException {
        return 0;
    }

    @Override
    public void update(Restaurante restaurante) throws AgencyException {
        
    }

    @Override
    public void delete(Restaurante restaurante) throws AgencyException {
        
    }

    @Override
    public Restaurante getById(int id) throws AgencyException {
        return null;
    }

    @Override
    public List<Restaurante> getAll() throws AgencyException {
        return null;
    }

    @Override
    public List<Restaurante> getRestaurantsAvailable(int reservations) throws AgencyException {
        return null;
    }

}
