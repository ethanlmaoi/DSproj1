/*
 * file: BinaryTreeInterface.java
 * author: Ethan Liao
 * class: CS141 - Programming and Problem Solving
 * 
 * assignment: program 1
 * date last modified: 10/17/2017
 * 
 * purpose: This program reads from a standard input a sequence of integer values, with each value separated by a space.
 */

public interface BinaryTreeInterface<T> extends TreeInterface<T>
{
	// this interface is unused
	public void setTree(T rootData);
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
