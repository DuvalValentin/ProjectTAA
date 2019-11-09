package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.ParameterExpression;

import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Ville;

public class VilleAO extends DAO<Ville>
{
	public VilleAO()
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
	
	@Override
	public Ville transpose(Ville ville)
	{
		Ville villeToModify = super.transpose(ville);
		villeToModify.setDepartement(ville.getDepartement());
		//villeToModify.setSports(ville.getSports()); Ne change rien au résultat => à conserver
		return villeToModify;
	}
}