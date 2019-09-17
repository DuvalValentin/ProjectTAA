package m2ccn.taatp1.dao;

import javax.persistence.EntityManager;

import m2ccn.taatp1.dto.DepartementDTO;
import m2ccn.taatp1.model.Departement;


public class DepartementDAO extends DAO<Departement>
{
	
	public DepartementDAO(EntityManager entityManager)
	{
		super(entityManager);
		query = criteriaBuilder.createQuery(Departement.class);
		root = query.from(Departement.class);
	}
	
	public Departement save(DepartementDTO departementDTO)
	{
		Departement departement = new Departement(departementDTO.getName(), new RegionDAO(entityManager).getById(departementDTO.getId()));
		entityManager.persist(departement);
		return departement;
	}
}
