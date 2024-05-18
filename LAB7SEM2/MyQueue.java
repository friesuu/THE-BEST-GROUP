package LAB7SEM2;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyQueue<Thing>
{
    private LinkedList<Thing> list;

    public MyQueue()
    {
        list = new LinkedList<Thing>();
    }

    public MyQueue(Thing[] element)
    {
        this.list = new LinkedList<Thing>();

        for(int i = 0; i < element.length; i++)
        {
            this.enqueue(element[i]);
        }
    }

    public void enqueue(Thing element)
    {
        list.addLast(element);
    }

    public Thing dequeue()
    {
        if(list.isEmpty())
        {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    public Thing getElement(int index)
    {
        if(index <= 0 || index >= list.size())
        {
            throw new IndexOutOfBoundsException();
        }
        return list.get(index);
    }

    public Thing peek()
    {
        if(list.isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }
        return list.getFirst();
    }

    public int getSize()
    {
        return list.size();
    }

    public boolean contains(Thing element)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) == element)
            {
                return true;
            }
        }

        return false;

        // return list.contains(element);
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public String toString()
    {
        return list.toString();
    }
}
