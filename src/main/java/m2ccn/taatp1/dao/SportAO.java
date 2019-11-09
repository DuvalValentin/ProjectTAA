package m2ccn.taatp1.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.ParameterExpression;

import m2ccn.taatp1.model.Sport;
import m2ccn.taatp1.model.Ville;

public class SportAO extends DAO<Sport>
{
	public SportAO()
	{
		query = criteriaBuilder.createQuery(Sport.class);
		root = query.from(Sport.class);
	}
	
	public List<Sport> getByVille(Ville ville)
	{
		ParameterExpression<Ville> param = criteriaBuilder.parameter(Ville.class);
		TypedQuery<Sport> typedQuery = entityManager.createQuery(query.select(root).where(criteriaBuilder.equal(root.get("ville"),param))).setParameter(param, ville);
		List<Sport> sports = typedQuery.getResultList();
		return sports;
	}
	
	@Override
	public Sport transpose(Sport sport)
	{
		Sport sportToModify=super.transpose(sport);
		sportToModify.setVilles(sport.getVilles());
		return sportToModify;
	}
}