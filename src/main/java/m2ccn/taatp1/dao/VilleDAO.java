package m2ccn.taatp1.dao;

import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.model.Ville;

public class VilleDAO extends DAO<Ville>
{
	public VilleDAO()
	{
		query = criteriaBuilder.createQuery(Ville.class);
		root = query.from(Ville.class);
	}

	@Override
	protected Ville elementFromDTO(IDTO<Ville> elementDTO)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
