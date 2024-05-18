package LAB7;

import java.io.*;
import java.util.Scanner;

public class L7Q1 
{
    private static final String fileName = ".\\LAB7\\coursename.dat";

    // Write course data to file
    private static void writeToFile(String[] courseCodes, String[] courseNames) 
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) 
        {
            for (int i = 0; i < courseCodes.length; i++) 
            {
                writer.println(courseCodes[i] + ", " + courseNames[i]);
            }
            System.out.println("Data has been written to " + fileName);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    // Read course data from file
    private static String readFromFile(String courseCode) 
    {
        try (Scanner scanner = new Scanner(new File(fileName))) 
        {
            while (scanner.hasNextLine()) 
            {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(courseCode)) 
                {
                    return parts[1];
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) 
    {
        // Initial course data
        String[] courseCodes = {"WXES1116", "WXES1115", "WXES1110", "WXES1112"};
        String[] courseNames = {"Programming I", "Data Structure", "Operating System", "Computing Mathematics I"};

        // Write data to file
        writeToFile(courseCodes, courseNames);

        // Read data from file
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a course code: ");
        String courseCode = scanner.nextLine().trim().toUpperCase();

        // Display the corresponding course name
        String courseName = readFromFile(courseCode);
        if (courseName != null) 
        {
            System.out.println("Course Name: " + courseName);
        } 
        else 
        {
            System.out.println("Course not found for code: " + courseCode);
        }

        scanner.close();
    }
}