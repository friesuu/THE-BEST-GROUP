package TUTORIAL7;

import java.util.LinkedList;

public class GenericQueue<Thing>
{
    private LinkedList<Thing> list = new LinkedList<>();

    public void enqueue(Thing element)
    {
        list.addLast(element);
    }

    public Thing dequeue()
    {
        return list.removeFirst();
    }

    public int getSize()
    {
        return list.size();
    }

    public String toString()
    {
        return "Queue" + list.toString();
    }
}
