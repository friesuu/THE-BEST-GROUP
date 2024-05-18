package LAB7redo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class L7Q5 
{
    private static String filename = ".\\LAB7redo\\person.dat";
    public static void main(String[] args) 
    {
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filename)))
        {
            int num = reader.readInt();
            System.out.println(num);
            while(true)
            {
                try
                {
                    String name = reader.readUTF();
                    int age = reader.readInt();
                    char gender = reader.readChar();
                    System.out.println(name + " " + gender + " " + age);
                }
                catch(EOFException e)
                {
                    break;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
