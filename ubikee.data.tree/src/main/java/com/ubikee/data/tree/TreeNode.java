package com.ubikee.data.tree;

import java.util.List;


/**
 * TreeNode interface. [from javax.swing MutableTreeNode]
 * 
 *
 */
public interface TreeNode<T> extends Identificable {

	/**
	 * Returns the number of children <code>TreeNode</code>s the receiver
	 * contains.
	 */
	int getChildCount();

	/**
	 * Returns the parentID <code>TreeNode</code> of the receiver.
	 */
	String getParentID();

	/**
	 * Returns true if the receiver allows children.
	 */
	boolean getAllowsChildren();

	/**
	 * Returns true if the receiver is a leaf.
	 */
	boolean isLeaf();

	/**
	 * Returns the children of the receiver as an <code>Enumeration</code>.
	 */
	List<String> children();
	
    /**
     * Adds <code>child</code> to the receiver.
     * <code>child</code> will be messaged with <code>setParent</code>.
     * @throws TreeNodeException 
     */
    void insert(TreeNode child) throws TreeNodeException;

    /**
     * Removes <code>node</code> from the receiver. <code>setParent</code>
     * will be messaged on <code>node</code>.
     */
    void remove(TreeNode node);

    /**
     * Removes the receiver from its parent.
     */
    void removeFromParent();

    /**
     * Sets the parentID of the receiver to <code>newParent</code>.
     */
    void setParentID(String newParent);
	
}
