import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> gradeBook = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                String name; 
                String grade;
                System.out.println("What is the students name? ");
                name = in.next();
                System.out.println("What is the students grade? ");
                grade = in.next();
                gradeBook.put(name, grade);

            } else if (input.equals("R"))
            {
                System.out.println("What student would you like to remove? ");
                gradeBook.remove(in.next());
            } else if (input.equals("M"))
            {
                String name; 
                String grade;
                System.out.println("What is the students name? ");
                name = in.next();
                System.out.println("What is the students new grade? ");
                grade = in.next();
                gradeBook.put(name, grade);
            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> grades = gradeBook.keySet();
                for(String grade: grades){
                    System.out.println(grade+" has a "+gradeBook.get(grade));
                }
            } else
            {
                done = true;
            }
        }
    }
}
