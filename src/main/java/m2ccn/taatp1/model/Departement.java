package m2ccn.taatp1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Departement implements ModelElement
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
	
	public Departement(Long id,String name,Region region, List<Ville>villes)
	{
		this.id=id;
		this.name=name;
		this.region=region;
		this.villes=villes;
	}

	@OneToMany(mappedBy = "departement")
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
	@JsonIgnore
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
		if(!villes.contains(ville))
		{
			villes.add(ville);
		}
	}
	
	public void removeVille(Ville ville)
	{
		this.villes.remove(ville);
	}
	
	@Override
	public String toString()
	{
		return("Name : "+name+" Villes : "+villes);
	}
}