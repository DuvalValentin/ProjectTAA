package vduval.backend.dto;

import java.util.ArrayList;
import java.util.List;

import vduval.backend.model.Region;

public class RegionTO implements IDTO<Region>
{
	private long id;
	private String name;
	private List<Long> idDepartements;
	
	public RegionTO()
	{
		this.idDepartements=new ArrayList<Long>();//FIXME si c'est pas fait les put buguent
	}
	
	public RegionTO(long id,String name, List<Long> idDepartements)
	{
		this.id=id;
		this.name=name;
		this.idDepartements=idDepartements;
	}
	
	
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
