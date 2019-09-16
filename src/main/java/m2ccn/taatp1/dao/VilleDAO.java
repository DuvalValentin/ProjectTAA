package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import m2ccn.taatp1.model.Ville;

public class VilleDAO
{
	private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<Ville> query;
	private Root<Ville> villeRoot;
	
	public VilleDAO(EntityManager entityManager)
	{
		this.entityManager=entityManager;
		this.criteriaBuilder=entityManager.getCriteriaBuilder();
		query = criteriaBuilder.createQuery(Ville.class);
		villeRoot = query.from(Ville.class);
	}
	
	public Ville getVilleById(long id)
	{
		ParameterExpression<Long> idParam = criteriaBuilder.parameter(Long.class);
		TypedQuery<Ville> typedQuery = entityManager.createQuery(query.select(villeRoot).where(criteriaBuilder.equal(villeRoot.get("id"), id))).setParameter(idParam, id);
		Ville ville = typedQuery.getSingleResult();
		return ville;
	}
	
	public List<Ville> getVilles()
	{
		TypedQuery<Ville> typedQuery = entityManager.createQuery(query.select(villeRoot));
		List<Ville> villes = typedQuery.getResultList();
		return villes;
	}
}
