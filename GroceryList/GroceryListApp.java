import java.io.*;
import java.util.*;

/**
 * CS Project: Grocery List
 * By: Hanifa Hotelwala
 * 02/03/2018
 * 
 * Two lists are created through the GroceryListApp: the checked list and the original. 
 * The checked list specifies the quantity of the grocery item the user wants to buy.
 * The original list contains the general items the user is considering to buy.
 * Every item that the user enters is first placed into the original list, if the user plans on purchasing the item
 * that item is then stored into a checked list with the desired quantity. 
 */

public class GroceryListApp
{

    public static void main(String[]args) throws IOException
    {
        // preparing for input
        InputStreamReader isr = new InputStreamReader(System.in); 
        BufferedReader br = new BufferedReader(isr);              
        String inData="";                                           

        //declaring and initializing variables
        GroceryList groceryList = new GroceryList(); 
        GroceryList checkedGroceryList = new GroceryList(); 
        String newItem;
        int choice= 0;
        int quantity= 0; 
        int count=0;
        int counter=0;
        int key =0; 

        //displaying the menu 
        while(true)
        {
            System.out.println("------------------------------------");
            System.out.println("Grocery Shopping Menu:  ");
            System.out.println("Enter 'A' -> ADD an item to your list");
            System.out.println("Enter 'B' -> REMOVE an item from the list");
            System.out.println("Enter 'C' -> CHECK an item for next time");
            System.out.println("Enter 'D' -> UNCHECK an item from your [checked] list");
            System.out.println("Enter 'E' -> DISPLAY [checked] list");
            System.out.println("Enter 'F' -> DISPLAY original grocery list");
            System.out.println("Enter 'G' -> EXIT the program");
            System.out.println("------------------------------------");
            System.out.print("Your choice :  ");

            //Read user interface
            inData = br.readLine();   

            if(inData.equals(""))
                inData= "a";

            choice = inData.trim().toLowerCase().charAt(0); 
            
            switch(choice)
            {
                case 'a':  
                System.out.println("\nYou have selected the option add an item to the initial grocery list: "); 
                System.out.print("\n");
                System.out.print("Name of item: ");
                newItem=br.readLine();
                SingleItem itemNew = new SingleItem(newItem);
                groceryList.insertFirst(itemNew);
                System.out.println("Item has been added! ");
               
                break;

                case 'b': 
                System.out.println("\nYou have selected to remove an item from the initial grocery list: "); 
                while(count==0){
                    System.out.print("\n");
                    try {
                        groceryList.find(100);
                        groceryList.displayList();
                        System.out.print("Please enter the number next to the item you wish to delete. ");
                        try{
                            inData = br.readLine();                       
                            key = Integer.parseInt(inData);
                            if( groceryList.find(key)!=null){ //checks if the code is linked to an item
                                groceryList.removeFirst(key);
                                count++; //get out of the loop because the item is found and deleted
                                try {
                                    groceryList.find(999); //checks to see if there are any items on the list
                                    System.out.println("List has been updated! ");
                                    
                                }
                                catch (Exception e)
                                {
                                    System.out.println("Empty list.");
                                }
                            }
                            else 
                                System.out.println("Incorrect input");
                        }
                        catch (NumberFormatException ne){ //catches the invalid user input and continues to run the program
                            System.out.println("Not possible. Please choose one of the options.");
                        }
                        catch (Exception e){   //catches the invalid user input and continues to run the program
                            System.out.println("Not possible. Please choose one of the options. ");
                        }

                    }
                    catch (Exception e)
                    {
                        System.out.println("You do not have any items in this list!");
                    }
                } 
                count=0;
                break;

                case 'c': 
                System.out.println("You have selected the option to check an item from the original grocery list\n and add it to the checked list: "); 
                while(count==0){
                    System.out.print("\n");
                    try {
                        groceryList.find(1);
                        groceryList.displayList();
                        System.out.print("Choose the number next to the item you want to put on your list\nthe next time you go grocery: ");
                        try{
                            inData = br.readLine();                   
                            key = Integer.parseInt(inData);
                            if (groceryList.find(key)!=null){

                                counter=0;
                                while(counter==0){
                                    try{
                                        System.out.print("Please add the quantity: ");
                                        inData = br.readLine();       
                                        quantity = (int)Double.parseDouble(inData);
                                        counter++;
                                    }
                                    catch (NumberFormatException ne){ //catches the invalid user input and continues to run the program
                                        System.out.println("Not possible. Please choose one of the options.");
                                    }
                                    catch (Exception e){   //catches the invalid user input and continues to run the program
                                        System.out.println("Not possible. Please choose one of the options. ");
                                    }
                                }
                                checkedGroceryList.checkedItem(key, groceryList, quantity);
                                count++; // exit the loop because the item is found and checked successfully
                                System.out.println("Checked list has been updated! ");
                                
                            }
                            else
                                System.out.println("The code is incorrect. Please try again.");
                        }
                        catch (NumberFormatException ne){ //catches the invalid user input and continues to run the program
                            System.out.println("Not possible. Please choose one of the options.");
                        }
                        catch (Exception e){   //catches the invalid user input and continues to run the program
                            System.out.println("Not possible. Please choose one of the options. ");
                        }

                    }
                    catch (Exception e)
                    {
                        System.out.println("Empty list. Refer back to the menu to add an item to the list.");
                        count++;
                    }

                }
                count=0; 
                counter=0; 
                break;

                case 'd':  
                System.out.println("You have selected the option to uncheck an item from the checked list: "); 
                while(count==0){
                    System.out.print("\n");
                    try {
                        checkedGroceryList.find(100); //checks to see if there are any items to delete
                        checkedGroceryList.displayList();
                        try{
                            System.out.print("Enter the number next to the item you want to uncheck from the list: ");
                            inData = br.readLine();                   
                            key = Integer.parseInt(inData);
                            if (checkedGroceryList.find(key)!=null){
                                checkedGroceryList.removeFirst(key);
                                count++;
                                try {
                                    checkedGroceryList.find(1);
                                    System.out.println("Checked list has been updated!");
                                    
                                }
                                catch (Exception e)
                                {
                                    System.out.println("Empty list. Refer back to the menu to add an item to the list.");
                                }
                            }    
                            else
                                System.out.println("Incorrect number. Please try again.");
                        }
                        catch (NumberFormatException ne){ //catches the invalid user input and continues to run the program
                            System.out.println("Not possible. Please choose one of the options.");
                        }
                        catch (Exception e){   //catches the invalid user input and continues to run the program
                            System.out.println("Not possible. Please choose one of the options. ");
                        }

                    }
                    catch (Exception e)
                    {
                        System.out.println("Empty list. Refer back to the menu to add an item to the list.");
                        count++;
                    }
                }
                count=0;
                break;

                case 'e': 
                System.out.println("\nYou have selected the option to display the checked grocery list: ");
                System.out.print("\n");
                try {
                    checkedGroceryList.find(1);
                    System.out.println("\nYour list for the next time you go grocery shopping:");
                    checkedGroceryList.displayFullList();
                }
                catch (Exception e){
                    System.out.println("List empty. Refer back to the menu to add an item to the list.");
                }
                break;

                case 'f':  
                System.out.println("\nYou have selected the option to display the initial grocery list: ");
                //displays the original
                System.out.print("\n");
                try {
                    groceryList.find(100);
                    System.out.println("\nYour initial list:");
                    groceryList.displayFullList();
                }
                catch (Exception e)
                {
                    System.out.println("List empty. Refer back to the menu to add an item to the list.");
                }
                break;


                case 'g': 
                System.out.println("\nYou have selected the option exit out of this menu, bye!");
                System.exit(10); 
                break;


                default:
                System.out.println("Please choose one of the options"); 
            }

        }
    }
}
