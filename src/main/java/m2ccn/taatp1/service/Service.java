package m2ccn.taatp1.service;

import java.util.List;

import javax.persistence.*;
import m2ccn.taatp1.model.*;
public class Service
{
	private EntityManager entityManager;
	
	public Service(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}
	
	public static void main(String[] args)
	{
		System.err.println("il y a qqn ?");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		System.err.println("Sharron!!!");
		EntityManager manager = factory.createEntityManager();
		
		Service service = new Service(manager);
		
		
		EntityTransaction entityTransaction = manager.getTransaction();
		
		entityTransaction.begin();
		
		try
		{
			List<Region> regions = manager.createQuery("SELECT r FROM Region r",Region.class).getResultList();
			if(regions.size()==0)
			{
				service.createData();
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		System.err.println("passé par ici");
		
		entityTransaction.commit();
		
		service.displayCities();
		
		manager.close();
		System.out.println("Fini");
	}
	
	private void createData()
	{
		Region bretagne = new Region("Bretagne");
		Departement illeEtVilaine = new Departement("Ille et Vilaine",bretagne);
		Departement finistere = new Departement("Finistère",bretagne);
		Departement cotedarmor = new Departement("Côtes d'Armor",bretagne);
		Departement morbihan = new Departement("Morbihan",bretagne);
		Ville rennes = new Ville("Rennes",illeEtVilaine);
		Ville laille = new Ville("Laillé", illeEtVilaine);
		Ville plouzane = new Ville("Plouzané", finistere);
		Ville brest = new Ville("Brest", finistere);
		
		entityManager.persist(bretagne);
		entityManager.persist(illeEtVilaine);
		entityManager.persist(finistere);
		entityManager.persist(cotedarmor);
		entityManager.persist(morbihan);
		entityManager.persist(rennes);
		entityManager.persist(laille);
		entityManager.persist(plouzane);
		entityManager.persist(brest);
	}
	
	private void displayCities()
	{
		List<Ville> registeredVilles = entityManager.createQuery("SELECT v FROM Ville AS v",Ville.class).getResultList();
		System.out.println("Il y a "+registeredVilles.size()+" villes.");
		for(Ville ville : registeredVilles)
		{
			System.out.println(ville.getName());
		}
	}
	
	
}
