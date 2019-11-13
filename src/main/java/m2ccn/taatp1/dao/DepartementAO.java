package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.ParameterExpression;

import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Region;

public class DepartementAO extends DAO<Departement>
{
	public DepartementAO()
	{
		query = criteriaBuilder.createQuery(Departement.class);
		root = query.from(Departement.class);
	}
	
	public List<Departement> getByRegion(Region region)
	{
		ParameterExpression<Region> param = criteriaBuilder.parameter(Region.class);
		TypedQuery<Departement> typedQuery = entityManager.createQuery(query.select(root).where(criteriaBuilder.equal(root.get("region"), param))).setParameter(param, region);
		List<Departement> departements = typedQuery.getResultList();
		return departements;
	}
	
	public List<Departement>getByRegionId(long regionId)
	{
		RegionAO regionDAO=new RegionAO();
		Region region = regionDAO.getById(regionId);
		return this.getByRegion(region);

	}
	
	@Override
	public Departement transpose (Departement departement)
	{
		Departement departmentToModify = super.transpose(departement);
		departmentToModify.setRegion(departement.getRegion());
		//departmentToModify.setVilles(departement.getVilles());Ne change rien au résultat => à conserver
		return departmentToModify;
	}
}