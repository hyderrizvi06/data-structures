/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList students = new LinkedList();
        students.addFirst("Preston");
        students.addFirst("Kaushik");
        students.addFirst("Guzal");
        students.addFirst("Emma");

        System.out.println(students);

        ListIterator iterator = students.listIterator();
        iterator.next();
        iterator.add("Hyder");
        iterator.next();
        iterator.remove();
        
    }
}
