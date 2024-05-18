package LAB7;

import java.util.Scanner;
import java.net.URLConnection;
import java.io.*;
import java.net.URL;
import java.io.FileOutputStream;

public class L7Q2 
{
    public static void main(String[] args) 
    {

        try 
        {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("index.htm"));
            URL u = new URL("https://fsktm.um.edu.my/"); 
            // open the website
            URLConnection cnn = u.openConnection();

            // create connection to the website
            InputStream stream = cnn.getInputStream(); 

            // creating the input stream
            Scanner scanner = new Scanner(stream); 
            while(scanner.hasNextLine())
            {
                outputStream.println(scanner.nextLine());
            }

            outputStream.close();
            scanner.close();
        }
        catch (IOException e) 
        {
            System.out.println("IO Error:" + e.getMessage());
        }
        
    }
}