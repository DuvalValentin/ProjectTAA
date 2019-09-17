package m2ccn.taatp1.dto;

public class IdDTO
{
	public IdDTO(){}
	
	public IdDTO(long id)
	{
		this.id=id;
	}
	
	private long id;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

}
