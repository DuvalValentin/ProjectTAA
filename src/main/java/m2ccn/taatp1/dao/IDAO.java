package m2ccn.taatp1.dao;

import java.util.List;

import m2ccn.taatp1.model.ModelElement;

public interface IDAO<E extends ModelElement>
{
	E getById(long id);
	List<E> getAll();
	E save (E element);
	void deleteById(long id);
	E update(E element);
}