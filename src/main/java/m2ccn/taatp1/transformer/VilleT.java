package m2ccn.taatp1.transformer;

import java.util.ArrayList;
import java.util.List;

import m2ccn.taatp1.dao.DepartementDAO;
import m2ccn.taatp1.dao.IDAO;
import m2ccn.taatp1.dao.SportDAO;
import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.dto.VilleCreationTO;
import m2ccn.taatp1.dto.VilleDTO;
import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Sport;
import m2ccn.taatp1.model.Ville;

public class VilleT extends Transformer<Ville>
{
	private IDAO<Departement> departementDAO;
	private IDAO<Sport> sportAO;
	
	public VilleT()
	{
		departementDAO = new DepartementDAO();
		sportAO=new SportDAO();
	}

	@Override
	public Ville getElementFromDTO(IDTO<Ville> elementDTO)
	{
		VilleDTO villeDTO = (VilleDTO) elementDTO;
		List<Sport> sports = new ArrayList<Sport>();
		for(long idSport : villeDTO.getIdSports())
		{
			sports.add(sportAO.getById(idSport));
		}
		Ville ville = new Ville(villeDTO.getId(),villeDTO.getName(),departementDAO.getById(villeDTO.getIdDepartement()),sports);
		return ville;
	}
	
	@Override
	public Ville getElementFromDTO(ICreationDTO elementDTO)
	{
		VilleCreationTO villeDTO = (VilleCreationTO) elementDTO;
		Ville ville = new Ville(villeDTO.getName(),departementDAO.getById(villeDTO.getIdDepartement()));
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
		VilleDTO villeTO = new VilleDTO(ville.getId(), ville.getName(), ville.getDepartement().getId(), sportsId);		
		return villeTO;
	}

	

}
