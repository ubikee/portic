package com.ubikee.data.tree.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;

import com.ubikee.data.tree.TreeNode;
import com.ubikee.data.tree.TreeNodeException;

public class SimpleTreeNode implements TreeNode<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3695085312603874785L;

	private String content;
	private List<String> children = new ArrayList<String>();
	private String parentID;

	/**
	 * 
	 */
	public SimpleTreeNode(String content) {
		this.content = content;
	}

	public int getChildCount() {
		return children.size();
	}

	public String getParentID() {
		return parentID;
	}

	public boolean getAllowsChildren() {
		return true;
	}

	public boolean isLeaf() {
		return children.size() == 0;
	}

	public List<String> children() {
		return children;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ubikee.data.tree.TreeNode#insert(com.ubikee.data.tree.TreeNode,
	 * int)
	 */
	public void insert(TreeNode child) throws TreeNodeException {
		try {

			Validate.isTrue(!children.contains(child.identifierToString()));
			
			child.setParentID(this.identifierToString());
			this.children.add(child.identifierToString());

		} catch (IllegalArgumentException e) {
			throw new TreeNodeException(e);
		}
	}

	public void remove(TreeNode node) {
		// TODO Auto-generated method stub

	}

	public void removeFromParent() {
		// TODO Auto-generated method stub

	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String identifierToString() {
		return content.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		SimpleTreeNode other = (SimpleTreeNode) obj;
		return identifierToString().equals(other.identifierToString());
	}

}
