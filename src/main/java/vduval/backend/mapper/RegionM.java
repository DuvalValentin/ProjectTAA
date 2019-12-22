package vduval.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import vduval.backend.dao.DepartementAO;
import vduval.backend.dto.ICreationDTO;
import vduval.backend.dto.IDTO;
import vduval.backend.dto.RegionCreationTO;
import vduval.backend.dto.RegionTO;
import vduval.backend.model.Departement;
import vduval.backend.model.Region;

public class RegionM extends Mapper<Region>
{
	private DepartementAO departementAO;
	
	public RegionM()
	{
		departementAO=new DepartementAO();
	}
	

	@Override
	public Region getElementFromDTO(IDTO<Region> elementDTO)
	{
		RegionTO regionDTO = (RegionTO) elementDTO;
		System.err.println(regionDTO.getName());
		System.err.println(regionDTO.getIdDepartements());
		List<Departement> departements = new ArrayList<Departement>();
		for (Long id : regionDTO.getIdDepartements())
		{
			departements.add(departementAO.getById(id));
		}
		Region region = new Region(regionDTO.getId(),regionDTO.getName(),departements);
		return region;
	}
	
	@Override
	public Region getElementFromDTO(ICreationDTO elementDTO)
	{
		RegionCreationTO regionDTO = (RegionCreationTO) elementDTO;
		Region region = new Region(regionDTO.getName());
		return region;
	}

	@Override
	public IDTO<Region> getDTOFromElement(Region element)
	{
		List<Long> departementsId = new ArrayList<Long>();
		for(Departement departement : element.getDepartements())
		{
			departementsId.add(departement.getId());
		}
		RegionTO regionDTO=new RegionTO(element.getId(),element.getName(),departementsId);
		return (IDTO<Region>)regionDTO;
	}
}
