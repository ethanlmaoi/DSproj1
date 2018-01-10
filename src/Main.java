/*
 * file: Main.java
 * author: Ethan Liao
 * class: CS141 - Programming and Problem Solving
 * 
 * assignment: program 1
 * date last modified: 10/17/2017
 * 
 * purpose: This program reads from a standard input a sequence of integer values, with each value separated by a space.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main 
{
	// method: main
	// purpose: builds a binary search tree and a prompt will specify user to input a sequence of integers
	//          will print out three traversals (inorder, preorder, postorder)
	//          allow user to add and remove values or obtain the successor and predecessors of specified values
	public static void main(String args[])
	{
		BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		System.out.println("Please enter the initial sequence of values: ");
		
		Integer[] intArray = new Integer[10000];
		String input = scanner.nextLine() + " ";
		String currentNumber = "";
		int place = 0;
		int index = 0;
		while (place < input.length())
		{
			if (isInteger(input.substring(place, place+1)))
			{
				currentNumber = currentNumber + input.substring(place, place+1);
				place++;
			}
			else if (input.substring(place, place+1).equals(" "))
			{
				intArray[index] = Integer.parseInt(currentNumber);
				currentNumber = "";
				index++;
				place++;
			}
		}
		
		for (int i = 0; i < intArray.length; i++)
		{
			if (intArray[i] != null)
				searchTree.add(intArray[i]);
			else
				break;
		}
		
		System.out.print("Pre-order: ");
		searchTree.preorderTraverse();
		System.out.println();
		
		System.out.print("In-order: ");
		searchTree.inorderTraverse();
		System.out.println();
		
		System.out.print("Post-order: ");
		searchTree.postorderTraverse();
		System.out.println();
		
		while (running)
		{
			try
			{
				System.out.print("Command? (Enter H for help!): ");
				
				String input2 = scanner.nextLine();
				if (Character.toString(input2.charAt(0)).equals("I"))
				{
					if (!numberExists(searchTree,Integer.parseInt(input2.substring(2))))
					{
						try
						{
							searchTree.add(Integer.parseInt(input2.substring(2)));
							System.out.print("In-order: ");
							searchTree.inorderTraverse();
							System.out.println();
							index++;
						}
						catch (Exception ex)
						{
							System.out.println("Not a number or incorrect formatting!");
						}
					}
					else
					{
						System.out.println(Integer.parseInt(input2.substring(2)) + " already exists, ignore.");
					}
				}
				else if (Character.toString(input2.charAt(0)).equals("D"))
				{
					if (!numberExists(searchTree,Integer.parseInt(input2.substring(2))))
					{
						System.out.println(Integer.parseInt(input2.substring(2)) + " doesn't exist!");
					}
					else
					{
						searchTree.remove(Integer.parseInt(input2.substring(2)));
						System.out.print("In-order: ");
						searchTree.inorderTraverse();
						System.out.println();
						index--;
					}
				}
				else if (Character.toString(input2.charAt(0)).equals("P"))
				{
					int predecessor = (int)(searchTree.obtainPredecessor(Integer.parseInt(input2.substring(2))));
					System.out.println(predecessor);
				}
				else if (Character.toString(input2.charAt(0)).equals("S"))
				{
					int successor = (int)(searchTree.obtainSuccessor(Integer.parseInt(input2.substring(2))));
					System.out.println(successor);
				}
				else if (Character.toString(input2.charAt(0)).equals("H"))
				{
					System.out.println("\nI  Insert a value");
					System.out.println("D  Delete a value");
					System.out.println("P  Find predecessor");
					System.out.println("S  Find successor");
					System.out.println("E  Exit the program");
					System.out.println("H  Display this message\n");
				}
				else if (Character.toString(input2.charAt(0)).equals("E"))
				{
					System.out.println("Thank you for using my program");
					System.exit(0);
				}
			}
			catch (Exception ex)
			{
				System.out.println("Incorrect formatting!");
			}
		}
		
	}
	
	// method: isInteger
	// purpose: will check if a specified string is an integer
	public static boolean isInteger(String str) 
	{
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}
	
	// method: numberExists
	// purpose: will check if a number exists in a specified search tree
	public static boolean numberExists(BinarySearchTree<Integer> searchTree, int number)
	{
		return searchTree.contains(number);
	}
}
