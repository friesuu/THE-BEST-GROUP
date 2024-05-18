package Scribbles;

// import LAB4.MyLinkedList;

public class Main 
{
    public static void main(String[] args) 
    {
        // MyLinkedList<String> list = new MyLinkedList<String>();
        
        // list.addFirst("fuck");
        // list.add(1, "bruh");
        // list.addLast("null");
        // list.addLast("Honda Civic");
        // list.addLast("911 GT3RS");

        // //list.remove(1);
        // System.out.println(list.remove(1));

        // list.print();

        // System.out.println(list.toString());

        
        MyDoublyLinkedList<Integer> dll = new MyDoublyLinkedList<Integer>();

        dll.append(1);
        dll.append(2);
        dll.append(3);

        dll.prepend(0);

        System.out.println("Doubly Linked List:");
        dll.display();

        dll.insertAtIndex(2, 99);

        System.out.println("After inserting 99 at index 2:");
        dll.display();
        
    }    
}
