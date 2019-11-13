package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import m2ccn.taatp1.model.ModelElement;

public abstract class DAO<E extends ModelElement> implements IDAO<E>
{
	protected EntityManager entityManager;
	protected CriteriaBuilder criteriaBuilder;
	protected CriteriaQuery<E> query;
	protected Root<E> root;
	
	public DAO()
	{
		entityManager=EntityManagerHelper.getEntityManager();
		criteriaBuilder=entityManager.getCriteriaBuilder();
	}
	@Override
	public E getById(long id) throws NoResultException
	{
		ParameterExpression<Long> idParam = criteriaBuilder.parameter(Long.class);
		TypedQuery<E> typedQuery = entityManager.createQuery(query.select(root).where(criteriaBuilder.equal(root.get("id"), idParam))).setParameter(idParam, id);
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
	public E save(E element)
	{
		EntityManagerHelper.beginTransaction();
		try
		{
			EntityManagerHelper.persist(element);
			EntityManagerHelper.commit();
		} catch (Exception e)
		{
			EntityManagerHelper.rollback();
		}
		E savedElement=getById(element.getId());
		return savedElement;
	}
	
	@Override
	public void deleteById(long id)
	{
		EntityManagerHelper.beginTransaction();
		E element = getById(id);
		/*try
		{
			EntityManagerHelper.remove(element);
			EntityManagerHelper.commit();
			
		} catch (Exception e)
		{
			EntityManagerHelper.rollback();
		}*/
		EntityManagerHelper.remove(element);
		EntityManagerHelper.commit();
		
	}
	
	@Override
	public E update(E element)
	{
		EntityManagerHelper.beginTransaction();
		E elementToModify = transpose(element);
		try
		{
			EntityManagerHelper.update(elementToModify);
			EntityManagerHelper.commit();
			
		} catch (Exception e)
		{
			EntityManagerHelper.rollback();
		}
		E modifiedElement = getById(element.getId());
		return modifiedElement;
	}
	
	@Override
	public E transpose(E element)
	{
		E elementToModify = getById(element.getId());
		elementToModify.setName(element.getName());
		return elementToModify;
	}
}