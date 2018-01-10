/*
 * file: BinarySearchTree.java
 * author: Ethan Liao
 * class: CS141 - Programming and Problem Solving
 * 
 * assignment: program 1
 * date last modified: 10/17/2017
 * 
 * purpose: This program reads from a standard input a sequence of integer values, with each value separated by a space.
 */

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> 
{
	public BinarySearchTree()
	{
		super();
	}
	
	public BinarySearchTree(T rootEntry)
	{
		super();
		setRootNode(new BinaryNode<T>(rootEntry));
	}
	
	// method: setTree
	// purpose: sets a binary tree with root data and left and right trees
	public void setTree(T rootData)
	{
		throw new UnsupportedOperationException();
	}
	
	// method: set tree
	// purpose: sets a binary tree with root data and left and right binary trees
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
	{
		// not needed yet
	}
	
	// method: getEntry
	// purpose: retrieves the entry (or the data portion) of the root node
	public T getEntry(T entry)
	{
		return findEntry(getRootNode(), entry);
	}
	
	// method: addEntry
	// purpose: adds an entry to the root node
	private T addEntry(BinaryNode<T> rootNode, T newEntry)
	{
		assert rootNode != null;
		T result = null;
		int comparison = newEntry.compareTo(rootNode.getData());
		
		if (comparison == 0)
		{
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		else if (comparison < 0)
		{
			if (rootNode.hasLeftChild())
				result = addEntry(rootNode.getLeftChild(), newEntry);
			else
				rootNode.setLeftChild(new BinaryNode<T>(newEntry));
		}
		else
		{
			assert comparison > 0;
			
			if (rootNode.hasRightChild())
				result = addEntry(rootNode.getRightChild(), newEntry);
			else
				rootNode.setRightChild(new BinaryNode<T>(newEntry));
		}
		return result;
	}
	
	// method: add
	// purpose: adds a specified entry to the binary search tree
	public T add(T newEntry)
	{
		T result = null;
		
		if (isEmpty())
		{
			setRootNode(new BinaryNode<T>(newEntry));
		}
		else
		{
			result = addEntry(getRootNode(), newEntry);
		}
		return result;
	}
	
	// method: remove
	// purpose: removes specified entry from the binary search tree
	public T remove(T entry)
	{
		ReturnObject oldEntry = new ReturnObject(null);
		BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
		setRootNode(newRoot);
		
		return (T) oldEntry.get();
	}
	
	// method: removeEntry
	// purpose: this private method removes specified entry from the binary search tree
	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, ReturnObject oldEntry)
	{
		if (rootNode != null)
		{
			T rootData = rootNode.getData();
			int comparison = entry.compareTo(rootData);
			
			if (comparison == 0)
			{
				oldEntry.set(rootData);
				rootNode = removeFromRoot(rootNode);
			}
			else if (comparison < 0)
			{
				BinaryNode<T> leftChild = rootNode.getLeftChild();
				BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
				rootNode.setLeftChild(subtreeRoot);
			}
			else
			{
				BinaryNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
			}
		}
		return rootNode;
	}
	
	// method: removeFromRoot
	// purpose: this method will remove a root from a binary search tree
	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
	{
		if (rootNode.hasLeftChild() && rootNode.hasRightChild())
		{
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
			
			rootNode.setData(largestNode.getData());
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		}
		else if (rootNode.hasRightChild())
		{
			rootNode = rootNode.getRightChild();
		}
		else
		{
			rootNode = rootNode.getLeftChild();
		}
		return rootNode;
	}
	
	// method: findLargest
	// purpose: this method will find the largest of the root node
	private BinaryNode<T> findLargest(BinaryNode<T> rootNode)
	{
		if (rootNode.hasRightChild())
		{
			rootNode = findLargest(rootNode.getRightChild());
		}
		return rootNode;
	}
	
	// method: removeLargest
	// purpose: this method will remove the largest of the rootNode
	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode)
	{
		if (rootNode.hasRightChild())
		{
			BinaryNode<T> rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		}
		else
			rootNode = rootNode.getLeftChild();
		return rootNode;
	}
	
	// method: findEntry
	// purpose: this method will find an entry specified in the parameters
	private T findEntry(BinaryNode<T> rootNode, T entry)
	{
		T result = null;
		
		if (rootNode != null)
		{
			T rootEntry = rootNode.getData();
			
			if (entry.equals(rootEntry))
				result = rootEntry;
			else if (entry.compareTo(rootEntry) < 0)
				result = findEntry(rootNode.getLeftChild(), entry);
			else
				result = findEntry(rootNode.getRightChild(), entry);
		}
		return result;
	}
	
	// method: contains
	// purpose: will check if an entry is contained in the binary search tree
	public boolean contains(T entry)
	{
		return getEntry(entry) != null;
	}
}
