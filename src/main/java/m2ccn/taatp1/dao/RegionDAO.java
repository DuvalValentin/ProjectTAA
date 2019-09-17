package m2ccn.taatp1.dao;

import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.dto.RegionDTO;
import m2ccn.taatp1.model.Region;

public class RegionDAO extends DAO<Region>
{
	
	public RegionDAO()
	{
		query = criteriaBuilder.createQuery(Region.class);
		root = query.from(Region.class);
	}

	@Override
	protected Region elementFromDTO(IDTO<Region> elementDTO)
	{
		RegionDTO regionDTO = (RegionDTO) elementDTO;
		return new Region(regionDTO.getName());
	}
	
	
}
