package m2ccn.taatp1.dao;

import m2ccn.taatp1.model.Region;

public class RegionAO extends DAO<Region>
{
	
	public RegionAO()
	{
		query = criteriaBuilder.createQuery(Region.class);
		root = query.from(Region.class);
	}
	
	@Override
	public Region transpose(Region region)
	{
		Region regionToModify = super.transpose(region);
		//regionToModify.setDepartements(region.getDepartements());Ne change rien au résultat => à conserver
		return regionToModify;
	}
}
