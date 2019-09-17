package m2ccn.taatp1.dao;

import m2ccn.taatp1.dto.DepartementDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.model.Departement;

public class DepartementDAO extends DAO<Departement>
{
	
	public DepartementDAO()
	{
		query = criteriaBuilder.createQuery(Departement.class);
		root = query.from(Departement.class);
	}

	@Override
	protected Departement elementFromDTO(IDTO<Departement> elementDTO)
	{
		DepartementDTO departementDTO= (DepartementDTO) elementDTO;//FIXME ça pas joli
		return new Departement(departementDTO.getName(), new RegionDAO().getById(departementDTO.getIdRegion()));
	}
}
