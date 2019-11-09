package m2ccn.taatp1.dto;

public class SportCreationTO implements ICreationDTO
{
	String name;

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
}