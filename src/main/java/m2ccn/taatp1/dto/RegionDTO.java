package m2ccn.taatp1.dto;

import java.util.List;

import m2ccn.taatp1.model.Region;

public class RegionDTO implements IDTO<Region>
{
	public RegionDTO(){}
	
	private long id;
	private String name;
	private List<Long> idDepartements;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public List<Long> getIdDepartements()
	{
		return idDepartements;
	}
	public void setIdDepartements(List<Long> idDepartements)
	{
		this.idDepartements = idDepartements;
	}
}
