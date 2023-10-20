import java.util.NoSuchElementException;

/**
 * An implementation of a stack as a sequence of nodes.
*/
public class LinkedListStack
{
    private Node first;

    /**
     * Constructs an empty stack.
    */
    public LinkedListStack()
    {
        first = null;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to add
    */
    public void push(Object element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        this.first = newNode;
    }





    /**
        Removes the element from the top of the stack.
        @return the removed element
    */
    public Object pop(){
        if(!isEmpty()){
            Object popped = this.first.data;
            this.first = this.first.next;
            return popped;
        }
        else
            throw new NoSuchElementException();

        
    }



    /**
     * Checks the top element
     * 
     * @return the first element of the stack
     */
    public Object peek(){
        if(isEmpty())
            throw new NoSuchElementException();
        return first.data;
    }



    /**
     * Checks whether this stack is empty.
     *
     * @return true if the stack is empty
    */
    public boolean isEmpty(){
        return (this.first == null);
    }


    static class Node
    {
        public Object data;
        public Node next;
    }
}
