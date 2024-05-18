package TUTORIAL3;

import java.util.Scanner;

public class T3Q1 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        CandyMachine candyMachine = new CandyMachine();

        candyMachine.showProducts();
        System.out.print("Enter the number of the product you want to purchase: ");
        int productIndex = scanner.nextInt();
        candyMachine.selectProduct(productIndex);

        System.out.print("Enter the amount: $");
        double amount = scanner.nextDouble();
        candyMachine.acceptPayment(amount, productIndex);

        System.out.println("Total Sales: $" + candyMachine.getSales());

        scanner.close();
    }    
}
