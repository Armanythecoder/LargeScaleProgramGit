package org.howard.edu.lsp.assignment4.test;

import java.util.Arrays;
import java.util.ArrayList;


//this is our main class it is what drives and controls the program
public class Driver
{   public static void main(String[] args)
	{ 
		//this is the object of implementation
		Implementation implement = new Implementation();
		Integer[] listOfNumbers = {1,2,3,3,4,9,8,8,4,5,7,10,10};//list of numbers as an array
		int targetSum = 6;//targetsum 
		
		//implement object calling sum up method from implmentation class
		implement.sumUp(new ArrayList<Integer>(Arrays.asList(listOfNumbers)),targetSum);
		
	}
}
	//create the implementation class
	class Implementation
	{
		
		//this is the sum recursive method that calculates and defines all possible combinations to reach target sum
		public static void sumUpRecursive(ArrayList<Integer>listOfNumbers, int targetSum, ArrayList<Integer> configue) 
		{
			//set startibg standard before calculation
			int starter = 0;
			
			//this for loop goes through the list of numbers to print out the output required
			//this prints out the location of the numbers in the array not the numbers themselves
			for(int x : configue) starter+=x;
			{
				if(starter==targetSum) 
				{
					System.out.println("Sum: " + Arrays.toString(configue.toArray()) + " = " + targetSum);
					// prints where the number are in the array list
				}
				
				if(starter >= targetSum) //this if statement check if starting number = target sum if not do nothing
				{
					return;
				}
			}
			
			//this for loop calculates the combinations 
			for(int i = 0; i < listOfNumbers.size(); i++) 
			{
				 ArrayList<Integer> theRemaining = new ArrayList<Integer>();//new array list to hold the remaining numbers for more combinations
				 int remaining = listOfNumbers.get(i);
				
				 
				//this for loops add the remaining combinations together and add the remaining number for the array list
				for(int j = i +1; j < listOfNumbers.size(); j++) theRemaining.add(listOfNumbers.get(j)); 
				{
					ArrayList<Integer> partialConfigue = new ArrayList<Integer>(configue);
					//this array list contain the array list configue
					partialConfigue.add(remaining);
					
					//method recursion using for loop
					sumUpRecursive(theRemaining,targetSum, partialConfigue);
					
				}
			}
		}
		
		//sum of method that is used for calling the combination method and making sure recursion works
		public static void sumUp(ArrayList<Integer>listOfNumbers,int targetSum)
		{
			sumUpRecursive(listOfNumbers, targetSum, new ArrayList<Integer>());
		}
		
		
	}

