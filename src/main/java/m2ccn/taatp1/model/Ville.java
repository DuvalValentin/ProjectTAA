package m2ccn.taatp1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Ville implements ModelElement
{
	
	private long id;
	private String name;
	private Departement departement;
	private List<Sport> sports;
	
	public Ville()
	{
		sports=new ArrayList<Sport>();
	}
	
	public Ville(String name,Departement departement)
	{
		this.departement = departement;
		this.name=name;
		sports=new ArrayList<Sport>();
	}
	
	public Ville(long id,String name,Departement departement,List<Sport> sports)
	{
		this.id=id;
		this.name=name;
		this.departement=departement;
		this.sports=sports;
	}

	@ManyToMany(mappedBy = "villes")
	public List<Sport> getSports()
	{
		return sports;
	}
	
	public void setSports(List<Sport> sports)
	{
		this.sports = sports;
	}
	
	public void addSport(Sport sport)
	{
		if(!sports.contains(sport))
		{
			sports.add(sport);
		}
	}
	
	public void removeSport(Sport sport)
	{
		sports.remove(sport);
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
	public Departement getDepartement() 
	{
		return departement;
	}

	public void setDepartement(Departement departement) 
	{
		if(this.departement!=null)
		{
			this.departement.removeVille(this);
		}
		this.departement = departement;
		this.departement.addVille(this);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}