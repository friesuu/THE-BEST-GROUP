package LAB10;

public class PermanentEmployee extends Employee
{
    String category;
    public PermanentEmployee(String categories)
    {
        this.category = categories;
    }

    @Override
    public double displaySalary() {
        switch(category)
        {
            case "A":
            {
                return 4000;
            }
            case "B":
            {
                return 3000;
            }
            case "C":
            {
                return 2000;
            }
            default:
            {
                return 0;
            }
        }
    }
}
