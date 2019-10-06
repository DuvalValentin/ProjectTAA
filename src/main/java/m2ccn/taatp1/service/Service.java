package m2ccn.taatp1.service;

public class Service
{
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
}