package m2ccn.taatp1.dto;

import java.util.List;

import m2ccn.taatp1.model.Sport;

public class SportTO implements IDTO<Sport>
{
	//TODO implémenter ça aussi
	private long id;
	private String name;
	private List<Long> idVilles;
	
	public SportTO(){}
	
	

	public SportTO(long id,String name,  List<Long> idSports)
	{
		this.name = name;
		this.id = id;
		this.idVilles = idSports;
	}



	@Override
	public void setName(String name)
	{
		this.name=name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setId(long id)
	{
		this.id=id;
	}

	@Override
	public long getId()
	{
		return id;
	}

	public List<Long> getIdVilles()
	{
		return idVilles;
	}

	public void setIdVilles(List<Long> idSports)
	{
		this.idVilles = idSports;
	}

}