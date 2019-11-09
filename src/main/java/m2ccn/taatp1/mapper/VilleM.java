package m2ccn.taatp1.mapper;

import java.util.ArrayList;
import java.util.List;

import m2ccn.taatp1.dao.DepartementAO;
import m2ccn.taatp1.dao.IDAO;
import m2ccn.taatp1.dao.SportAO;
import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.dto.VilleCreationTO;
import m2ccn.taatp1.dto.VilleTO;
import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Sport;
import m2ccn.taatp1.model.Ville;

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
