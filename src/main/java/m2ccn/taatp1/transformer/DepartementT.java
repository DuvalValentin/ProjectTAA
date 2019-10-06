package m2ccn.taatp1.transformer;

import java.util.ArrayList;
import java.util.List;

import m2ccn.taatp1.dao.IDAO;
import m2ccn.taatp1.dao.RegionDAO;
import m2ccn.taatp1.dao.VilleDAO;
import m2ccn.taatp1.dto.DepartementCreationTO;
import m2ccn.taatp1.dto.DepartementDTO;
import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Region;
import m2ccn.taatp1.model.Ville;

public class DepartementT extends Transformer<Departement>
{
	
	private IDAO<Region> regionDAO;
	private IDAO<Ville> villeDAO;
	
	public DepartementT()
	{
		regionDAO=new RegionDAO();
		villeDAO=new VilleDAO();
	}

	@Override
	public Departement getElementFromDTO(IDTO<Departement> elementDTO)
	{
		DepartementDTO departementDTO = (DepartementDTO) elementDTO;
		List<Ville> villes = new ArrayList<Ville>();
		for (Long id : departementDTO.getIdVilles())
		{
			villes.add(villeDAO.getById(id));
		}
		Departement departement = new Departement(departementDTO.getId(),departementDTO.getName(),regionDAO.getById(departementDTO.getIdRegion()),villes);
		return departement;
	}
	
	@Override
	public Departement getElementFromDTO(ICreationDTO elementDTO)
	{
		DepartementCreationTO departementDTO = (DepartementCreationTO) elementDTO;
		Departement departement = new Departement(departementDTO.getName(),regionDAO.getById(departementDTO.getIdRegion()));
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
		DepartementDTO departementDTO=new DepartementDTO(element.getId(),element.getName(),element.getRegion().getId(),villesId);
		return departementDTO;
	}

	

}
