package TUTORIAL4;

public class Node<Thing> 
{
    Thing element;
    Node<Thing> next;

    public Node(Thing element)
    {
        this.element = element;
        this.next = null;
    }

    public void addFirst(Thing e)
    {
            Node<Thing> firstNode = new Node<>();
            firstNode.next = head;
            head = firstNode;
            size++;
            if(tail == null)
                tail = head;
    }

}
