import java.util.*;

public class MorseCode
{
    private static final char DOT = '.';
    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode decodeTree;

    public static void main(String[] args)
    {
        MorseCode.start();  
        System.out.println(MorseCode.encode("Watson come here"));
        BTreePrinter.printNode(decodeTree);
    }

    public static void start()
    {
        codeMap = new TreeMap<Character, String>();
        decodeTree = new TreeNode(' ', null, null);  // autoboxing
        // put a space in the root of the decoding tree

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }

    /**
     * Inserts a letter and its Morse code string into the encoding map
     * and calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char letter, String code)
    {
        /*
            !!! INSERT CODE HERE
        */
        codeMap.put(letter, code);
        treeInsert(letter, code);
    }

    /**
     * Inserts a letter and its Morse code string into the
     * decoding tree.  Each dot-dash string corresponds to a path
     * in the tree from the root to a node: at a "dot" go left, at a "dash" go
     * right.  The node at the end of the path holds the symbol
     * for that code string.
    */ 
    private static void treeInsert(char letter, String code)
    {
        treeInsert(letter, code, decodeTree);
    }
    

    private static void treeInsert(char letter, String code, TreeNode current)
    {
        /*
            !!! INSERT CODE HERE
        */
        TreeNode leaf = new TreeNode(letter);
        TreeNode path = new TreeNode(code.charAt(0));

        //While there is more than one charater left, it will check whether left/right is occupied or not. If not, it puts the correct node there
        //If it is, it moves to that node until it reaches the node right before the leaf
        if(code.length() > 1){
            if(code.charAt(0) == DOT){
                if(current.getLeft() == null){
                    current.setLeft(path);
                }
                
                treeInsert(letter, code.substring(1), current.getLeft());
                return;
            }
            if(code.charAt(0) == DASH){
                if(current.getRight() == null){
                    current.setRight(path);
                }
                
                treeInsert(letter, code.substring(1), current.getRight());
                return;
            }
            return;
        }
        
        //Puts the leaf in place of the final node.
        if(code.charAt(0) == DOT){
            if(current.getLeft() != null){
                if(current.getLeft().getRight() != null){
                    leaf.setRight(current.getLeft().getRight());
                }
                if(current.getLeft().getLeft() != null){
                    leaf.setLeft(current.getLeft().getLeft());
                }
            }
            current.setLeft(leaf);
            return;
        }

        if(code.charAt(0) == DASH){
            if(current.getRight() != null){
                if(current.getRight().getRight() != null){
                    leaf.setRight(current.getRight().getRight());
                }
                if(current.getRight().getLeft() != null){
                    leaf.setLeft(current.getRight().getLeft());
                }
            }
            current.setRight(leaf);
            return;
        }

    }

    /**
     * Converts text into a Morse code message.  Adds a space after a dot-dash
     * sequence for each letter.  Other spaces in the text are transferred directly
     * into the encoded message.
     * Returns the encoded message.
     */
    public static String encode(String text)
    {
        StringBuffer morse = new StringBuffer(400);
        text = text.toUpperCase();
        /*
            !!! INSERT CODE HERE
        */
        Scanner scan = new Scanner(text);
        //Checks through text, and creates a variable for each word
        while(scan.hasNext()){
            String word = scan.next();
            //Appends code for each letter
            while(word.length() > 0){
                char letter = word.charAt(0);
                String code = codeMap.get(letter);
                morse.append(code + " ");
                word = word.substring(1);
            }
            morse.append("_ ");
        }
        scan.close();
        return morse.toString();
    }

    /**
     * Converts a Morse code message into a text string.  Assumes that dot-dash
     * sequences for each letter are separated by one space.  Additional spaces are
     * transferred directly into text.
     * Returns the plain text message.
     */
    public static String decode(String morse)
    {
        StringBuffer text = new StringBuffer(100);
        TreeNode current = decodeTree;
        Scanner scan = new Scanner(morse);
        //Checks through text, and creates a variable for each code
        while(scan.hasNext()){
            current = decodeTree;
            String code = scan.next();
            if(code.equals("_")){
                text.append(" ");
            }
            else{
            System.out.println("1: "+code);
            char letter;
            //Locates the node containing the correct 
            while(code.length() > 1){
                char c = code.charAt(0);
                System.out.println("2: "+c+" "+code.length());
                if(c == DOT){
                    current = current.getLeft();
                }
                else if(c == DASH){
                    current = current.getRight();
                }

                code = code.substring(1);
                System.out.println("3: "+code+"\n");
            }
            char c = code.charAt(0);
            
            if(c == DOT){
                letter = current.getLeft().getValue().toString().charAt(0);
            }
            else{
                letter = current.getRight().getValue().toString().charAt(0);
            }
            
            text.append(letter);
            System.out.println("LETTER: "+letter);
            System.out.println("4: "+text);
            }
        }
        System.out.println("5: "+text);
        scan.close();
        return text.toString();
    }
}

/**
 * BTreePrinter class courtesy of Karen Ge (@karenge1)
 */
class BTreePrinter {

    public static void printNode(TreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.getLeft()), 
            BTreePrinter.maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}

