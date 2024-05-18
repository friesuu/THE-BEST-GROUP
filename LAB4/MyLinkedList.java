package LAB4;

public class MyLinkedList<Thing>
{
    Node<Thing> head;
    Node<Thing> tail;
    private int size;

    public MyLinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(Thing element)
    {
        Node<Thing> newNode = new Node<>(element); // Creates a new node
        newNode.next = head; // Sets the next reference of newNode to hold the value of head
        head = newNode; // Set head as newNode
        size++; // ALWAYS increase or decrease size when adding or removing
        if(tail == null)
        {
            tail = head; // If the tail is null means that there is only one element
        }
    }

    public void addLast(Thing element)
    {   
        Node<Thing> newNode = new Node<Thing>(element); // Creates a new node

        if(tail == null)
        {
            tail = head = newNode; // 
        }
        else
        {
            tail.next = newNode; // Set the next reference of tail to hold the value of the newNode
            tail = newNode; // Set tail as the newNode
        }
        size++;
    }

    public void add(int index, Thing element)
    {
        if(index == 0)
        {
            addFirst(element);
        }
        else if(index >= size)
        {
            addLast(element);
        }
        else
        {
            Node<Thing> current = head;
            for(int i = 1; i < index; i++)
            {
                current = current.next;
            }
            Node<Thing> temp = current.next;
            current.next = new Node<Thing>(element);
            (current.next).next = temp;
            size++;
        }
    }

    public Thing removeFirst()
    {
        if(size == 0)
        {
            return null;
        }
        else
        {
            Node<Thing> temp = head; // Create a temporary variable to store the head node
            head = head.next; // Makes the second node the head
            size--; // ALWAYS decrease size for removing
        
            if(head == null) // head.next can be null if there is only one element in the list
            {
                tail = null; // If head equals null, tail also has to be null
            }
            return temp.element; // Returns the element removed
        }   
    }

    public Thing removeLast() 
    {
        if (size == 0) 
            return null;
        else if (size == 1) //only 1 node
        {
            Node<Thing> temp = head;
            head = tail = null; // reset to know
            size = 0;
            return temp.element; // Returns the element that we deleted
        }
        else
        {
            Node<Thing> current = head;
            for (int i = 0; i < size - 2; i++)
                current = current.next; // current holds the value of the element at the last index
            Node<Thing> temp = tail; // copy tail to temp b4 delete. temp holds the value of tail. there are two tails now (temp and tail)
            tail = current; // Set tail to hold the value of the new tail which is the value before the old tail (second last)
            tail.next = null; // reset the next for tail to be null
            size--;
            return temp.element; // Returns the value of the element removed (last element)
        }
    }

    public Thing remove(int index)
    {
        if(index < 0 || index >= size)
        {
            System.out.println("There is no element at this index as it is out of bounds of the list");
            return null;
        }
        else if(index == 0) // Index 0 is the index of the first element
        {
            return removeFirst();
        }
        else if(index == (size-1)) // Index - 1 is the index of the last element
        {
            return removeLast();
        }
        else
        {
            Node<Thing> previous = head;
            for(int i = 1; i < index; i++)
            {
                previous = previous.next; // Traverse through the elements and stopping one index before the required one. previous now holds the value at the index that we want to remove
            }
            Node<Thing> current = previous.next; // Creating a new node, current, which holds the value of the node at the index after the index that we wanna remove
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    public boolean contains(Thing element)
    {
        Node<Thing> current = head;
        for(int i = 0; i < size; i++)
        {
            if(current.element == element)
            {
                return true; // Returns true if the element at the current index is equal to the element that we're looking for
            }
            current = current.next; // Traversing through the elements
        }
        return false; // Returns false if the element is not found
    }

    public Thing get(int index)
    {
        Node<Thing> current = head;
        int count = 0;
        while (current != null) // Use while loops to traverse throught he elements as long as the node is not null
        {
            if (count == index) 
            {
                return current.element; // Returns element at current index if count == index
            }
            count++;
            current = current.next; // Go to the next element
        }
        throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
    }

    public Thing getFirst()
    {
        return head.element; // Returns the element of the head
    }

    public Thing getLast()
    {
        return tail.element; // Returns the element of the tail
    }

    public int indexOf(Thing element)
    {
        Node<Thing> current = head;
        for(int i = 0; i < size; i++)
        {
            current = current.next;
            if(current.element == head.element)
            {
                return i;
            }
        }
        return -1; // Element not found
    }

    public int lastIndexOf(Thing element)
    {
        Node current = head;
        int index = -1; // Initialize with -1, which indicates not found
        int currentIndex = 0;
        while (current != null) {
            if (current.element == element) {
                index = currentIndex; // Update index when value is found
            }
            current = current.next;
            currentIndex++;
        }
        return index;
    }

    public Thing set(int index, Thing element)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<Thing> current = head;
        for(int i = 0; i == index; i++)
        {
            current = current.next; // Traversing through the elements. current now holds the element of the node at the index required
        }
        current.element = element; // Change the element at the index required to the element that we want
        return element; // Returns the new element of the node
    }

    public void print() {
        System.out.print("[");
        Node<Thing> current = head;
        while (current != null) {
            System.out.print(current.element);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
}
