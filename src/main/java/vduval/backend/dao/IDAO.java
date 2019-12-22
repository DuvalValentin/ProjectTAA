package vduval.backend.dao;

import java.util.List;

import vduval.backend.model.ModelElement;

public interface IDAO<E extends ModelElement>
{
	E getById(long id);
	List<E> getAll();
	E save (E element);
	void deleteById(long id);
	E update(E element);
	E transpose(E element);
}