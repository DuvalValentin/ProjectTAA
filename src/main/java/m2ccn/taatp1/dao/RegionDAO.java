package m2ccn.taatp1.dao;

import javax.persistence.EntityManager;

import m2ccn.taatp1.dto.RegionDTO;
import m2ccn.taatp1.model.Region;

public class RegionDAO extends DAO<Region>
{
	
	public RegionDAO(EntityManager entityManager)
	{
		super(entityManager);
		query = criteriaBuilder.createQuery(Region.class);
		root = query.from(Region.class);
	}

	public Region save(RegionDTO regionDTO)
	{
		Region region = new Region(regionDTO.getName());
		entityManager.persist(region);
		return region;
	}
}
