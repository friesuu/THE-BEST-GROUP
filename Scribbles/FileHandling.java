package Scribbles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling 
{
   public static void main(String[] args) 
   {
        /*try
        {
            File file = new File(".\\testing.txt");
            if(file.createNewFile())
            {
                System.out.println("File created");
            }
            else
            {
                System.out.println("File already exists");
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }*/

        /*try
        {
            PrintWriter writer = new PrintWriter(new FileWriter("testing.txt", true));
            writer.println("this is a testing sentence");
            System.out.println("Succesfully wrote to file");
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }*/

        try(Scanner keyboard = new Scanner(new FileInputStream(".\\Scribbles\\testing.txt")))
        {
            //Scanner keyboard = new Scanner(new FileInputStream("testing.txt"));
            //String input = keyboard.nextLine();
            String input2 = keyboard.nextLine();
            //String input3 = keyboard.nextLine();
            String input4 = keyboard.nextLine();
            String[] parts = input2.split(" ");

            for(int i = 0; i < parts.length; i++)
            {
                System.out.println(parts[i]);
            }
            System.out.println(input4);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(".\\Scribbles\\testing.txt"))) {
            String line;

            // Read each line from the file until the end of the file is reached
            while ((line = br.readLine()) != null) {
                // Process each line as needed
                System.out.println(line);

                // You can perform additional operations with the 'line' variable here
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the IOException (file not found, etc.) as needed
        }
   } 
}
