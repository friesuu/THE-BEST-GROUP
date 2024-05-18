package LAB4;

public class Node<Thing> 
{
    Thing element;
    Node next;
    
    public Node(Thing element)
    {
        this.element = element;
        this.next = null;
    }
}
