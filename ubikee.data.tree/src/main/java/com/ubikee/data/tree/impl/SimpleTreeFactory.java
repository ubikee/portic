package com.ubikee.data.tree.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

/**
 * @author ernesto
 *
 */
public class SimpleTreeFactory {

	CacheManager cacheManager;
	
	/**
	 * @constructor
	 */
	public SimpleTreeFactory() {}
	
	/**
	 * @constructor
	 * @param cacheManager
	 */
	@Autowired
	public SimpleTreeFactory(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	/**
	 * @param root
	 * @return
	 */
	public SimpleTree create(SimpleTreeNode root) {
		SimpleTree tree = new SimpleTree(root);
		tree.setCacheManager(cacheManager);
		return tree;
	}
	
}
