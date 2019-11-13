package m2ccn.taatp1.mapper;

import java.util.ArrayList;
import java.util.List;

import m2ccn.taatp1.dao.DepartementAO;
import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.dto.RegionCreationTO;
import m2ccn.taatp1.dto.RegionTO;
import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Region;

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
