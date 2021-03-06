package vduval.backend.endpoint;

import java.util.ArrayList;
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

import vduval.backend.dao.SportAO;
import vduval.backend.dto.SportCreationTO;
import vduval.backend.dto.SportTO;
import vduval.backend.mapper.SportM;
import vduval.backend.model.Sport;

@Path("/sport")
public class SportEP extends EndPoint<Sport, SportTO, SportCreationTO>
{
	public SportEP()
	{
		super(new SportAO(), new SportM());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<SportTO> getAll()
	{
		return super.getAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@Override
	public SportTO getById(@PathParam("id")long id) throws NotFoundException
	{
		return super.getById(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("byVilleId/{villeId}")
	public List<SportTO> getByVilleId(@PathParam("villeId") long villeId)
	{
		List<Sport> sports = ((SportAO)dao).getByVilleId(villeId);
		List<SportTO> sportsTO = new ArrayList<SportTO>();
		for(Sport sport : sports)
		{
			SportTO sportTO=(SportTO) mapper.getDTOFromElement(sport);
			sportsTO.add(sportTO);
		}
		return sportsTO;
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public SportTO create(SportCreationTO sportTO)
	{
		return super.create(sportTO);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public SportTO modify(SportTO sportTO)
	{
		return super.modify(sportTO);
	}
	
	@DELETE
	@Path("{id}")
	@Override
	public void delete(@PathParam("id")long id)
	{
		super.delete(id);
	}

}