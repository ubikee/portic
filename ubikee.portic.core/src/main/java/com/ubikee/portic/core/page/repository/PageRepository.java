package com.ubikee.portic.core.page.repository;

import java.util.List;

import com.ubikee.portic.core.page.Page;
import com.ubikee.portic.core.page.PageDescriptor;

/**
 * 
 * @author ernesto
 *
 */
@SuppressWarnings("rawtypes")
public interface PageRepository {

	/**
	 * @param id
	 * @return
	 */
	Page get(String id) throws PageRepositoryException;
	
	/**
	 * @return
	 */
	List<Page> getAll() throws PageRepositoryException;
	
	/**
	 * @param page
	 */
	void saveOrUpdate(PageDescriptor page) throws PageRepositoryException;
	
}
