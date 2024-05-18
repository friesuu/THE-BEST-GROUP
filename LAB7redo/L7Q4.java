package LAB7redo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class L7Q4 
{
    private static String filename = ".\\LAB7redo\\numCharacter.txt";
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your sentence: ");
        String text = scanner.nextLine();

        writeToFile(text);
        readFromFile();
        
        scanner.close();
    }

    private static void writeToFile(String sentence)
    {
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(filename)))
        {
            writer.println(sentence);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void readFromFile()
    {
        try(Scanner keyboard = new Scanner(new FileInputStream(filename)))
        {
            int count = 0;
            while(keyboard.hasNextLine())
            {
                String line = keyboard.nextLine();
                String[] parts = line.split("");
                for(int i = 0; i < parts.length; i++)
                {
                    count++;
                }
            }
            System.out.print("Total number of characters: " + count);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
