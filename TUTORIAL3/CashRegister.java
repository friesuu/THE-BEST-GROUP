package TUTORIAL3;

public class CashRegister 
{
    private double total;
    private int salesCount;

    public CashRegister()
    {
        this.total = 0;
        this.salesCount = 0;
    }

    public void makePayment(double amount)
    {
        this.total += amount;
    }

    public void recordSale()
    {
        salesCount++;
    }

    public double giveChange(double itemPrice)
    {
        this.total -= itemPrice;
        return total;
    }

    public double getTotalCash()
    {
        return total;
    }

    public int getSalesCount()
   {
        return salesCount;
   }
}
