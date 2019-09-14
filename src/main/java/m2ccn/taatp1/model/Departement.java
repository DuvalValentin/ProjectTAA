package m2ccn.taatp1.model;

import java.util.HashSet;

import javax.persistence.*;

@Entity
public class Departement 
{
	private long id;
	private Region region;
	private HashSet<Ville> villes;

	@OneToMany
	public HashSet<Ville> getVilles() 
	{
		return villes;
	}

	@Id
	@GeneratedValue
	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	@ManyToOne
	public Region getRegion() 
	{
		return region;
	}

	public void setRegion(Region region) 
	{
		this.region = region;
	}
}