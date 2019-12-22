package vduval.backend.mapper;

import vduval.backend.dto.ICreationDTO;
import vduval.backend.dto.IDTO;

public interface IMapper<E>
{
	public E getElementFromDTO(IDTO<E> elementDTO);
	
	public E getElementFromDTO(ICreationDTO elementDTO);
	
	public IDTO<E> getDTOFromElement(E element);
}
