package vduval.backend.dto;

public class DepartementCreationTO implements ICreationDTO
{
	private String name;
	private long idRegion;
	
	public DepartementCreationTO() {}
	
	public DepartementCreationTO(String name,long idRegion)
	{
		this.name=name;
		this.idRegion=idRegion;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public void setName(String name)
	{
		this.name=name;
	}
	
	public Long getIdRegion()
	{
		return idRegion;
	}

	public void setIdRegion(long idRegion)
	{
		this.idRegion = idRegion;
	}
}