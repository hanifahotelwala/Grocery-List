
/**
 * This class generates a grocery list. 
 * Datastructure implemented in this class demonstrates a Linked List. 
 * In charge of adding/removing from a list.
 * 
 * CS Project: Grocery List
 * By: Hanifa Hotelwala
 * 02/03/2018
 */
public class GroceryList
{

    public SingleLink first; // reference to the first link in the LinkList
    int id= 100; 
    int counter=1; 

    /**
     * Constructor for class LinkList
     */
    public GroceryList()
    {
        first = null; // no links in the list yet
    }

    /**
     * Returns true if the linked list is empty 
     */
    public boolean isEmpty()
    {
        return (first==null); 
    }

    /**
     * Finds the link with the matching key
     */
    public SingleLink find(int key)
    {
        SingleLink curr = first; 
        while(curr.id !=key)
        {
            if(curr.next==null)
                return null; 
            else
                curr = curr.next; 
        }
        return curr; 
    }

    /**
     * 'checks' an item to be placed inside a different grocery list. 
     */
    public void checkedItem(int key, GroceryList list,  int quantity)
    {
        SingleLink checkedItem = list.find(key); 
        checkedItem.groceryItem.quantity=quantity; 
        insertFirst(checkedItem.groceryItem); 
    }

    /**
     * Creates a new link and connects links together 
     */
    public void insertFirst(SingleItem groceryItem)
    {
        SingleLink newLink = new SingleLink(groceryItem, id); // new link created
        newLink.next = first; //newLink points to firstLink
        first = newLink; // firstLink points to null. 
        id--;
    }

    /**
     * Removes a link
     */
    public SingleLink removeFirst(int key)
    {
        SingleLink temp = first; 
        SingleLink prev= null; 
        while(temp.id !=key)
        {
            if(temp.next==null)
            {
                return null; 
            }
            else
            {
                prev = temp; 
                temp = temp.next; 
            }
        }

        if (temp == first)
            first = first.next; 
        else
            prev.next= temp.next; 

        return temp; 
    }

    /**
     * Displays the current grocery list
     */
    public void displayList()
    {
        System.out.println("Current Grocery List: \n");
        SingleLink current = first; 

        while(current!=null)
        {
            current.displayLink(); 

            current = current.next; 

        }
        System.out.println(""); 
    }

    /**
     * Displays the full grocery list, includes checked items
     */
    public void displayFullList()
    {
        SingleLink curr = first; 
        while( curr!=null)
        {
            System.out.print(counter+".) ");
            curr.displayFullInfo(); 
            curr = curr.next; 
            counter++; 

        }

        System.out.println(); 
        counter =1; 
    }

    
}
