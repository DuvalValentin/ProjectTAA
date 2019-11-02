package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.ParameterExpression;

import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Ville;

public class VilleDAO extends DAO<Ville>
{
	public VilleDAO()
	{
		query = criteriaBuilder.createQuery(Ville.class);
		root = query.from(Ville.class);
	}
	
	public List<Ville> getByDepartement(Departement departement)
	{
		ParameterExpression<Departement> param = criteriaBuilder.parameter(Departement.class);
		TypedQuery<Ville> typedQuery = entityManager.createQuery(query.select(root).where(criteriaBuilder.equal(root.get("departement"), param))).setParameter(param, departement);
		List<Ville> villes = typedQuery.getResultList();
		return villes;
	}
}