/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.univas.agencia.restaurante;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Class responsible by perform operations in the restaurant module data generically.
 * @param <T>
 * @param <PK> 
 */
public class GenericDAO<T, PK> {

	// <T, PK> T-type,PK-primary key

	protected EntityManager em;

        /**
         * Set the parameter to correctly class operation 
         * @param em 
         */
	public GenericDAO(EntityManager em) {
		this.em = em;
	}
	
        /**
         * Method responsible for saving the data of entity generically
         * @param entity 
         */
	public void save(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

        /**
         * Method responsible for updating the data of entity generically
         * @param entity 
         */
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}
        
        /**
         * Method responsible for deleting the data of entity generically, if should it be used in the future
         * @param entity 
         */
	public void delete(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

        /**
         * Method responsible for obtaining the entity data generically by id
         * @param id
         * @return 
         */
	public T getById(PK id) {
		@SuppressWarnings("unchecked")
		T entity = (T) em.find(getTypeClass(), id);
		return entity;
	}

        /**
         * Method responsible for obtaining all the entities data generically
         * @return 
         */
	@SuppressWarnings ("unchecked")
	 public List <T> getAll () {
		 Query q = em.createQuery (" from " + getTypeClass () . getName () ,getTypeClass () ) ;
		 return q . getResultList () ;
	 }

         /**
          * Method responsible for proper functioning of the class
          * @return 
          */
	public Class<T> getTypeClass(){
		@SuppressWarnings ("unchecked")	
		Class<T> clazz = (Class<T>) ((java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];	
		return clazz;	
	}
}