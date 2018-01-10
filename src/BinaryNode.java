/*
 * file: BinaryNode.java
 * author: Ethan Liao
 * class: CS141 - Programming and Problem Solving
 * 
 * assignment: program 1
 * date last modified: 10/17/2017
 * 
 * purpose: This program reads from a standard input a sequence of integer values, with each value separated by a space.
 */

class BinaryNode<T> 
{
	private T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	
	public BinaryNode()
	{
		this(null);
	}
	
	public BinaryNode(T dataPortion)
	{
		this(dataPortion, null, null);
	}
	
	public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild)
	{
		data = dataPortion;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}
	
	// method: getData
	// purpose: retrieves the data portion of this binary node
	public T getData()
	{
		return data;
	}
	
	// method: setData
	// purpose: sets the data portion of this binary node
	public void setData(T newData)
	{
		data = newData;
	}
	
	// method: getLeftChild
	// purpose: retrieves the left child of this binary node
	public BinaryNode<T> getLeftChild()
	{
		return leftChild;
	}
	
	// method: getRightChild
	// purpose: retrives the right child of this binary node
	public BinaryNode<T> getRightChild()
	{
		return rightChild;
	}
	
	// method: setLeftChild
	// purpose: sets the left child of this binary node
	public void setLeftChild(BinaryNode<T> newLeftChild)
	{
		leftChild = newLeftChild;
	}
	
	// method: setRightChild
	// purpose: sets the right child of this binary node
	public void setRightChild(BinaryNode<T> newRightChild)
	{
		rightChild = newRightChild;
	}

	// method: hasLeftChild
	// purpose: checks whether or not this binary node has a left child
	public boolean hasLeftChild()
	{
		return leftChild != null;
	}
	
	// method: hasRightChild
	// purpose: checks whether or not this binary node has a right child
	public boolean hasRightChild()
	{
		return rightChild != null;
	}
	
	// method: isLeaf
	// purpose: checks whether or not this binary node is a leaf (non-parent)
	public boolean isLeaf()
	{
		return (leftChild == null) && (rightChild == null);
	}
	
	// method: getHeight
	// purpose: retrieves the height of the subtree at this binary node
	public int getHeight()
	{
		return getHeight(this);
	}
	
	// method: getHeight
	// purpose: retrieves the height of the subtree at this binary node with a node as a parameter
	public int getHeight(BinaryNode<T> node)
	{
		int height = 0;
		
		if (node != null)
			height = 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
		
		return height;
	}
	
	// method: getNumberOfNodes
	// purpose: counts the number of nodes in the subtree rooted at this node
	public int getNumberOfNodes()
	{
		int leftNumber = 0;
		int rightNumber = 0;
		
		if (leftChild != null)
			leftNumber = leftChild.getNumberOfNodes();
		
		if (rightChild != null)
			rightNumber = rightChild.getNumberOfNodes();
		
		return 1 + leftNumber + rightNumber;
	}
	
	// method: copy	
	// purpose: copies the subtree rooted at this node
	public BinaryNode<T> copy()
	{
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		
		if (leftChild != null)
			newRoot.setLeftChild(leftChild.copy());
		
		if (rightChild != null)
			newRoot.setRightChild(rightChild.copy());
		
		return newRoot;
	}
}
