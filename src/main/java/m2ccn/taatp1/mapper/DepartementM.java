package m2ccn.taatp1.mapper;

import java.util.ArrayList;
import java.util.List;

import m2ccn.taatp1.dao.IDAO;
import m2ccn.taatp1.dao.RegionAO;
import m2ccn.taatp1.dao.VilleAO;
import m2ccn.taatp1.dto.DepartementCreationTO;
import m2ccn.taatp1.dto.DepartementTO;
import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Region;
import m2ccn.taatp1.model.Ville;

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
