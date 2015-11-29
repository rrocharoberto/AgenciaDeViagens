/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.model.RestauranteReserva;
import javax.persistence.EntityManager;


public class RestaurantReservationDAO extends GenericDAO<RestauranteReserva, Long> implements IRestaurantReservationDAO{
    
    EntityManager entityManager;

    public RestaurantReservationDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
