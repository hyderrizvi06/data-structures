import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        Queue<String> jobs = new LinkedList<>();

        jobs.add("Joe: Expense Report 2023");
        jobs.add("Cathy: Top Secret Doc #5");
        
        System.out.println("Printing: "+jobs.remove());
        jobs.add("Cathy: Joe's SSN");
        jobs.add("Joe: Grocery List");
        jobs.add("Cathy: Can I Get Fired for This?");
        
        System.out.println("Printing: "+jobs.remove());
        jobs.add("Boss: Cathy's Letter of Termination");
        
        // Print the rest of the jobs in the queue
        while(jobs.size() > 0){
            System.out.println("Printing: "+jobs.remove());
        }
        
    }
}
