package m2ccn.taatp1.model;

import java.util.HashSet;

import javax.persistence.*;

@Entity
public class Ville 
{
	
	private long id;
	private Departement departement;
	private HashSet<Sport> sports;

	@OneToMany
	public HashSet<Sport> getSports()
	{
		return sports;
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
		this.departement = departement;
	}
}