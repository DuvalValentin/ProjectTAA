package m2ccn.taatp1.model;

import java.util.HashSet;

import javax.persistence.*;

@Entity
public class Sport 
{
	private long id;
	private String name;
	private HashSet<Ville> villes;
	private long ventMin;
	private long ventMax;
	
	private boolean exterieur;
	private boolean nautique;
	
	private boolean pluie; //FIXME changer ce nom
	private boolean soleil;
	
	private long houleMin;
	private long houleMax;
	
	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany
	public HashSet<Ville> getVilles() {
		return villes;
	}
	public void setVilles(HashSet<Ville> villes) {
		this.villes = villes;
	}
	
	public long getVentMin()
	{
		return ventMin;
	}
	public void setVentMin(long ventMin)
	{
		this.ventMin = ventMin;
	}
	public long getVentMax()
	{
		return ventMax;
	}
	public void setVentMax(long ventMax)
	{
		this.ventMax = ventMax;
	}
	public boolean isPluie()
	{
		return pluie;
	}
	public void setPluie(boolean pluie)
	{
		this.pluie = pluie;
	}
	public boolean isSoleil()
	{
		return soleil;
	}
	public void setSoleil(boolean soleil)
	{
		this.soleil = soleil;
	}
	public boolean isExterieur()
	{
		return exterieur;
	}
	public void setExterieur(boolean exterieur)
	{
		this.exterieur = exterieur;
	}
	public boolean isNautique()
	{
		return nautique;
	}
	public void setNautique(boolean nautique)
	{
		this.nautique = nautique;
	}
	public long getHouleMin()
	{
		return houleMin;
	}
	public void setHouleMin(long houleMin)
	{
		this.houleMin = houleMin;
	}
	public long getHouleMax()
	{
		return houleMax;
	}
	public void setHouleMax(long houleMax)
	{
		this.houleMax = houleMax;
	}

}