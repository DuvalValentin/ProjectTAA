package m2ccn.taatp1.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import m2ccn.taatp1.dao.VilleAO;
import m2ccn.taatp1.dto.VilleCreationTO;
import m2ccn.taatp1.dto.VilleTO;
import m2ccn.taatp1.mapper.VilleM;
import m2ccn.taatp1.model.Ville;

@Path("/ville")
public class VilleEP extends EndPoint<Ville,VilleTO,VilleCreationTO>
{
	public VilleEP()
	{
		super(new VilleAO(), new VilleM());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<VilleTO> getAll()
	{
		return super.getAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@Override
	public VilleTO getById(@PathParam("id")long id)
	{
		return super.getById(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("byDepartmentId/{departementId}")
	public List<VilleTO> getByDepartmentId(@PathParam("departementId") long departementId)
	{
		List<Ville> villes = ((VilleAO)dao).getByDepartementId(departementId);
		List<VilleTO> villesTO = new ArrayList<VilleTO>();
		for(Ville ville : villes)
		{
			VilleTO villeTO = (VilleTO) mapper.getDTOFromElement(ville);
			villesTO.add(villeTO);
		}
		return villesTO;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("bySportId/{sportId}")
	public List<VilleTO> getBySportId(@PathParam("sportId") long sportId)
	{
		//FIXME le passage liste TO à liste model devrait être fait dans les mappers
		List<Ville>villes=((VilleAO)dao).getBySportId(sportId);
		List<VilleTO> villesTO = new ArrayList<VilleTO>();
		for(Ville ville : villes)
		{
			VilleTO villeTO=(VilleTO) mapper.getDTOFromElement(ville);
			villesTO.add(villeTO);
		}
		return villesTO;
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public VilleTO create(VilleCreationTO villeTo)
	{
		return super.create(villeTo);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public VilleTO modify(VilleTO villeTo)
	{
		return super.modify(villeTo);
	}
	
	@DELETE
	@Path("{id}")
	@Override
	public void delete(@PathParam("id")long id)
	{
		super.delete(id);
	}
}