import java.util.Stack;
import java.util.Scanner;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String> commands = new Stack<>();

        commands.push("Insert: 'Hello'");
        commands.push("Insert: ','");
        commands.push("Insert: ' '");
        commands.push("Insert: 'World'");
        commands.push("Insert: '?'");
        commands.push("Delete: '?'");
        commands.push("Insert: !");

        System.out.println(commands); //Top of stack will be far right

        // Simulate the user pressing the undo button 4 times
        Scanner scan = new Scanner(System.in);
        String choice = "0";

        while(!(choice.equals("X"))){
            System.out.println("\nBack Log: "+commands);
            System.out.println("""
                    Z: Undo
                    C: Enter new item
                    X: Exit\n
                    """);
            choice = scan.next();
            if(choice.equals("Z"))
                commands.pop();
            if(choice.equals("C")){
                System.out.println("\nEnter: ");
                String entry = scan.next();
                commands.add(entry);    
            }
        }
    }
}
