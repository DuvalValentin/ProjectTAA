package m2ccn.taatp1.dao;

import java.util.List;

public interface IDAO<Element>
{
	Element getById(long id);
	List<Element> getAll();
}