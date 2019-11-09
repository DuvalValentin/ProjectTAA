package m2ccn.taatp1.endpoint;

import java.util.List;

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

import m2ccn.taatp1.dao.RegionAO;
import m2ccn.taatp1.dto.RegionCreationTO;
import m2ccn.taatp1.dto.RegionTO;
import m2ccn.taatp1.mapper.RegionM;
import m2ccn.taatp1.model.Region;

@Path("region")
public class RegionEP extends EndPoint<Region,RegionTO,RegionCreationTO>
{

	public RegionEP()
	{
		super(new RegionAO(), new RegionM());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<RegionTO> getAll()
	{
		return super.getAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@Override
	public RegionTO getById(@PathParam("id")long id) throws NotFoundException
	{
		return super.getById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public RegionTO create(RegionCreationTO regionTO)
	{
		return super.create(regionTO);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public RegionTO modify(RegionTO regionTO)
	{
		return super.modify(regionTO);
	}
	
	@DELETE
	@Path("{id}")
	@Override
	public void delete(@PathParam("id")long id)
	{
		super.delete(id);
	}
	

}
