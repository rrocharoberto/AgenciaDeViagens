package br.edu.univas.agencia.agencia.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDAO<T, Integer> {

	public void save(T object, EntityManager em) {
		em.persist(object);
	}

	public T getById(Integer id, EntityManager em) {
		T entity = (T) em.find(getTypeClass(), id);
		return entity;
	}
	
	@SuppressWarnings ("unchecked")	
	public List<T> getAll(EntityManager em){
		Query q = em.createQuery(" from " + getTypeClass().getName(), getTypeClass());
		return q.getResultList();
	}
	
	public Class<T> getTypeClass(){
		@SuppressWarnings ("unchecked")	
		Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];	
		return clazz;	
	}
}
