package m2ccn.taatp1.dto;

import m2ccn.taatp1.model.Sport;

public class SportDTO implements IDTO<Sport>
{
	//TODO implémenter ça aussi
	private String name;
	private Long id;

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

}