/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Restaurante;
import java.sql.Connection;
import java.util.List;

public interface IRestaurantDAO {
    
    public void setConnection(Connection connection);

    public int create(Restaurante restaurante) throws AgencyException;

    public void update(Restaurante restaurante) throws AgencyException;

    public void delete(Restaurante restaurante) throws AgencyException;

    public Restaurante getById(int id) throws AgencyException;

    public List<Restaurante> getAll() throws AgencyException;

    public List<Restaurante> getRestaurantsAvailable(int reservations) throws AgencyException;
    
}
