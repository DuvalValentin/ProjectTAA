package m2ccn.taatp1.dao;

import javax.persistence.EntityManager;
import m2ccn.taatp1.model.Sport;

public class SportDAO extends DAO<Sport>
{
	public SportDAO(EntityManager entityManager)
	{
		super(entityManager);
		query = criteriaBuilder.createQuery(Sport.class);
		root = query.from(Sport.class);
	}
}
