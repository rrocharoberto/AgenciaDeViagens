package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import java.util.List;

/**
 * Class responsible by perform operations in the restaurant module data.
 */
public class RestaurantRepository implements IRestaurantRepository{

    @Override
    public Restaurante create(Restaurante restaurante) throws AgencyException {
        return null;
    }

    @Override
    public Restaurante update(Restaurante restaurante) throws AgencyException {
        return null;
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
    public List<Restaurante> getRestaurantsAvailable(Pacote pacote) throws AgencyException {
        return null;
    }

}
