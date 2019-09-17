package m2ccn.taatp1.dao;

import m2ccn.taatp1.dto.DepartementDTO;
import m2ccn.taatp1.model.Departement;

public class DepartementDAO extends DAO<Departement>
{
	
	public DepartementDAO()
	{
		query = criteriaBuilder.createQuery(Departement.class);
		root = query.from(Departement.class);
	}
	
	public Departement save(DepartementDTO departementDTO)
	{
		EntityManagerHelper.beginTransaction();
		Departement departement = new Departement(departementDTO.getName(), new RegionDAO().getById(departementDTO.getIdRegion()));
		entityManager.persist(departement);
		entityManager.getTransaction().commit();
		return departement;
	}
}
