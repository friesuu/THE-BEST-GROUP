package LAB1;

import java.util.Date;

public class Account 
{
    public int id = 0;
    public double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;
    
    public Account()
    {
        this(0,0.0, 0);
    }

    public Account(int id, double balance, double annualInterestRate)
    {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public int getID()
    {
        return id;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setAnnualInterestRate(double annualInterestRate)
    {
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public double getMonthlyInterestRate()
    {
        double monthlyInterestRate = ((annualInterestRate/100)/12);
        return monthlyInterestRate;
    }

    public double getMonthlyInterest()
    {
        double monthlyInterest = (balance*(getMonthlyInterestRate()/100));
        return monthlyInterest;
    }

    public void withdraw(double amount)
    {   
        if(amount < balance)
        {
            this.balance = balance - amount;
        }
        else
        {
            System.out.println("Your balance is not sufficient");
        }
    }

    public void deposit(double amount)
    {
        this.balance = balance + amount;
        System.out.println("Your new balance is: " + balance);
    }
}
