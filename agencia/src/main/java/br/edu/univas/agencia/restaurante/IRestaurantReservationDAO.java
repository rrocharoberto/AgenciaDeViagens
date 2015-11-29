/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.model.RestauranteReserva;


public interface IRestaurantReservationDAO{
    
    public void save(RestauranteReserva entity);
    
    public void update(RestauranteReserva entity);
    
}
