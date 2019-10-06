package m2ccn.taatp1.dao;

import m2ccn.taatp1.model.Departement;

public class DepartementDAO extends DAO<Departement>
{
	public DepartementDAO()
	{
		query = criteriaBuilder.createQuery(Departement.class);
		root = query.from(Departement.class);
	}
}