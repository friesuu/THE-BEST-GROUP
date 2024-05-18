package LAB1;

import java.util.ArrayList;

public class Account1<E> extends Account 
{
    private static String name;
    private ArrayList<Transactions> transactions;

    public Account1(String name, int id, double balance)
    {
        this.name = name;
        super.id = id;
        super.balance = balance;
    }
}
