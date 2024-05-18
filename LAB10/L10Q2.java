package LAB10;

import java.util.Scanner;

public class L10Q2 
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter text to cipher: ");
        String inputStr = keyboard.nextLine();
        System.out.print("Enter shift: ");
        int shiftKey = keyboard.nextInt();

        SubstitutionCypher sc = new SubstitutionCypher();

        System.out.println("The encrypted text is: " + sc.encode(inputStr, shiftKey));
        System.out.println("The decrypted text is: " + sc.decode(sc.encode(inputStr, shiftKey), shiftKey));

        keyboard.close();
    }
}
