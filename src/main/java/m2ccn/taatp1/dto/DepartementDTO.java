package m2ccn.taatp1.dto;

import java.util.List;

import m2ccn.taatp1.model.Departement;

public class DepartementDTO extends DepartementCreationTO implements IDTO<Departement>
{
	private long id;
	private String name;
	private long idRegion;
	private List<Long> idVilles;
	
	public DepartementDTO(){}
	
	public DepartementDTO(long id, String name,long idRegion, List<Long> idVilles)
	{
		this.id=id;
		this.name=name;
		this.idRegion=idRegion;
		this.idVilles=idVilles;
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

	public Long getIdRegion()
	{
		return idRegion;
	}

	public void setIdRegion(long idRegion)
	{
		this.idRegion = idRegion;
	}

	public List<Long> getIdVilles()
	{
		return idVilles;
	}

	public void setIdVilles(List<Long> idVilles)
	{
		this.idVilles = idVilles;
	}
	
	@Override
	public String toString()
	{
		return("Name : "+name+" Villes : "+idVilles);
	}
}
