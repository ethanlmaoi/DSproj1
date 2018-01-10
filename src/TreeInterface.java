/*
 * file: TreeInterface.java
 * author: Ethan Liao
 * class: CS141 - Programming and Problem Solving
 * 
 * assignment: program 1
 * date last modified: 10/17/2017
 * 
 * purpose: This program reads from a standard input a sequence of integer values, with each value separated by a space.
 */

public interface TreeInterface<T> 
{
	// method: getRootData
	// purpose: retrieves the root data
	public T getRootData();
	
	// method: getHeight
	// purpose: retrieves the height of the tree
	public int getHeight();
	
	// method: getNumberOfNodes
	// purpose: retrieves the number of nodes in the tree
	public int getNumberOfNodes();
	
	// method: isEmpty
	// purpose: checks if the tree is empty
	public boolean isEmpty();
	
	// method: clear
	// purpose: clears the tree
	public void clear();
}
