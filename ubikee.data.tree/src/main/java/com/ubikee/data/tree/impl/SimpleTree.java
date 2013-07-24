package com.ubikee.data.tree.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.cache.Cache;

import com.ubikee.data.tree.Tree;
import com.ubikee.data.tree.TreeException;
import com.ubikee.data.tree.TreeNodeNotFoundException;

/**
 * A SimpleTree.
 * 
 */
public class SimpleTree extends CacheAware implements Tree<SimpleTreeNode> {

	private SimpleTreeNode root;
	private Cache cache;

	/**
	 * @param root
	 */
	public SimpleTree(SimpleTreeNode root) {
		this.root = root;
	}

	/**
	 * 
	 * @throws CacheException
	 */
	public void save() throws CacheException {
		cache("byID").put(root.identifierToString(), root);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ubikee.data.tree.Tree#addNode(java.lang.Object,
	 * java.lang.Object)
	 */
	public void addNode(SimpleTreeNode parent, SimpleTreeNode child) throws TreeException {
		
		try {

			SimpleTreeNode retrievedParent = nodeByID(parent.identifierToString());
			retrievedParent.insert(child);
			
			cache("byID").put(parent.identifierToString(), parent);
			cache("byID").put(child.identifierToString(), child);

		} catch (CacheException e) {
			throw new TreeException(e);
		}
	}

	public Tree<SimpleTreeNode> branch(SimpleTreeNode node) throws TreeNodeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void prune(SimpleTreeNode node) throws TreeNodeNotFoundException {
		// TODO Auto-generated method stub

	}

	public List<SimpleTreeNode> children(SimpleTreeNode node) throws TreeNodeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ubikee.data.tree.Tree#ancestors(java.lang.Object)
	 */
	public List<String> ancestors(SimpleTreeNode node) throws TreeNodeNotFoundException {
		try {

			SimpleTreeNode retrievedNode = nodeByID(node.identifierToString());
			Validate.notNull(retrievedNode);

			List<String> ancestors = new ArrayList<String>();

			if (!retrievedNode.equals(root)) {

				node = nodeByID(node.getParentID());

				while (!node.equals(root)) {
					ancestors.add(node.identifierToString());
					node = nodeByID(node.getParentID());
				}
			}

			return ancestors;

		} catch (IllegalArgumentException e) {
			throw new TreeNodeNotFoundException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ubikee.data.tree.Tree#nodeByID(java.lang.String)
	 */
	public SimpleTreeNode nodeByID(String id) throws TreeNodeNotFoundException {
		try {
			return (SimpleTreeNode) cache("byID").get(id).get();
		} catch (CacheException e) {
			throw new TreeNodeNotFoundException(e);
		}
	}

	public SimpleTreeNode nodeByPermalink(String permalink) throws TreeNodeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SimpleTreeNode> toList() {
		// TODO Auto-generated method stub
		return null;
	}

}
