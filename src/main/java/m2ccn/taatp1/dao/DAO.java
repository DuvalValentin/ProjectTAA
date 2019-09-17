package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import m2ccn.taatp1.dto.IDTO;

public abstract class DAO<E> implements IDAO<E>
{
	
	protected EntityManager entityManager;
	protected CriteriaBuilder criteriaBuilder;
	protected CriteriaQuery<E> query;
	protected Root<E> root;
	
	public DAO()
	{
		this.entityManager=EntityManagerHelper.getEntityManager();
		criteriaBuilder=entityManager.getCriteriaBuilder();
	}
	@Override
	public E getById(long id)
	{
		ParameterExpression<Long> idParam = criteriaBuilder.parameter(Long.class);
		TypedQuery<E> typedQuery = EntityManagerHelper.getEntityManager().createQuery(query.select(root).where(criteriaBuilder.equal(root.get("id"), idParam))).setParameter(idParam, id);
		E element = typedQuery.getSingleResult();
		return element;
	}

	@Override
	public List<E> getAll()
	{
		TypedQuery<E> typedQuery = entityManager.createQuery(query.select(root));
		List<E> elements = typedQuery.getResultList();
		return elements;
	}
	
	@Override
	public E save(IDTO<E> elementDTO)
	{
		EntityManagerHelper.beginTransaction();
		E element = elementFromDTO(elementDTO);
		EntityManagerHelper.persist(element);
		EntityManagerHelper.commit();
		return element;
	}
	
	public void deleteById(long id)
	{
		EntityManagerHelper.beginTransaction();
		E element = getById(id);
		EntityManagerHelper.remove(element);
		EntityManagerHelper.commit();
		//return element;
	}
	
	protected abstract E elementFromDTO(IDTO<E> elementDTO);
	
	

}
