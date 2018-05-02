
/**
 * Link creates the link that will be a part of the linked list of the Grocery List. 
 * Creates a reference name of 'groceryItem' to reference to the object created that 
 * corresponds to the Item class.
 * 
 * CS Project: Grocery List
 * By: Hanifa Hotelwala
 * 02/03/2018
 */
public class SingleLink
{
    //variables 
    SingleLink next; //next link in list

    //Item groceryItem; 
    SingleItem groceryItem;
    int quantity =0; 
    int id; 

    /**
     * Constructor for objects of class Link
     */
    public SingleLink(SingleItem groceryItem, int id)
    {
        // initialise instance variables
        this.groceryItem = groceryItem; 
        this.id= id;
    }

    /**
     * Displays the link of just the name of the grocery item. 
     */
    public void displayLink()
    {
        System.out.println(id+". "+this.groceryItem.nameOfGrocery);  
    }

    /**
     * Displays the name of the grocery item and the quantity. 
     * 
     */
    public void displayFullInfo()
    {
        if( (groceryItem.quantity!=0))
            System.out.println(groceryItem.nameOfGrocery+"\t Quantity: "+groceryItem.quantity); 
        else
            System.out.println(groceryItem.nameOfGrocery); 
    }

}
