package m2ccn.taatp1.dto;

import java.util.List;

public class SportCreationTO implements ICreationDTO
{
	String name;
	private List<Long> idVilles;

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{
		this.name=name;
	}

	public List<Long> getIdVilles()
	{
		return idVilles;
	}

	public void setIdVilles(List<Long> idVilles)
	{
		this.idVilles = idVilles;
	}
}