package m2ccn.taatp1.dao;

import m2ccn.taatp1.model.Region;

public class RegionDAO extends DAO<Region>
{
	
	public RegionDAO()
	{
		query = criteriaBuilder.createQuery(Region.class);
		root = query.from(Region.class);
	}
}
