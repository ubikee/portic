package com.ubikee.data.tree;

public class TreeNodeNotFoundException extends TreeNodeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3807250029488965563L;

	public TreeNodeNotFoundException(Throwable e) {
		super(e);
	}

	public TreeNodeNotFoundException(IllegalArgumentException e) {
		super(e);
	}

}
