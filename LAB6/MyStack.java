package LAB6;

import java.util.ArrayList;

public class MyStack<Thing>
{
    private ArrayList<Thing> list;

    public MyStack()
    {
        list = new ArrayList<>();
    }

    public int getSize()
    {
        return list.size();
    }

    public Thing peek()
    {
        return list.get(getSize() - 1);
    }

    public void push(Thing object)
    {
        list.add(object);
    }

    public Thing pop()
    {
        Thing object = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return object;
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public boolean search(Thing item) 
    {
        for (int i = list.size() - 1; i >= 0; i--) 
        {
            if (list.get(i).equals(item)) 
            {
                return true;
            }
        }
        return false;
    }

    @Override 
    public String toString()
    {
        return list.toString();
    }
}
