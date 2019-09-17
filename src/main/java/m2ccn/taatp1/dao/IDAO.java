package m2ccn.taatp1.dao;

import java.util.List;

import m2ccn.taatp1.dto.IDTO;

public interface IDAO<E>
{
	E getById(long id);
	List<E> getAll();
	E save (IDTO<E> elementDTO);
}