package LAB10;

public class ContractStaff extends Employee
{
    double totalSales;
    public ContractStaff(double totalSale)
    {
        this.totalSales = totalSale;
    }

    @Override
    public double displaySalary() 
    {
        double monthlyIncome = 500;
        double commision = (totalSales * 0.5);
        return monthlyIncome + commision;
    }
}
