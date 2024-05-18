package LAB1;

import java.io.FileInputStream;
import java.util.Scanner;

public class L1Q2 
{
    private static String filename1 = ".\\LAB1\\text1.txt";
    private static String filename2 = ".\\LAB1\\text2.txt";
    private static String filename3 = ".\\LAB1\\text3.txt";
    private static String filename4 = ".\\LAB1\\text4.txt";
    private static int count1 = 0;
    private static int count2 = 0;
    private static int count3 = 0;
    private static int count4 = 0;

    public static void main(String[] args) 
    {
        readText1();
        readText2();
        readText3();
    }

    public static void readText1()
    {
        try(Scanner scanner = new Scanner(new FileInputStream(filename1)))
        {
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                for(int i = 0; i < parts.length; i++)
                {
                    System.out.print(parts[i]);
                    count1++;
                }
                System.out.println("");
            }

            System.out.println("The number of characters int text1 is: " + count1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readText2()
    {
        try(Scanner scanner = new Scanner(new FileInputStream(filename2)))
        {
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");

                for(int i = 0; i < parts.length; i++)
                {
                    System.out.println(parts[i]);
                    count2++;
                }
            }

            System.out.println("The number of characters int text1 is: " + count2);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readText3()
    {
        try(Scanner scanner = new Scanner(new FileInputStream(filename3)))
        {
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] parts = line.split("; ");

                for(int i = 0; i < parts.length; i++)
                {
                    System.out.println(parts[i]);
                    count3++;
                }
            }

            System.out.println("The number of characters int text1 is: " + count3);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
