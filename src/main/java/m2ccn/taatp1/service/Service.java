package m2ccn.taatp1.service;

//TODO mettre en place les DTO et tenter de réussir un POST

//TODO mettre les services des sauvegarde et suppression de données dans les DAO

import java.util.List;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import m2ccn.taatp1.dao.*;
import m2ccn.taatp1.dto.*;
import m2ccn.taatp1.model.*;

@Path("/service")
public class Service
{
	
	private EntityManager entityManager;
	private RegionDAO regionDAO;
	private DepartementDAO departementDAO;
	private VilleDAO villeDAO;
	private SportDAO sportDAO;
	
	public Service()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		entityManager = factory.createEntityManager();
		regionDAO = new RegionDAO(entityManager);
		departementDAO = new DepartementDAO(entityManager);
		villeDAO = new VilleDAO(entityManager);
		sportDAO=new SportDAO(entityManager);
	}
	public EntityManager getEntityManager()
	{
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	/*public static void main(String[] args)
	{	
		Service service = new Service();
		EntityManager manager = service.getEntityManager();
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
		
		entityTransaction.commit();
		
		service.displayVilles();
		service.displayDepartments();
		
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
	*/
	
	@GET
	@Path("/villes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ville> getVilles()
	{
		return villeDAO.getAll();
	}
	
	@GET
	@Path("/departements")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Departement> getDepartements()
	{
		return departementDAO.getAll(); 
	}
	
	@POST
	@Path("/departements/ajout")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Departement addDepartement(DepartementDTO departementDTO)
	{
		return departementDAO.save(departementDTO);
	}
	
	@GET
	@Path("/regions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Region> getRegions()
	{
		return regionDAO.getAll();
	}
	
	@POST
	@Path("/regions/ajout")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Region addRegion(RegionDTO regionDTO)
	{
		return regionDAO.save(regionDTO);
	}
	
	@GET
	@Path("/sports")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sport> getSports()
	{
		return sportDAO.getAll();
	}
}