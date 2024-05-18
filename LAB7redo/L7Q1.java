package LAB7redo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class L7Q1 
{
    private static String filename = ".\\LAB7redo\\coursename.dat";
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String[] courseCodes = {"WXES1116", "WXES116", "WXES1110", "WXES1112"};
        String[] courseNames = {"Programming I", "Data Structure", "Operating System", "Computing Mathematics I"};
        
        writeToFile(courseCodes, courseNames);

        System.out.println("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.println(readFromFile(courseCode));
        scanner.close();
    }

    private static void writeToFile(String[] courseCodes, String[] courseNames)
    {
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(filename)))
        {
            for(int i = 0; i < courseCodes.length; i++)
            {
                writer.println(courseCodes[i] + "," + courseNames[i]);
            }

            System.out.println("Successfully wrote to file!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String readFromFile(String courseCode)
    {
        try(Scanner keyboard = new Scanner(new FileInputStream(filename)))
        { 
            while(keyboard.hasNextLine())
            {
                String line = keyboard.nextLine();
                String[] parts = line.split(",");
                if(parts[0].equals(courseCode))
                {
                    return parts[1];
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
