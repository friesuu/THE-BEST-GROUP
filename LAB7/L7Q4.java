package LAB7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class L7Q4 
{
    public static void main(String[] args) 
    {
        String filePath = ".\\LAB7\\sample.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            int characterCount = 0;
            int wordCount = 0;
            int lineCount = 0;

            String line;
            while ((line = reader.readLine()) != null) 
            {
                // Count characters (inlcuding whitespaces)
                characterCount += line.length();

                // Puts the word into a string array everytime it encounters a whitespace
                String[] words = line.split("\\s+");
                wordCount += words.length;

                // Count lines
                lineCount++;
            }

            System.out.println("Number of characters: " + characterCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of lines: " + lineCount);

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
