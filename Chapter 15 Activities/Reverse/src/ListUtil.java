import java.util.LinkedList;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        LinkedList<String> reversed = new LinkedList<>();
        for (String n: strings){
            reversed.addFirst(n);
        }
        
        //System.out.println(reversed);
        int i = 0;
        while (i < strings.size()){
            strings.set(i, reversed.get(i));
            i++;
        }
    }
}