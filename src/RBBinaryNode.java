
public class RBBinaryNode<T> extends BinaryNode
{
	private String color;
	private RBBinaryNode<T> parent;
	
	public RBBinaryNode()
	{
		super();
		color = "RED";
	}
	
	public RBBinaryNode(T dataPortion)
	{
		super(dataPortion, null, null);
		color = "RED";
	}
	
	public RBBinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild)
	{
		super(dataPortion, newLeftChild, newRightChild);
		color = "RED";
	}
	
	public void changeToBlack()
	{
		if (checkValidColor())
		{
			color = "BLACK";
		}
	}
	
	public void changeToRed()
	{
		if (checkValidColor())
		{
			color = "RED";
		}
	}
	
	public void switchColors()
	{
		if (checkValidColor())
		{
			if (color.equals("BLACK"))
				color = "RED";
			else if (color.equals("RED"))
				color = "BLACK";
		}
	}
	
	public boolean checkValidColor()
	{
		if (!color.equals("RED") || !color.equals("BLACK"))
		{
			System.out.println("ERROR: INVALID COLOR");
			return false;
		}
		return true;
	}
}
