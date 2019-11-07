package m2ccn.taatp1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Region implements ModelElement
{
	private long id;
	private String name;
	private List<Departement> departements;
	
	public Region()
	{
		departements=new ArrayList<Departement>();
	}
	
	public Region(String name)
	{
		departements=new ArrayList<Departement>();
		this.name=name;
	}

	@OneToMany(mappedBy = "region",cascade = CascadeType.REMOVE)
	public List<Departement> getDepartements() 
	{
		return departements;
	}
	
	public void setDepartements(List<Departement> departements)
	{
		this.departements = departements;
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

	public void addDepartement(Departement departement)
	{
		if(!departements.contains(departement))
		{
			departements.add(departement);
		}
	}
	
	public void removeDepartement(Departement departement)
	{
		departements.remove(departement);
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