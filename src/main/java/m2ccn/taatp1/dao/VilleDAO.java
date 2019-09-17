package m2ccn.taatp1.dao;

import javax.persistence.EntityManager;
import m2ccn.taatp1.model.Ville;

public class VilleDAO extends DAO<Ville>
{
	
	public VilleDAO(EntityManager entityManager)
	{
		super(entityManager);
		query = criteriaBuilder.createQuery(Ville.class);
		root = query.from(Ville.class);
	}
}
