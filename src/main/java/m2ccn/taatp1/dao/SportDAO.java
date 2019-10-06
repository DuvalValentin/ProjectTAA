package m2ccn.taatp1.dao;

import m2ccn.taatp1.model.Sport;

public class SportDAO extends DAO<Sport>
{
	public SportDAO()
	{
		query = criteriaBuilder.createQuery(Sport.class);
		root = query.from(Sport.class);
	}
}