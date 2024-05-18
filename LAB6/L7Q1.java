package LAB6;

import java.util.Scanner;

public class L7Q1 
{
    public static void main(String[] args) 
    {
        MyStack<Character> stack = new MyStack<>();
        
        stack.push('a');
        stack.push('b');
        stack.push('c');

        System.out.println(stack);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item to search(Enter 1 to stop): ");
        char item = scanner.next().charAt(0);
        
        while(item != '1')
        {
            if(stack.search(item))
            {
                System.out.println("Your item is in the stack");
            }
            else
            {
                System.out.println("Your item is not in the stack");
            }

            System.out.print("Enter item to search(Enter 1 to stop): ");
            item = scanner.next().charAt(0);
            
        }
        System.out.println(stack.search('b'));
        System.out.println(stack.search('k'));
    }
}
