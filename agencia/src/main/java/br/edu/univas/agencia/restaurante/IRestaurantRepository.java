/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import java.util.List;

public interface IRestaurantRepository {
    
    public Restaurante create(Restaurante restaurante) throws AgencyException;

    public Restaurante update(Restaurante restaurante) throws AgencyException;

    public Restaurante getById(int id) throws AgencyException;

    public List<Restaurante> getAll() throws AgencyException;

    public List<Restaurante> getRestaurantsAvailable(Pacote pacote) throws AgencyException;

    
}
