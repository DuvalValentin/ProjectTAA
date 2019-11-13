package m2ccn.taatp1.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import m2ccn.taatp1.dao.IDAO;
import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;
import m2ccn.taatp1.mapper.IMapper;
import m2ccn.taatp1.model.ModelElement;

@SuppressWarnings("unchecked")
public abstract class EndPoint<E extends ModelElement, DTO extends IDTO<E>, CreationDTO extends ICreationDTO>
{
	protected IDAO<E> dao;
	protected IMapper<E> mapper;

	public EndPoint(IDAO<E> dao, IMapper<E> transformer)
	{
		this.dao = dao;
		this.mapper = transformer;
	}
	
	public List<DTO> getAll()
	{
		List<E> elements = dao.getAll();
		List<DTO> elementsTO = new ArrayList<DTO>();
		for (E element : elements)
		{
			DTO elementTO = (DTO) mapper.getDTOFromElement(element);
			elementsTO.add(elementTO);
		}
		return elementsTO;
	}

	public DTO getById(long id) throws NotFoundException
	{
		try
		{
			E element = dao.getById(id);
			DTO elementTO = (DTO) mapper.getDTOFromElement(element);
			return elementTO;
		} catch (Exception e)
		{
			throw new NotFoundException();
		}
		
	}

	public DTO create(CreationDTO elementTO)
	{
		E element = mapper.getElementFromDTO(elementTO);
		E savedElement = dao.save(element);
		DTO savedElementTo = (DTO) mapper.getDTOFromElement(savedElement);
		return savedElementTo;
	}

	
	 public DTO modify(DTO elementTO) 
	 {
		 E element = mapper.getElementFromDTO(elementTO);
		 E modifiedElement = dao.update(element);
		 DTO modifiedElementTO = (DTO) mapper.getDTOFromElement(modifiedElement);
		 return modifiedElementTO; 
	 }
	 

	public void delete(long id)
	{
		dao.deleteById(id);
	}
}