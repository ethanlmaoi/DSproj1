/*
 * file: ReturnObject.java
 * author: Ethan Liao
 * class: CS141 - Programming and Problem Solving
 * 
 * assignment: program 1
 * date last modified: 10/17/2017
 * 
 * purpose: This program reads from a standard input a sequence of integer values, with each value separated by a space.
 */

public class ReturnObject<T> 
{
	private T object;
	
	public ReturnObject()
	{
		object = null;
	}
	
	public ReturnObject(T object)
	{
		this.object = object;
	}
	
	// method: get
	// purpose: returns the object
	public T get()
	{
		return object;
	}
	
	// method: set
	// purpose: sets the object
	public void set(T obj)
	{
		object = obj;
	}
}
