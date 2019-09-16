package m2ccn.taatp1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Ville 
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

	@ManyToMany(mappedBy = "villes")
	public List<Sport> getSports()
	{
		return sports;
	}
	
	public void setSports(List<Sport> sports)
	{
		this.sports = sports;
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