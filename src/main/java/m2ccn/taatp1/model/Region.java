package m2ccn.taatp1.model;

import java.util.HashSet;

import javax.persistence.*;

@Entity
public class Region 
{
	private long id;
	
	private HashSet<Departement> departements;

	@OneToMany
	public HashSet<Departement> getDepartements() 
	{
		return departements;
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
		departements.add(departement);
	}
	
	public void removeDepartement(Departement departement)
	{
		departements.remove(departement);
	}
}