package m2ccn.taatp1.dto;

public class RegionCreationTO implements ICreationDTO
{
	private String name;
	
	public RegionCreationTO(){}
	
	public RegionCreationTO(String name)
	{
		this.name=name;
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
}