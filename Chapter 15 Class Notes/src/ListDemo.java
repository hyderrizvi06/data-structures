import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        // The addLast method can be used to populate a list
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Diana");
        staff.addLast("Harry");
        staff.add("Romeo"); //Same function as addLast
        staff.addLast("Tom");
        System.out.println(staff);

        // List is currently: DHRT
        /*
         * The listIterator method creates a new list iterator that is positioned at the head of the list
         * "|" will be used in comments to represent itarator position
         * ex: DH|RT means the iterator is between Harry and Romeo
         */

         ListIterator<String> iterator = staff.listIterator(); //|DHRT

         iterator.next(); //D|HRT
         //iterator.next() moves iterator one variable    
         
         String name = iterator.next(); //DH|RT

         //iterator.next() also returns value of the variable it passes
         System.out.println(name);

         /*
          * The add method for iterators adds the value at the position of the iterator
          * The iterator is then positioned after the element added
          */

         iterator.add("Juliet"); //DHJ|RT
         iterator.add("Nina"); //DHJN|RT

         /*
          * The iterator remove method returns the element returned by the last call to next or previous
          * The iterator remove method can only be called after calling next or previous
          * It CANNOT be called after add
          */

          iterator.next(); //DHJNR|T
          iterator.remove(); //DHJN|T
          

          /* 
           * The set method updates the element returned by the last call to next or previous
           */

           
          iterator.previous(); //DHJ|NT
          iterator.set("Albert"); //DHJ|AT

          iterator = staff.listIterator(); //moves iterator back to beginning of list
          //|DHJAT
          
          /*
           * The hasNext method returns true if the list has another element
           * Usually used for while loops
           */

          while(iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Juliet"))
                //DHJ|AT
                iterator.remove(); //DH|AT
          } //DHAT|

          // Enhanced for loop can be used with a linked list
          for(String n: staff){
            System.out.print(n + " ");
          }
          
          iterator = staff.listIterator();
          while(iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Harry")){
                // staff.remove("Diana"); This causes an error for changing the list while using an iterator without using for this specific change 
                // ConcurrentModificationException
            }

          }
          
          //An enhanced for loop AUTHOMATICALLY creates an iterator!
          for (String n: staff) {
            if(n.equals("Harry")){
              // staff.add("Charlie"); causes ConcurrentModificationException
            } 
          }


    }
}
