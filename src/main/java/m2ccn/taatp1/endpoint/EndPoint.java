package m2ccn.taatp1.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import m2ccn.taatp1.dao.IDAO;
import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.model.ModelElement;
import m2ccn.taatp1.transformer.ITransformer;

@SuppressWarnings("unchecked")
public abstract class EndPoint<E extends ModelElement, DTO extends IDTO<E>, CreationDTO extends ICreationDTO>
{
	protected IDAO<E> dao;
	protected ITransformer<E> transformer;

	public EndPoint(IDAO<E> dao, ITransformer<E> transformer)
	{
		this.dao = dao;
		this.transformer = transformer;
	}

	public List<DTO> getAll()
	{
		List<E> elements = dao.getAll();
		List<DTO> elementsTO = new ArrayList<DTO>();
		for (E element : elements)
		{
			DTO elementTO = (DTO) transformer.getDTOFromElement(element);
			elementsTO.add(elementTO);
		}
		return elementsTO;
	}

	public DTO getById(long id) throws NotFoundException
	{
		try
		{
			E element = dao.getById(id);
			DTO elementTO = (DTO) transformer.getDTOFromElement(element);
			return elementTO;
		} catch (Exception e)
		{
			throw new NotFoundException();
		}
		
	}

	// FIXME ne marche pas bien si le tableau de ville en entrée n'est pas vide
	public DTO create(CreationDTO elementTO)
	{
		E element = transformer.getElementFromDTO(elementTO);
		E savedElement = dao.save(element);
		DTO savedElementTo = (DTO) transformer.getDTOFromElement(savedElement);
		return savedElementTo;
	}

	/*
	 * public IDTO<E> modify(IDTO<E> elementTO) { //TODO en cours E element =
	 * transformer.getElementFromDTO(elementTO); return elementTO; }
	 */

	public void delete(long id)
	{
		dao.deleteById(id);
	}
}