package TUTORIAL7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T7Q1 
{
    public static void main(String[] args) 
    {
        Queue<Integer> q = new LinkedList<>();
        Scanner keyIn = new Scanner(System.in);
        for (int i = 1; i <= 5; i++)
        {
            if (keyIn.nextBoolean())
                System.out.print(i + " ");
            else
                q.offer(i);
        }
        System.out.println(q);
        System.out.println();



    }    
}
