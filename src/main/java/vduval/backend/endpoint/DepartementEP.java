package vduval.backend.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import vduval.backend.dao.DepartementAO;
import vduval.backend.dao.RegionAO;
import vduval.backend.dto.DepartementCreationTO;
import vduval.backend.dto.DepartementTO;
import vduval.backend.mapper.DepartementM;
import vduval.backend.model.Departement;
import vduval.backend.model.Region;

@Path("departement/")
public class DepartementEP extends EndPoint<Departement,DepartementTO,DepartementCreationTO>
{
	public DepartementEP()
	{
		super(new DepartementAO(), new DepartementM());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<DepartementTO> getAll()
	{
		return super.getAll();
	}
	
	@GET
	@Override
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DepartementTO getById(@PathParam("id")long id) throws NotFoundException
	{
		try
		{
			return super.getById(id);
		} catch (NoResultException e)
		{
			throw new NotFoundException();
		}
	}
	
	@GET
	@Path("byRegionId/{regionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DepartementTO> getByRegionId(@PathParam("regionId")long regionId)
	{
		RegionAO regionDAO=new RegionAO();
		Region region = regionDAO.getById(regionId);
		List<Departement> departements = ((DepartementAO)dao).getByRegion(region);
		List<DepartementTO> departementsTO = new ArrayList<DepartementTO>();
		for(Departement departement : departements)
		{
			DepartementTO departementTO = (DepartementTO) mapper.getDTOFromElement(departement);
			departementsTO.add(departementTO);
		}
		return departementsTO;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public DepartementTO create(DepartementCreationTO departementTO)
	{
		return super.create(departementTO);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public DepartementTO modify(DepartementTO departementTO)
	{
		return super.modify(departementTO);
	}
	
	
	
	@DELETE
	@Path("{id}")
	@Override
	public void delete(@PathParam("id")long id)
	{
		super.delete(id);
	}

}
