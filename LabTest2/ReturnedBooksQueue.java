package LabTest2;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class ReturnedBooksQueue<Thing>
{
    private LinkedList<Thing> list;
    private int maxSize;

    public ReturnedBooksQueue(int size)
    {
        list = new LinkedList<Thing>();
        this.maxSize = size;
    }

    public void returnBook(Thing bookID)
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

    public Thing processReturnedBooks()
    {
        if(list.isEmpty())
        {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    public Thing peekAtFrontBook()
    {
        if(list.isEmpty())
        {
            throw new EmptyStackException();
        }
        return list.getFirst();
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

    /*  if(isFull())
        {
            System.out.println("You can only borrow one book!");
        } */
