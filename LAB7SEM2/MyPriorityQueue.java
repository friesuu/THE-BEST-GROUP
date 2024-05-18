package LAB7SEM2;

import java.util.PriorityQueue;

public class MyPriorityQueue 
{
    public static void main(String[] args) 
    {
        Integer[] array = {4, 8, 1, 2, 9, 6, 3, 7};
        PriorityQueue<Integer> prioQ = new PriorityQueue<Integer>(); 

        for(int i = 0; i < array.length; i++)
        {
            prioQ.add(array[i]);
        }

        System.out.println(prioQ);

        System.out.println(prioQ.poll());

        prioQ.add(5);

        System.out.println(prioQ);

        /* Object[] elements = prioQ.toArray();
        for(int i = 0 ; i < elements.length; i++)
        {
            System.out.println(elements[i]);
        } */

        System.out.println(prioQ.peek());

        System.out.println(prioQ.contains(1)); 

        System.out.println(prioQ.size());

        while(!prioQ.isEmpty())
        {
            prioQ.poll();
            System.out.println(prioQ);
        }

        PriorityQueue<Integer> reversedPriorityQueue = new PriorityQueue<>(prioQ.size(), (a, b) -> Integer.compare(b, a)); // Reversed comparator

        // Add elements from the original array to the reversed priority queue
        for (Integer num : array) {
            reversedPriorityQueue.add(num);
        }

        System.out.println("Reversed priority queue (sorted in reverse order): " + reversedPriorityQueue);
    }    
}
