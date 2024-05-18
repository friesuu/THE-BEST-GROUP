package LabTest2;

import java.util.ArrayList;

public class BorrowedBookStack<Thing>
{
    private ArrayList<Thing> list;
    private int maxSize;

    public BorrowedBookStack(int size)
    {
        list = new ArrayList<Thing>();
        this.maxSize = size;
    }

    public void borrowBook(Thing bookID)
    {
        if(!isFull())
        {
            list.add(bookID);
        }
        else
        {
            throw new StackOverflowError("Stack is full");
        }
    }

    public int getSize()
    {
        return list.size();
    }

    public Thing returnBook()
    {
        Thing object = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return object;
    }

    public Thing peekAtTopBook()
    {
        return list.get(getSize() - 1);
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public boolean isFull()
    {
        if(list.size() >= maxSize)
        {
            return true;
        }
        return false;
    }

    public String toString()
    {
        return list.toString();
    }
}
