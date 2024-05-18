package TUTORIAL3;

public class Dispenser 
{
    private String itemName;
    private int itemStock;
    private double itemPrice;

    public Dispenser(String itemName, int itemStock, double itemPrice)
    {
        this.itemName = itemName;
        this.itemStock = itemStock;
        this.itemPrice = itemPrice;
    }

    public boolean dispenseItem()
    {
        if(itemStock > 0)
        {
            itemStock--;
            return true;
        }
        else
        {
            return false;
        }
    }

    public void refillStock(int amount)
    {
        this.itemStock += amount;
    }

    public int getStock()
    {
        return itemStock;
    }

    public double getPrice()
    {
        return itemPrice;
    }

    public String getItemName() 
    {
        return itemName;
    }

    public double getItemPrice() 
    {
        return itemPrice;
    }
}
