package BBQ;

import java.util.LinkedList;
import java.util.Queue;

public class BBQMain 
{
    public static void main(String[] args) 
    {
        Queue<String> q = new LinkedList<>();
        GenericQueue<String> q2 = new GenericQueue<>();

        q.add("Ethan");
        q2.enqueue("Ethan");

        System.out.println(q);
        System.out.println(q2.dequeue());
    }    
}
