package m2ccn.taatp1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Departement 
{
	private long id;
	private String name;
	private Region region;
	private List<Ville> villes;
	
	public Departement()
	{
		villes=new ArrayList<Ville>();
	}
	
	public Departement(String name,Region region)
	{
		this.name=name;
		this.region=region;
		villes=new ArrayList<Ville>();
		region.addDepartement(this);
	}

	@OneToMany
	public List<Ville> getVilles() 
	{
		return villes;
	}
	
	public void setVilles(List<Ville> villes)
	{
		this.villes = villes;
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
		if(this.region!=null)
		{
			this.region.removeDepartement(this);
		}
		this.region=region;
		this.region.addDepartement(this);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addVille(Ville ville)
	{
		villes.add(ville);
	}
	
	public void removeVille(Ville ville)
	{
		this.villes.remove(ville);
	}
}