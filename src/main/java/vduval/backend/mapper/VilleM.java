package vduval.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import vduval.backend.dao.DepartementAO;
import vduval.backend.dao.IDAO;
import vduval.backend.dao.SportAO;
import vduval.backend.dto.ICreationDTO;
import vduval.backend.dto.IDTO;
import vduval.backend.dto.VilleCreationTO;
import vduval.backend.dto.VilleTO;
import vduval.backend.model.Departement;
import vduval.backend.model.Sport;
import vduval.backend.model.Ville;

public class VilleM extends Mapper<Ville>
{
	private IDAO<Departement> departementAO;
	private IDAO<Sport> sportAO;
	
	public VilleM()
	{
		departementAO = new DepartementAO();
		sportAO=new SportAO();
	}

	@Override
	public Ville getElementFromDTO(IDTO<Ville> elementDTO)
	{
		VilleTO villeDTO = (VilleTO) elementDTO;
		List<Sport> sports = new ArrayList<Sport>();
		for(long idSport : villeDTO.getIdSports())
		{
			sports.add(sportAO.getById(idSport));
		}
		System.err.println(villeDTO.getId());
		Ville ville = new Ville(villeDTO.getId(),villeDTO.getName(),departementAO.getById(villeDTO.getIdDepartement()),sports);
		return ville;
	}
	
	@Override
	public Ville getElementFromDTO(ICreationDTO elementDTO)
	{
		VilleCreationTO villeDTO = (VilleCreationTO) elementDTO;
		Ville ville = new Ville(villeDTO.getName(),departementAO.getById(villeDTO.getIdDepartement()));
		return ville;
	}

	@Override
	public IDTO<Ville> getDTOFromElement(Ville ville)
	{
		List<Long> sportsId = new ArrayList<Long>();
		for(Sport sport : ville.getSports())
		{
			sportsId.add(sport.getId());
		}
		VilleTO villeTO = new VilleTO(ville.getId(), ville.getName(), ville.getDepartement().getId(), sportsId);		
		return villeTO;
	}

	

}
