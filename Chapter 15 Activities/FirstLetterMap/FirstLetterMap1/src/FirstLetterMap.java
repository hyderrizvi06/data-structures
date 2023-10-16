import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter.
 * Then print out the word sets in alphabetical order.
 * Use the Java 8 merge() feature.
*/
public class FirstLetterMap
{
    public static void main(String[] args)
    {
        //System.out.println(System.getProperty("user.dir"));
        String filename = "Chapter 15 Activities/FirstLetterMap/FirstLetterMap1/src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            Map<Character, Set<String>> firstLetter = new HashMap<>();
            String abc = "abcdefghijklmnopqrstuvwxyz";
            for(int i = 0; i < 26; i++){
                Set<String> set = new HashSet<>(0);
                firstLetter.put(abc.charAt(i), set);
            }

            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);

                firstLetter.merge(c, new HashSet<>(Arrays.asList(word)), (oldValue, newValue) -> new HashSet<>(oldValue.toArray())
                    );

                // Update the map here
                // Use the Java 8 merge method
                

            }

            // Print the map here in this form
            // a: [a, able, aardvark]
            for(int i = 0; i < 26; i++){
                System.out.println(abc.charAt(i) + ": " + firstLetter.get(abc.charAt(i)));
            }


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
