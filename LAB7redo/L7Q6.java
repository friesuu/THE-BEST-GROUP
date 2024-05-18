package LAB7redo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class L7Q6 
{
    private static String productFile = ".\\LAB7redo\\product.txt";
    private static String orderFile = ".\\LAB7redo\\order.txt";
    public static void main(String[] args) 
    {
        readFromFile();
    }

    private static void readFromFile()
    {
        try(Scanner keyboard = new Scanner(new FileInputStream(productFile));
            Scanner scanner = new Scanner(new FileInputStream(orderFile)))
        {
            while(keyboard.hasNextLine())
            {
                String line = keyboard.nextLine();
                String[] parts = line.split(",");

                for(int i = 0; i < parts.length; i++)
                {
                    System.out.println(parts[i]);
                }
            }

            while(scanner.hasNextLine())
            {
                String line2 = scanner.nextLine();
                String[] parts2 = line2.split(",");

                for(int j = 0; j < parts2.length; j++)
                {
                    System.out.println(parts2[j]);
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
