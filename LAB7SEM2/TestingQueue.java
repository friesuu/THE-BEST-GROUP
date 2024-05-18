package LAB7SEM2;

public class TestingQueue 
{
    public static void main(String[] args) 
    {
        String[] fruitsQ = {"Durian", "Blueberry"};

        MyQueue<String> queue = new MyQueue<String>(fruitsQ);

        queue.enqueue("Apple");
        queue.enqueue("Orange");
        queue.enqueue("Grapes");
        queue.enqueue("Cherry");

        System.out.println(queue);

        System.out.println(queue.peek());

        System.out.println(queue.getSize());

        System.out.println(queue.dequeue());

        System.out.println(queue);

        System.out.println(queue.getElement(2));
        
        if(queue.contains("Cherry"))
        {
            System.out.println("This queue contains your element");
        }

        if(queue.contains("Durian"))
        {
            System.out.println("This queue does not contain your element");
        }

        while(!queue.isEmpty())
        {
            System.out.println(queue.dequeue());
        }
    }
}
