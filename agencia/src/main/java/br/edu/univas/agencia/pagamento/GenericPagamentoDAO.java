package br.edu.univas.agencia.pagamento;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

abstract class GenericPagamentoDAO <T, PK> {
	protected EntityManager em;

	public GenericPagamentoDAO() {
		this.em = em;
	}
	
	public void salvar(T Entity){
		em.getTransaction().begin();
		em.persist(Entity);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(){
		Query q = em.createQuery("from pagamento" + getTypeClass().getName(), getTypeClass());
		q.getResultList();
	}
	
	private Class<?> getTypeClass() {

		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
		.getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;

	}
	
}
