package br.edu.univas.agencia.hotel;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * This Abstract class is responsible by provide generically data operations to the hotel module.
 * @param <T>
 * @param <PK> 
 */
abstract class GenericHotelDAO <T, PK> {

	protected EntityManager em;

	/**
	 * Default constructor
	 * 
	 * @param {@link EntityManager} em
	 */
	public GenericHotelDAO(EntityManager em) {
		this.em = em;
	}

	/**
	 * Method responsible to save the data of entity generically
	 * 
	 * @param {@link T} entity
	 */
	public void salvar(T entity) {

		em.getTransaction().begin();

		em.persist(entity);

		em.getTransaction().commit();
	}

	/**
	 * Method responsible to update the data of entity generically
	 * 
	 * @param {@link T} entity
	 */
	public void update(T entity) {

		em.getTransaction().begin();

		em.merge(entity);

		em.getTransaction().commit();
	}

	/**
	 * Method responsible to delete the data of entity generically
	 * 
	 * @param {@link T} entity
	 */
	public void delete(T entity) {

		em.getTransaction().begin();

		em.remove(entity);

		em.getTransaction().commit();
	}

	/**
	 * Method responsible to retrieve one hotel object by ID from database generically
	 * 
	 * return {@link List<T>} q
	 *
	 * @param {@link PK} id
	 * 
	 * @return {@link T} entity
	 */
	public T getById(PK id) {

		@SuppressWarnings("unchecked")
		T entity = (T) em.find(getTypeClass(), id);
		return entity;
	}

	/**
	 * Method responsible to retrieve all hotel objects from database generically
	 * 
	 * return {@link List<T>} q
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query q = em.createQuery("from " + getTypeClass().getName(),
				getTypeClass());
		return q.getResultList();
	}

    /**
     * Method responsible for providing good behavior to the class
     * 
     * @return {@link Class<?>} clazz
     */
	private Class<?> getTypeClass() {

		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
		.getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;

	}

}
