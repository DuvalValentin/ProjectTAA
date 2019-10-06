package m2ccn.taatp1.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import m2ccn.taatp1.dao.RegionDAO;
import m2ccn.taatp1.dto.RegionCreationTO;
import m2ccn.taatp1.dto.RegionDTO;
import m2ccn.taatp1.model.Region;
import m2ccn.taatp1.transformer.RegionT;

@Path("region")
public class RegionEP extends EndPoint<Region,RegionDTO,RegionCreationTO>
{

	public RegionEP()
	{
		super(new RegionDAO(), new RegionT());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<RegionDTO> getAll()
	{
		return super.getAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@Override
	public RegionDTO getById(@PathParam("id")long id)
	{
		return super.getById(id);
	}
	
	//FIXME pas bon ici
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public RegionDTO create(RegionCreationTO regionTO)
	{
		return super.create(regionTO);
	}
	
	@DELETE
	@Path("{id}")
	@Override
	public void delete(@PathParam("id")long id)
	{
		super.delete(id);
	}
	

}
