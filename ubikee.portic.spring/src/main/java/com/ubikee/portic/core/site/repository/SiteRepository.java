package com.ubikee.portic.core.site.repository;

import java.util.List;
import java.util.UUID;

import com.ubikee.portic.core.site.Site;

/**
 * 
 * @author ernesto
 *
 */
public interface SiteRepository {

	/**
	 * @return
	 */
	Long count();
	
	/**
	 * @param site
	 */
	void delete(Site site);
	
	/**
	 * @param id
	 * @return
	 */
	boolean exists(UUID id);
	
	/**
	 * @return
	 */
	List<Site> findAll();
	
	/**
	 * @param id
	 * @return
	 */
	Site findById(UUID id);
	
	/**
	 * @param site
	 */
	void save(Site site);
	
}
