package m2ccn.taatp1.dao;

import m2ccn.taatp1.dto.RegionDTO;
import m2ccn.taatp1.model.Region;

public class RegionDAO extends DAO<Region>
{
	
	public RegionDAO()
	{
		query = criteriaBuilder.createQuery(Region.class);
		root = query.from(Region.class);
	}

	public Region save(RegionDTO regionDTO)
	{
		EntityManagerHelper.beginTransaction();
		Region region = new Region(regionDTO.getName());
		entityManager.persist(region);
		EntityManagerHelper.commit();
		System.out.println("done");
		return region;
	}
}
