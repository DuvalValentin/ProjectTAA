package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import m2ccn.taatp1.model.Region;

public class RegionDAO
{
	private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<Region> query;
	private Root<Region> regionRoot;
	
	public RegionDAO(EntityManager entityManager)
	{
		this.entityManager=entityManager;
		this.criteriaBuilder=entityManager.getCriteriaBuilder();
		query = criteriaBuilder.createQuery(Region.class);
		regionRoot = query.from(Region.class);
	}
	
	public Region getRegionById(long id)
	{
		ParameterExpression<Long> idParam = criteriaBuilder.parameter(Long.class);
		TypedQuery<Region> typedQuery = entityManager.createQuery(query.select(regionRoot).where(criteriaBuilder.equal(regionRoot.get("id"), id))).setParameter(idParam, id);
		Region region = typedQuery.getSingleResult();
		return region;
	}
	
	public List<Region> getRegions()
	{
		TypedQuery<Region> typedQuery = entityManager.createQuery(query.select(regionRoot));
		List<Region> regions = typedQuery.getResultList();
		return regions;
	}
}
