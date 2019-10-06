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

import m2ccn.taatp1.dao.VilleDAO;
import m2ccn.taatp1.dto.VilleCreationTO;
import m2ccn.taatp1.dto.VilleDTO;
import m2ccn.taatp1.model.Ville;
import m2ccn.taatp1.transformer.VilleT;

@Path("/ville")
public class VilleEP extends EndPoint<Ville,VilleDTO,VilleCreationTO>
{
	public VilleEP()
	{
		super(new VilleDAO(), new VilleT());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<VilleDTO> getAll()
	{
		return super.getAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@Override
	public VilleDTO getById(@PathParam("id")long id)
	{
		return super.getById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public VilleDTO create(VilleCreationTO villeTo)
	{
		return super.create(villeTo);
	}
	
	@DELETE
	@Path("{id}")
	@Override
	public void delete(@PathParam("id")long id)
	{
		super.delete(id);
	}
}