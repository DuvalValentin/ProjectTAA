package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import m2ccn.taatp1.model.Sport;

public class SportDAO
{
	private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<Sport> query;
	private Root<Sport> sportRoot;
	
	public SportDAO(EntityManager entityManager)
	{
		this.entityManager=entityManager;
		this.criteriaBuilder=entityManager.getCriteriaBuilder();
		query = criteriaBuilder.createQuery(Sport.class);
		sportRoot = query.from(Sport.class);
	}
	
	public Sport getSportById(long id)
	{
		ParameterExpression<Long> idParam = criteriaBuilder.parameter(Long.class);
		TypedQuery<Sport> typedQuery = entityManager.createQuery(query.select(sportRoot).where(criteriaBuilder.equal(sportRoot.get("id"), id))).setParameter(idParam, id);
		Sport sport = typedQuery.getSingleResult();
		return sport;
	}
	
	public List<Sport> getSports()
	{
		TypedQuery<Sport> typedQuery = entityManager.createQuery(query.select(sportRoot));
		List<Sport> sports = typedQuery.getResultList();
		return sports;
	}


}
