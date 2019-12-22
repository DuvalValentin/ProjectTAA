package vduval.backend.dto;

public interface IDTO<Element> extends ICreationDTO
{
	long getId();
	void setId(long id);
}