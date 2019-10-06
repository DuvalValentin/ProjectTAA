package m2ccn.taatp1.transformer;

import m2ccn.taatp1.dto.ICreationDTO;
import m2ccn.taatp1.dto.IDTO;

public interface ITransformer<E>
{
	public E getElementFromDTO(IDTO<E> elementDTO);
	
	public E getElementFromDTO(ICreationDTO elementDTO);
	
	public IDTO<E> getDTOFromElement(E element);
}
