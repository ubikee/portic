package com.ubikee.data.tree.impl;

import org.apache.commons.lang.Validate;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * 
 *
 */
public abstract class CacheAware {

	private CacheManager cacheManager;

	/**
	 * 
	 * @param cacheManager
	 */
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws CacheException
	 */
	public Cache cache(String name) throws CacheException {
		try {
			Validate.notNull(cacheManager, "cacheManager error");
			Cache cache = cacheManager.getCache(name);
			Validate.notNull(cache, "invalid cache name");
			return cache;
		} catch (IllegalArgumentException e) {
			throw new CacheException(e);
		}
	}

}
