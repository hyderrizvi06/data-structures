import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        // Read dictionary and novel
        Set<String> dictionaryWords = readWords("Chapter 15 Class Notes/src/words");
        Set<String> novelWords = readWords("Chapter 15 Class Notes/src/throughTheLookingGlass.txt");

        for(String word: novelWords) {
            if(!dictionaryWords.contains(word))
                System.out.println(word);
        }
        System.out.println("Words in Novel: "+novelWords.size());
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        Set<String> words = new HashSet<>();
        //System.out.println(System.getProperty("user.dir"));
        Scanner scan = new Scanner(new File(filename), "UTF-8");

        // Use any character other than letters as delimeters
        scan.useDelimiter("[^a-zA-Z]+");
        
        // Adding words to our set (Ignoring dupes)
        while(scan.hasNext()){
            words.add(scan.next().toLowerCase());
        }
        
        return words;
    }
}
