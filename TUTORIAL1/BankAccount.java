package TUTORIAL1;

public class BankAccount implements Account 
{
    private int balance;

    public BankAccount(int cash)
    {
        this.balance = cash;
    }

    @Override
    public int deposit(int cash) 
    {
        this.balance = balance + cash;
        return balance;
    }

    @Override
    public boolean withdraw(int cash) 
    {
        if(cash <= this.balance)
        {
            this.balance = (balance - cash);
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
