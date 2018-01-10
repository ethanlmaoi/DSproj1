/*
 * file: BinaryTree.java
 * author: Ethan Liao
 * class: CS141 - Programming and Problem Solving
 * 
 * assignment: program 1
 * date last modified: 10/17/2017
 * 
 * purpose: This program reads from a standard input a sequence of integer values, with each value separated by a space.
 */

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T>
{
	private BinaryNode<T> root;
	private ArrayList<T> list;
	
	public BinaryTree()
	{
		root = null;
		list = new ArrayList<T>();
	}
	
	public BinaryTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
		list = new ArrayList<T>();
	}
	
	// method: getRootData
	// purpose: retrieves the root data of the binary tree
	public T getRootData()
	{
		if (isEmpty())
			throw new EmptyStackException();
		else
			return root.getData();
	}
	
	// method: isEmpty
	// purpose: checks if the binary tree is empty
	public boolean isEmpty()
	{
		return root == null;
	}
	
	// method: clear
	// purpose: clears the binary tree
	public void clear()
	{
		root = null;
	}
	
	// method: setRootData
	// purpose: sets the root data of the binary tree using your specified parameter
	protected void setRootData(T rootData)
	{
		root.setData(rootData);
	}
	
	// method: setRootNode
	// purpose: sets the root node of the bianry tree using your specified parameter
	protected void setRootNode(BinaryNode<T> rootNode)
	{
		root = rootNode;
	}
	
	// method: getRootNode
	// purpose: retrieves the root node of the binary tree
	protected BinaryNode<T> getRootNode()
	{
		return root;
	}
	
	// method: setTree
	// purpose: sets a binary tree with right and left tree
	public void setTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	// method: privateSetTree
	// purpose: a private method to help setTree
	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		root = new BinaryNode<T>(rootData);
		
		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);
		
		if ((rightTree != null) && !rightTree.isEmpty())
		{
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		}
		
		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();
		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	}
	
	// method: inorderTraverse
	// purpose: helps find the predecessor and successor
	public void inorderTraverse()
	{
		list = new ArrayList<T>();
		inorderTraverse(root);
	}
	
	// method: obtainPredecessor
	// purpose: gets the predecessor of a specified target
	public T obtainPredecessor(T target)
	{
		list.clear();
		inorderTraversePS(root);
		for (int i = 0; i < list.size(); i++)
		{
			try
			{
				if (list.get(i).equals(target))
					return list.get(i-1);
			}
			catch (Exception ex)
			{
				System.out.println("There is no predecessor!");
			}
		}
		return null;
	}
	
	// method: obtainSuccessor
	// purpose: gets the successor of a specified target
	public T obtainSuccessor(T target)
	{
		list.clear();
		inorderTraversePS(root);
		for (int i = 0; i < list.size(); i++)
		{
			try
			{
				if (list.get(i).equals(target))
					return list.get(i+1);
			}
			catch (Exception ex)
			{
				System.out.println("There is no successor!");
			}
		}
		return null;
	}
	
	// method: inorderTraversePS
	// purpose: helps get the predecessor and successor of a specified target
	private void inorderTraversePS(BinaryNode<T> node)
	{
		if (node != null)
		{
			inorderTraversePS(node.getLeftChild());
			list.add(node.getData());
			inorderTraversePS(node.getRightChild());
		}
	}
	
	// method: inorderTraverse
	// purpose: prints out the inorder of the binary tree
	public void inorderTraverse(BinaryNode<T> node)
	{
		if (node != null)
		{
			inorderTraverse(node.getLeftChild());
			System.out.print(node.getData() + " ");
			inorderTraverse(node.getRightChild());
		}
	}
	
	// method: preorderTraverse
	// purpose: prints out the preorder of the binary tree
	public void preorderTraverse()
	{
		preorderTraverse(root);
	}
	
	// method: preorderTraverse
	// purpose: prints out the preorder of the binary tree
	public void preorderTraverse(BinaryNode<T> node)
	{
		if (node != null)
		{
			System.out.print(node.getData() + " ");
			preorderTraverse(node.getLeftChild());
			preorderTraverse(node.getRightChild());
		}
	}
	
	// method: postorderTraverse
	// purpose: prints out the postorder of the binary tree
	public void postorderTraverse()
	{
		postorderTraverse(root);
	}
	
	// method: postorderTraverse
	// purpose: prints out the postorder of the binary tree
	public void postorderTraverse(BinaryNode<T> node)
	{
		if (node != null)
		{
			postorderTraverse(node.getLeftChild());
			postorderTraverse(node.getRightChild());
			System.out.print(node.getData() + " ");
		}
	}
	
	// method: getHeight
	// purpose: retrieves the height of the binary tree
	public int getHeight()
	{
		return root.getHeight();
	}
	
	// method: getNumberOfNodes
	// purpose: retrieves of the number of nodes startinf rom the root of the binary tree
	public int getNumberOfNodes()
	{
		return root.getNumberOfNodes();
	}

	@Override
	public void setTree(T rootData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		// TODO Auto-generated method stub
		
	}
}
