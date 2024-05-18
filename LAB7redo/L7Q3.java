package LAB7redo;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class L7Q3
{
    public static void main(String[] args) 
    {
        String oriFilename = ".\\LAB7redo\\original.txt";
        String reverseFilename = ".\\LAB7redo\\reverse.txt";

        writeToFile(oriFilename);
        readText(oriFilename, reverseFilename);
    }   
    
    private static void writeToFile(String filename)
    {
        Scanner keyboard = new Scanner(System.in);
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(filename)))
        {
            System.out.print("Enter your sentence: ");
            String inputSentence = keyboard.nextLine();
            writer.println(inputSentence);
            System.out.println("Successfully wrote to file");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        keyboard.close();
    }

    private static void readText(String inputFilename, String outputFilename)
    {
        try(Scanner reader = new Scanner(new FileInputStream(inputFilename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename)))
        {
            while (reader.hasNextLine()) 
            {
                String line = reader.nextLine();
                writer.write(reverseString(line));
            }
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    private static String reverseString(String str) 
    {
        char[] parts = new char[str.length()];
        System.out.println(str.length());
        for(int i = 1; i < str.length(); i++)
        {
            parts[i - 1] = str.charAt((str.length() - i));
        }

        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }
}
