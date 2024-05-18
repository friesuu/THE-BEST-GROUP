package LAB1;

public class L1Q3 
{
    public static void main(String[] args) 
    {
        Account account = new Account(1122, 20000, 4.5);

        account.withdraw(2500);
        account.deposit(3000);

        System.out.println(account.getBalance());
        System.out.println(account.getMonthlyInterest());
        System.out.println(account.getDateCreated());
    }    
}
