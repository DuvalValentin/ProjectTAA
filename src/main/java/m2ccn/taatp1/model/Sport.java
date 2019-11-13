package m2ccn.taatp1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Sport implements ModelElement
{
	private long id;
	private String name;
	private List<Ville> villes;
	
	//TODO utiliser tous ces attributs
	private long ventMin;
	private long ventMax;
	
	private boolean exterieur;
	private boolean nautique;
	
	private boolean pluie; //FIXME changer ce nom
	private boolean soleil;
	
	private long houleMin;
	private long houleMax;
	
	
	public Sport()
	{
		villes=new ArrayList<Ville>();
	}
	
	public Sport(String name)
	{
		villes=new ArrayList<Ville>();
		this.name=name;
	}
	
	public Sport(String name,List<Ville> villes)
	{
		this.name=name;
		this.villes=villes;
	}
	
	public Sport(long id,String name,List<Ville> villes)
	{
		this.id=id;
		this.name=name;
		this.villes=villes;
	}
	
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
	
	@ManyToMany()
	@JsonIgnore
	public List<Ville> getVilles() {
		return villes;
	}
	public void setVilles(List<Ville> villes) {
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