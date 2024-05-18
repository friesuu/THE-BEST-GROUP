package TUTORIAL3;

public class CandyMachine 
{
    private Dispenser[] dispensers;
    private CashRegister cashRegister;

    public CandyMachine() 
    {
        dispensers = new Dispenser[]{
            new Dispenser("Candies", 10, 1.50),
            new Dispenser("Chips", 8, 2.00),
            new Dispenser("Gum", 15, 1.00),
            new Dispenser("Cookies", 12, 2.50)
        };
        cashRegister = new CashRegister();
    }

    public void showProducts() 
    {
        System.out.println("Available Products:");
        for (int i = 0; i < dispensers.length; i++) 
        {
            System.out.println((i + 1) + ". " + dispensers[i].getItemName() + " - $" + dispensers[i].getItemPrice());
        }
    }

    public void selectProduct(int productIndex) 
    {
        if (productIndex >= 1 && productIndex <= dispensers.length) 
        {
            int index = productIndex - 1;
            System.out.println("You selected: " + dispensers[index].getItemName());
            System.out.println("Price: $" + dispensers[index].getItemPrice());
            double price = dispensers[index].getItemPrice();
            System.out.println("Please enter $" + price + " to purchase.");
        } 
        else 
        {
            System.out.println("Invalid product selection.");
        }
    }

    public void acceptPayment(double amount, int productIndex) 
    {
        if (productIndex >= 1 && productIndex <= dispensers.length) 
        {
            int index = productIndex - 1;
            double price = dispensers[index].getItemPrice();
            if (amount >= price) 
            {
                cashRegister.makePayment(amount);
                cashRegister.recordSale();
                double change = amount - price;
                System.out.println("Thank you for your purchase! Your change is: $" + change);
                dispensers[index].dispenseItem();
            } 
            else 
            {
                System.out.println("Insufficient payment. Please enter $" + price + " to purchase.");
            }
        } 
        else 
        {
            System.out.println("Invalid product selection.");
        }
    }

    public double getSales() 
    {
        return cashRegister.getTotalCash();
    }
}

