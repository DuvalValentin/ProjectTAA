package m2ccn.taatp1.mapper;

import java.util.ArrayList;
import java.util.List;

import m2ccn.taatp1.dao.VilleAO;
import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.dto.SportCreationTO;
import m2ccn.taatp1.dto.SportTO;
import m2ccn.taatp1.model.Sport;
import m2ccn.taatp1.model.Ville;

public class SportM extends Mapper<Sport>
{
	private VilleAO villeAO;
	
	public SportM()
	{
		villeAO=new VilleAO();
	}
	
	@Override
	public Sport getElementFromDTO(IDTO<Sport> elementDTO)
	{
		SportTO sportTO=(SportTO)elementDTO;
		List<Ville> villes = new ArrayList<Ville>();
		for (Long id : sportTO.getIdVilles())
		{
			villes.add(villeAO.getById(id));
		}
		Sport sport = new Sport(sportTO.getId(),sportTO.getName(),villes);
		sport.setVilles(villes);
		return sport;
	}

	@Override
	public Sport getElementFromDTO(ICreationDTO elementDTO)
	{
		SportCreationTO sportTO=(SportCreationTO)elementDTO;
		List<Ville> villes = new ArrayList<Ville>();
		for(Long id:sportTO.getIdVilles())
		{
			villes.add(villeAO.getById(id));
		}
		Sport sport = new Sport(sportTO.getName(),villes);
		return sport;
	}

	@Override
	public IDTO<Sport> getDTOFromElement(Sport element)
	{
		List<Long> villesId = new ArrayList<Long>();
		for(Ville ville : element.getVilles())
		{
			villesId.add(ville.getId());
		}
		SportTO sportTO=new SportTO(element.getId(),element.getName(),villesId);
		return (IDTO<Sport>)sportTO;
	}

}
