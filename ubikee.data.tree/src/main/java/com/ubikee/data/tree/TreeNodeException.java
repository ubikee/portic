package com.ubikee.data.tree;

public class TreeNodeException extends TreeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2109999430863936018L;

	public TreeNodeException(IllegalArgumentException e) {
		super(e);
	}

	public TreeNodeException(Throwable e) {
		super(e);
	}
}
