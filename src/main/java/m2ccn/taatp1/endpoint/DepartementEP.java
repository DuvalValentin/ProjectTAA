package m2ccn.taatp1.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import m2ccn.taatp1.dao.DepartementDAO;
import m2ccn.taatp1.dao.RegionDAO;
import m2ccn.taatp1.dto.DepartementCreationTO;
import m2ccn.taatp1.dto.DepartementDTO;
import m2ccn.taatp1.model.Departement;
import m2ccn.taatp1.model.Region;
import m2ccn.taatp1.transformer.DepartementT;

@Path("departement/")
public class DepartementEP extends EndPoint<Departement,DepartementDTO,DepartementCreationTO>
{
	public DepartementEP()
	{
		super(new DepartementDAO(), new DepartementT());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<DepartementDTO> getAll()
	{
		return super.getAll();
	}
	
	@GET
	@Override
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DepartementDTO getById(@PathParam("id")long id)
	{
		return  (DepartementDTO) super.getById(id);
	}
	
	@GET
	@Path("byRegionId/{regionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DepartementDTO> getByRegionId(@PathParam("regionId")long regionId)
	{
		RegionDAO regionDAO=new RegionDAO();
		Region region = regionDAO.getById(regionId);
		List<Departement> departements = ((DepartementDAO)dao).getByRegion(region);
		List<DepartementDTO> departementsTO = new ArrayList<DepartementDTO>();
		for(Departement departement : departements)
		{
			DepartementDTO departementTO = (DepartementDTO) transformer.getDTOFromElement(departement);
			departementsTO.add(departementTO);
		}
		return departementsTO;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public DepartementDTO create(DepartementCreationTO departementTO)
	{
		return super.create(departementTO);
	}
	
	
	
	@DELETE
	@Path("{id}")
	@Override
	public void delete(@PathParam("id")long id)
	{
		super.delete(id);
	}

}
