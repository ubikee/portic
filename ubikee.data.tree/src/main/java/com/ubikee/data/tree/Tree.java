package com.ubikee.data.tree;

import java.util.List;



/**
 *
 * @param <T>
 */
public interface Tree<T> {

	/**
	 * 
	 * @param parent
	 * @param child
	 * @throws TreeException 
	 * @throws CategoryNotFoundException
	 */
	void addNode(T parent, T child) throws TreeNodeNotFoundException, TreeException;
	
	/**
	 * 
	 * @param content
	 * @return
	 * @throws CategoryNotFoundException
	 */
	Tree<T> branch(T node) throws TreeNodeNotFoundException;

	/**
	 * 
	 * @param content
	 */
	void prune(T node) throws TreeNodeNotFoundException;

	/**
	 * 
	 * @param content
	 * @return
	 * @throws TreeNodeNotFoundException
	 */
	List<T> children(T node) throws TreeNodeNotFoundException;
	
	/**
	 * 
	 * @param content
	 * @return
	 * @throws TreeNodeNotFoundException
	 */
	List<String> ancestors(T node) throws TreeNodeNotFoundException;
	
	/**
	 * @param id
	 * @return
	 * @throws TreeNodeNotFoundException
	 */
	T nodeByID(String id) throws TreeNodeNotFoundException;
	
	/**
	 * @param permalink
	 * @return
	 * @throws TreeNodeNotFoundException
	 */
	T nodeByPermalink(String permalink) throws TreeNodeNotFoundException;
	
	/**
	 * 
	 * @return
	 */
	public List<T> toList();



}
