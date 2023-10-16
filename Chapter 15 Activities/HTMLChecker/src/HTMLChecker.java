import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/HtMLChecker/src/TagSample1.html";
        Stack<String> parts = new Stack<>();

        try (Scanner in = new Scanner(new File(filename)))
        {
            boolean correct = true;
            while(in.hasNext()){
                parts.push(in.next());
            }

            
            String lastPart;
            while(parts.size() > 0 && correct){
                //System.out.println(parts);
                boolean restart = false;
                lastPart = null;
                String gone1 = "0";
                String gone2 = "0";
                boolean end;
                for(String part : parts){
                    if(!restart){
                        end = false;
                        //for(int i = part.length() - 1; i>=0 ; i--){
                            //System.out.println(part);
                            if(part.charAt(1) == '/'){
                                end = true;
                                //System.out.println("1");
                            }
                            if(end){
                                //System.out.println("2");
                                if (!(lastPart != null && lastPart.charAt(1) == part.charAt(2))){
                                    correct = false;
                                    //System.out.println("4");
                                } 
                                else{
                                    //System.out.println("3");
                                    gone1 = lastPart;
                                    gone2 = part;
                                    restart = true;
                                }
                            }
                        //}
                        lastPart = part;
                    }
                }
                parts.remove(gone1);
                parts.remove(gone2);
            }

            if(correct)
                System.out.println("Correct Format");
            else
                System.out.println("no");

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
        
    }
}
