package Scribbles;

// public class Node<Thing>
// {
//     Thing element;
//     Node<Thing> next;

//     public Node(Thing element)
//     {
//         this.element = element;
//         this.next = null;
//     }
// }

public class Node<Thing>
{
    int data;
    Node<Thing> prev;
    Node<Thing> next;

    public Node(int data) 
    {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
