package m2ccn.taatp1.dto;

import java.util.List;

import m2ccn.taatp1.model.Ville;

public class VilleTO implements IDTO<Ville>
{
	private long id;
	private String name;
	private long idDepartement;
	private List<Long> idSports;
	
	public VilleTO(){}
	
	public VilleTO(long id, String name,long idDepartement, List<Long> idSports)
	{
		this.id=id;
		this.name=name;
		this.idDepartement=idDepartement;
		this.idSports=idSports;
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

	public Long getIdDepartement()
	{
		return idDepartement;
	}

	public void setIdDepartement(long idDepartement)
	{
		this.idDepartement = idDepartement;
	}

	public List<Long> getIdSports()
	{
		return idSports;
	}

	public void setIdSports(List<Long> idSports)
	{
		this.idSports = idSports;
	}

}
