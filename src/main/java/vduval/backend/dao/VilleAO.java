package vduval.backend.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.ParameterExpression;

import vduval.backend.model.Departement;
import vduval.backend.model.Sport;
import vduval.backend.model.Ville;

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
	
	public List<Ville> getByDepartementId(long departementId)
	{
		DepartementAO departementDAO=new DepartementAO();
		Departement departement = departementDAO.getById(departementId);
		return this.getByDepartement(departement);
	}
	
	public List<Ville> getBySport(Sport sport)
	{
		TypedQuery<Ville> typedQuery = entityManager.createQuery
				(
						"SELECT v " + 
						"FROM Ville v " + 
						"JOIN v.sports s " + 
						"WHERE s.id = "+sport.getId(),Ville.class
				);
		List<Ville> villes= typedQuery.getResultList();
		return villes;
	}
	
	public List<Ville> getBySportId(long sportId)
	{
		SportAO sportAO= new SportAO();
		Sport sport = sportAO.getById(sportId);
		return getBySport(sport);
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