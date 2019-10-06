package m2ccn.taatp1.dto;

public class VilleCreationTO implements ICreationDTO
{
	private String name;
	private long idDepartement;
	
	public VilleCreationTO(){}
	
	public VilleCreationTO(String name,long idDepartement)
	{
		this.name=name;
		this.idDepartement=idDepartement;
	}

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

	public long getIdDepartement()
	{
		return idDepartement;
	}

	public void setIdDepartement(long idDepartement)
	{
		this.idDepartement = idDepartement;
	}
}