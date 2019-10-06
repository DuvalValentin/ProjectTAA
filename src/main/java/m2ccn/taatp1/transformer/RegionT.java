package m2ccn.taatp1.transformer;

import java.util.ArrayList;
import java.util.List;

import m2ccn.taatp1.dao.DepartementDAO;
import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.dto.RegionCreationTO;
import m2ccn.taatp1.dto.RegionDTO;
import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Region;

public class RegionT extends Transformer<Region>
{
	private DepartementDAO departementDAO;
	
	public RegionT()
	{
		departementDAO=new DepartementDAO();
	}
	

	@Override
	public Region getElementFromDTO(IDTO<Region> elementDTO)
	{
		RegionDTO regionDTO = (RegionDTO) elementDTO;
		List<Departement> departements = new ArrayList<Departement>();
		for (Long id : regionDTO.getIdDepartements())
		{
			departements.add(departementDAO.getById(id));
		}
		Region region = new Region(regionDTO.getName());
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
		RegionDTO regionDTO=new RegionDTO(element.getId(),element.getName(),departementsId);
		return (IDTO<Region>)regionDTO;
	}
}
