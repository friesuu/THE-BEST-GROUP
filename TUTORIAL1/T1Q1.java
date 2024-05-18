package TUTORIAL1;

import java.util.Scanner;

public class T1Q1
{
    public static void main(String[] args) 
    {
        Telephone[] telephone = new Telephone[5];

        for(int i = 0; i < 5; i++)
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter your area code: ");
            int areaCode = keyboard.nextInt();
            System.out.print("Enter your phone number: ");
            String number = keyboard.next();
            telephone[i] = new Telephone(areaCode, number);
            
        }

        for(int i = 0; i < 5; i++)
        {
            System.out.println(telephone[i].makeFullNumber());
        }
    }
}