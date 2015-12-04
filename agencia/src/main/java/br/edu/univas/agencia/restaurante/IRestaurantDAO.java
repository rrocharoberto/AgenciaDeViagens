/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Restaurante;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IRestaurantDAO {
    
    public void save(Restaurante entity) throws AgencyException;
    
    public void update(Restaurante entity) throws AgencyException;
    
    public Restaurante getById(int id) throws AgencyException;
    
    public List<Restaurante> getAll() throws AgencyException;
    
    public Map<Restaurante, Float> getRestaurantsAvailable(Date inicio, Date fim, int idCidade) throws AgencyException;
    
}
