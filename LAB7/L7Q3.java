package LAB7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class L7Q3 {

    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        String inputFileName = ".\\LAB7\\original.txt";
        String outputFileName = ".\\LAB7\\reverse.txt";
        System.out.print("Enter a sentence: ");
        String sentence = keyboard.nextLine();


        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFileName))) 
        {
            writer.println(sentence);
            System.out.println("Data has been written to " + inputFileName);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) 
        {

            // Read each line from the input file, reverse it, and write to the output file
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String reversedLine = new StringBuilder(line).reverse().toString();
                writer.write(reversedLine);
                writer.newLine(); // Add a newline after each reversed line
            }

            System.out.println("Content reversed and saved to " + outputFileName);

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        keyboard.close();
    }
}