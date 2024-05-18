package Scribbles;

public class MyDoublyLinkedList<Thing>
{
    private Node<Thing> head;
    private Node<Thing> tail;

    public MyDoublyLinkedList() 
    {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) // addLast
    {
        Node<Thing> newNode = new Node<Thing>(data);
        if (head == null) 
        {
            head = newNode;
            tail = newNode;
        } 
        else 
        {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void prepend(int data) // addFirst
    {
        Node<Thing> newNode = new Node<Thing>(data);
        if (head == null) 
        {
            head = newNode;
            tail = newNode;
        } 
        else 
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtIndex(int index, int data) 
    {
        if (index < 0) 
        {
            System.out.println("Invalid index");
            return;
        }

        Node<Thing> newNode = new Node<Thing>(data);
        if (index == 0) 
        {
            prepend(data);
            return;
        }

        Node<Thing> current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) 
        {
            current = current.next;
            currentIndex++;
        }

        if (current == null) 
        {
            System.out.println("Index out of bounds");
            return;
        }

        newNode.prev = current.prev;
        newNode.next = current;
        if (current.prev != null) 
        {
            current.prev.next = newNode;
        }
        current.prev = newNode;
    }

    public void delete(int value) // Deletes a node with a specific value
    {
        Node<Thing> current = head;
        while (current != null) 
        {
            if (current.data == value) 
            {
                if (current.prev != null) 
                {
                    current.prev.next = current.next;
                }
                if (current.next != null) 
                {
                    current.next.prev = current.prev;
                }
                if (current == head) 
                {
                    head = current.next;
                }
                if (current == tail) 
                {
                    tail = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    public void display() 
    {
        Node<Thing> current = head;
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


