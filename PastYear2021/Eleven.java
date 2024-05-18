package PastYear2021;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

abstract class Eleven 
{
    private int[] numbers;
    private String filename;

    public Eleven(String fileName)
    {
        this.filename = fileName;

        try(Scanner scanner = new Scanner(new FileReader(filename)))
        {
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] parts = line.split("");
                numbers = new int[parts.length];
                for(int j = 0; j < parts.length; j++)
                {
                    numbers[j] = Integer.parseInt(parts[j]);
                    System.out.println(numbers[j]);
                }
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
        
    public abstract void divide(int guess);
    public abstract void multiply(int guess);
}
