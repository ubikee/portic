package com.ubikee.data.tree.impl;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.lang.Validate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ubikee.data.tree.TreeNodeException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tree-cache-context.xml")
public class SimpleTreeTest {

	@Autowired
	private SimpleTreeFactory treeFactory;
	
	@Autowired
	private CacheManager cacheManager;
	private Cache cache;
	
	@Before
	public void setup() {
		Validate.notNull(treeFactory);
		Validate.notNull(cacheManager);
		this.cache = cacheManager.getCache("byID");
		Validate.notNull(cache);
	}
	
	@Test
	public void shouldCreate() throws Exception {	
		
		Assert.assertNotNull(treeFactory);
		
		SimpleTreeNode root = new SimpleTreeNode("ROOT");
		treeFactory.create(root).save();
		
		SimpleTreeNode retrieved = (SimpleTreeNode) cache.get("ROOT").get();
		Assert.assertEquals(root, retrieved);
	}
	
	@Test
	public void shouldAddChild() throws Exception {
		
		SimpleTreeNode root = new SimpleTreeNode("ROOT");
		SimpleTreeNode child = new SimpleTreeNode("CHILD1");
		
		SimpleTree tree = createTree(root);
		tree.addNode(root, child);
		
		SimpleTreeNode retrieved = (SimpleTreeNode) cache.get("CHILD1").get();
		Assert.assertEquals(child, retrieved);
	}
	
	@Test(expected=TreeNodeException.class)
	public void shouldNotAddRepeatedChild() throws Exception {
		
		SimpleTreeNode root = new SimpleTreeNode("ROOT");
		SimpleTreeNode child = new SimpleTreeNode("CHILD1");
		
		SimpleTree tree = createTree(root);
		tree.addNode(root, child);
		tree.addNode(root, child);
		
	}
	
	@Test
	public void shouldFindByID() throws Exception {

		SimpleTreeNode root = new SimpleTreeNode("ROOT");
		SimpleTreeNode child1 = new SimpleTreeNode("CHILD1");
		SimpleTreeNode child11 = new SimpleTreeNode("CHILD11");
		
		SimpleTree tree = createTree(root);
		tree.addNode(root, child1);
		tree.addNode(child1, child11);
		
		SimpleTreeNode retrieved = tree.nodeByID("CHILD11");
		Assert.assertEquals(child11, retrieved);
		
	}
	
	@Test
	public void shouldGetAncestors() throws Exception {
		
		SimpleTreeNode root = new SimpleTreeNode("ROOT");
		SimpleTreeNode child1 = new SimpleTreeNode("CHILD1");
		SimpleTreeNode child11 = new SimpleTreeNode("CHILD11");
		
		SimpleTree tree = createTree(root);
		tree.addNode(root, child1);
		tree.addNode(child1, child11);
		
		List<String> ancestors = tree.ancestors(child11);
		Assert.assertEquals(1, ancestors.size());
		
	}
	
	/**
	 * @return
	 * @throws CacheException
	 */
	private SimpleTree createTree(SimpleTreeNode root) throws CacheException {
		SimpleTree tree = treeFactory.create(root); 
		tree.save();
		return tree;
	}
}
