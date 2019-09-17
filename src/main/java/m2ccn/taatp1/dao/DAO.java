package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public abstract class DAO<Element> implements IDAO<Element>
{
	
	protected EntityManager entityManager;
	protected CriteriaBuilder criteriaBuilder;
	protected CriteriaQuery<Element> query;
	protected Root<Element> root;
	
	public DAO()
	{
		this.entityManager=EntityManagerHelper.getEntityManager();
		criteriaBuilder=entityManager.getCriteriaBuilder();
	}
	@Override
	public Element getById(long id)
	{
		ParameterExpression<Long> idParam = criteriaBuilder.parameter(Long.class);
		TypedQuery<Element> typedQuery = entityManager.createQuery(query.select(root).where(criteriaBuilder.equal(root.get("id"), id))).setParameter(idParam, id);
		Element element = typedQuery.getSingleResult();
		return element;
	}

	@Override
	public List<Element> getAll()
	{
		TypedQuery<Element> typedQuery = entityManager.createQuery(query.select(root));
		List<Element> elements = typedQuery.getResultList();
		return elements;
	}

}
