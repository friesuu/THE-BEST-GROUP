package LAB1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class L1Q1 
{
    private static String filename = ".\\LAB1\\ThierryHarry_22002655.txt";
    public static void main(String[] args) 
    {
        part1();

        try(Scanner keyboard = new Scanner(new FileInputStream(filename)))
        {
            while(keyboard.hasNextLine())
            {
                String line = keyboard.nextLine();
                System.out.println(line);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        part2();
        
    }   
    
    private static void part1()
    {
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(filename)))
        {
            writer.println("""
                Thursday, 19 March 2021.

                My name is Thierry Harry with matrix number, 22002655. I am
                majoring in Computer Science (Multimedi Computing). This is my first time taking the
                Data Structure subject. At the moment, I am feeling excited about taking this
                subject. This is because although I didn't get that good of a grade in FOP, it's 
                always fun to try something new and more challenging.

                I acquired B- for my previous Programming 1 course. It’s not too bad. So, I
                think I can manage to get A for this DS subject this term. In order
                to do well in the subject, I will study way earlier compared to last time. Wish me luck!!! 
                """);

            System.out.println("Successfully wrote to file!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void part2()
    {
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(filename, true)))
        {
            writer.println("""
                Thursday, 18 June 2021.
                It's me again. Finally, it's the end of the term and the DS class has finished! I think I did
                well in this course. I'm overall satisfied with my performance throughout the whole course. I learnt 
                many things while studying DS like how to code more and better which also subsequently made me type
                faster. I got exactly my target for my grade.  
                """);

            System.out.println("Successfully appended to file!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
