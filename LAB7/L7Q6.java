package LAB7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L7Q6
{
    public static void main(String[] args) 
    {
        try 
        {
            Scanner input1 = new Scanner(new FileInputStream(".\\LAB7\\order.txt"));
            String[] order, product;
            String temp, productName = "";
            int quantity = 0;
            double price = 0;

            while (input1.hasNextLine()) 
            {
                temp = input1.nextLine();
                order = temp.split(",");
                quantity = Integer.parseInt(order[2]);
                Scanner input2 = new Scanner(new FileInputStream(".\\LAB7\\product.txt"));

                while (input2.hasNextLine()) 
                {
                    temp = input2.nextLine();
                    product = temp.split(",");
                    if (order[1].equals(product[0])) 
                    {
                        productName = product[1];
                        price = Double.parseDouble(product[2]);
                        break;
                    }
                }
                
                input2.close();

                System.out.printf("%-10s%-21s", order[1], productName);
                System.out.printf("%-10d%-14.2f%-7.2f\n", quantity, price, quantity * price);
            }

            input1.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File was not found");
        }
    }
}