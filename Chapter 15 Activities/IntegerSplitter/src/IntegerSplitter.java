import java.util.Scanner;
import java.util.Stack;
/**
 * Class for splitting an integer into its individual digits.
*/
public class IntegerSplitter
{
    /**
     * Splits the given integer into its individual digits
     * and prints them to the screen.
     *
     * @param number Integer to be split.
    */


    public static void split(int number)
    {   
        Stack<String> splitter = new Stack<>();

        String num = (""+number);

        for (int i = num.length() - 1; i >= 0 ; i--){
            String add = (""+num.charAt(i));
            splitter.push(add);
        }

        for (int i = splitter.size(); i > 0; i--){
            System.out.print(splitter.pop()+" ");
        }





    }
}
