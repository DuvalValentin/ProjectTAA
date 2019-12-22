package vduval.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import vduval.backend.dao.IDAO;
import vduval.backend.dao.RegionAO;
import vduval.backend.dao.VilleAO;
import vduval.backend.dto.DepartementCreationTO;
import vduval.backend.dto.DepartementTO;
import vduval.backend.dto.ICreationDTO;
import vduval.backend.dto.IDTO;
import vduval.backend.model.Departement;
import vduval.backend.model.Region;
import vduval.backend.model.Ville;

public class DepartementM extends Mapper<Departement>
{
	
	private IDAO<Region> regionAO;
	private IDAO<Ville> villeAO;
	
	public DepartementM()
	{
		regionAO=new RegionAO();
		villeAO=new VilleAO();
	}

	@Override
	public Departement getElementFromDTO(IDTO<Departement> elementDTO)
	{
		DepartementTO departementDTO = (DepartementTO) elementDTO;
		List<Ville> villes = new ArrayList<Ville>();
		for (Long id : departementDTO.getIdVilles())
		{
			villes.add(villeAO.getById(id));
		}
		Departement departement = new Departement(departementDTO.getId(),departementDTO.getName(),regionAO.getById(departementDTO.getIdRegion()),villes);
		return departement;
	}
	
	@Override
	public Departement getElementFromDTO(ICreationDTO elementDTO)
	{
		DepartementCreationTO departementDTO = (DepartementCreationTO) elementDTO;
		Departement departement = new Departement(departementDTO.getName(),regionAO.getById(departementDTO.getIdRegion()));
		return departement;
	}

	@Override
	public IDTO<Departement> getDTOFromElement(Departement element)
	{
		List<Long> villesId = new ArrayList<Long>();
		for(Ville ville : element.getVilles())
		{
			villesId.add(ville.getId());
		}
		DepartementTO departementDTO=new DepartementTO(element.getId(),element.getName(),element.getRegion().getId(),villesId);
		return departementDTO;
	}

	

}
