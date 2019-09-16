package m2ccn.taatp1.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import m2ccn.taatp1.model.Departement;


public class DepartementDAO
{
	private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<Departement> query;
	private Root<Departement> departementRoot;
	
	public DepartementDAO(EntityManager entityManager)
	{
		this.entityManager=entityManager;
		this.criteriaBuilder=entityManager.getCriteriaBuilder();
		query = criteriaBuilder.createQuery(Departement.class);
		departementRoot = query.from(Departement.class);
	}
	
	public Departement getDepartementById(long id)
	{
		ParameterExpression<Long> idParam = criteriaBuilder.parameter(Long.class);
		TypedQuery<Departement> typedQuery = entityManager.createQuery(query.select(departementRoot).where(criteriaBuilder.equal(departementRoot.get("id"), id))).setParameter(idParam, id);
		Departement departement = typedQuery.getSingleResult();
		return departement;
	}
	
	public List<Departement> getDepartements()
	{
		TypedQuery<Departement> typedQuery = entityManager.createQuery(query.select(departementRoot));
		List<Departement> departements = typedQuery.getResultList();
		return departements;
	}
}
