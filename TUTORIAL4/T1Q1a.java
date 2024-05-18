package TUTORIAL4;



public class T1Q1a 
{
    public static void main(String[] args) 
    {
        Node<Character> node1 = new Node<Character>('a');
        Node<Character> node2 = new Node<Character>('z');

        Node<Character> head = node1;
        Node<Character> tail = node2;

        head.next = tail;

        System.out.println(head.element);
        System.out.println(tail.element);

        Node<Character> node2fromnode1 = node1.next;
        
    }

    
}
