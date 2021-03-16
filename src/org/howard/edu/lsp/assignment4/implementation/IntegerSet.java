package org.howard.edu.lsp.assignment4.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class IntegerSet 
{
    private static ArrayList<Integer> setA = new ArrayList<Integer>();
    private static ArrayList<Integer> setB = new ArrayList<Integer>();
    
    

    public static void main(String[] args) 
    {
        //prepolulate test Set
        setB.add(1);
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(7);
        setB.add(5);
        setB.add(6);
        setB.add(8);

        menu();//run method called menu 
    }

    public static void menu()
    {
        Scanner scan = new Scanner(System.in);// create a new scanner
        System.out.println("Pick from the 14 options: \n1: clear the array \n2: Length of the array \n3: Does SetA and SetB contain the same data");
        System.out.println("4: Does SetA contain a given value \n5: Largest value of SetA \n6: Smallest value of SetA \n7: Add to SetA \n8: Remove from SetA");
        System.out.println("9: Set union \n10: Set intersection \n11: Set difference \n12: Is setA empty \n13: Display Array \n14: exit");
        //print instructions for user input
        
        
        int userOption = scan.nextInt(); //create a variable name useroption that will recieve user input from the menu
        
        Scanner itemInput = new Scanner(System.in);//create a new scanner for item input
        //create a switch statement with cases for each option
        switch(userOption)
        {
            case 1:
                clear();
                menu();
            break;

            case 2:
                System.out.println("\n" + length()+ " \n ");
                menu();
            break;

            case 3:
                System.out.println("\nSetA does equal SetB: \n" + equal(setB) + "\n");
                menu();
            break;

            case 4:
                System.out.println("Enter a Number: ");
                int containItem = itemInput.nextInt();
                System.out.println("\nSetA does contain the Number "+ containItem + ": \n" + contains(containItem) + "\n");
                menu();
            break;

            case 5:
            	System.out.println("\n" + largest()+ " \n ");
                menu();
            break;

            case 6:
            	System.out.println("\n" + smallest()+ " \n ");
                menu();
            break;

            case 7:
                
                System.out.println("Enter a Number: ");
                int addItem = itemInput.nextInt();
                add(addItem);
                menu();
            break;

            case 8:
                tooString();
                System.out.println("Enter a Number: ");
                int removeItem = itemInput.nextInt();
                remove(removeItem);
                menu();
            break;

            case 9:
                union(setB);
                menu();
            break;

            case 10:
                intersect(setB);
                menu();
            break;

            case 11:
                diff();
                menu();
            break;

            case 12:
                System.out.println("\nSetA is: \n" + isEmpty() + "\n");
                menu();
            break;

            case 13:
                System.out.println("\nSetA is: \n" + tooString() + "\n");
                menu();
            break;
            
            case 14:
                System.exit(0);
            break;

            default:
                System.out.println("Re Enter Your Options That Option Doesnt Exit\n");
                menu();
            break;
        }
    }
    //create a void function for empty array list setA
    public static void clear()
    {
        setA.clear(); 
    }
    
    //create a public static function to return the length of array list size A
    public static int length()
    {
        int set_length;
        set_length = setA.size();   
        return set_length;
    }
    
    //create a public static boolean function to return the outcome of setA & setB
    public static boolean equal(ArrayList<Integer> setB)
    {
        boolean outCome = setA.equals(setB);
        return outCome;
    }
    
  //create a public static boolean function to check to see if setA contain this item
    public static boolean contains(int containItem)
    {
        boolean outCome = setA.contains(containItem);
        return outCome;
    }

    //create a public static int method to find the largest element in the array and return it
    public static int largest() //throws IntegerSetException 
    {
        int large;
        
        large = Collections.max(setA);
        
        return large;
    }

    //create a public static int method to find the smallest element in the array and return it
    public static int smallest() //throws IntegerSetException 
    {
        int small;
        
        small = Collections.min(setA);
        
        return small;
    }

    //create  a public static void method to add item to setA array
    public static void add(int addItem)
    {
        setA.add(addItem);
    }

    //create a public static void method to remove an item
    public static void remove(int removeItem)
    {
       setA.remove(Integer.valueOf(removeItem));
    }

    //create a public static void function to add originals and copy to setA array from setB
    public static void union(ArrayList<Integer> setB)
    {
        setA.addAll(setB);
        System.out.println(setA);
    }

    //create a public static void function to only add orginals to the array setA
    public static void intersect(ArrayList<Integer> setB)
    {
        setA.retainAll(setB);
        System.out.println(setA);
    }
    
    //create a public static void function to remove setB array from setA to find the difference
    public static void diff()//research
    {
        System.out.println("Originals:");
        System.out.println(setA);
        System.out.println(setB);

        setA.removeAll(setB);

        System.out.println("Difference: ");
        System.out.println(setA);
    }
    
    //create a public static boolean function to see if the array is empty and return true or false
    public static boolean isEmpty()
    {
        boolean empty = setA.isEmpty();       
        return empty;
    }

    //create a public static string function to print out the list
    public static String tooString()
    {
        String list = setA.toString();
        return list;
    }
}