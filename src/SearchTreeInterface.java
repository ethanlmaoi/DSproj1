/*
 * file: SearchTreeInterface.java
 * author: Ethan Liao
 * class: CS141 - Programming and Problem Solving
 * 
 * assignment: program 1
 * date last modified: 10/17/2017
 * 
 * purpose: This program reads from a standard input a sequence of integer values, with each value separated by a space.
 */

import java.util.Iterator;

public interface SearchTreeInterface <T extends Comparable <? super T>> extends TreeInterface<T>
{	
	// method: contains
	// purpose: searches for a specific entry in the tree
	public boolean contains(T entry);
	
	// method: getEntry
	// purpose: retrieves a specific entry in this tree
	public T getEntry(T entry);
	
	// method: add
	// purpose: adds a new entry to the tree, if it is not the same as a current object in the tree
	public T add(T newEntry);
	
	// method: remove
	// purpose: removes a specified entry from the tree
	public T remove(T entry);
}
