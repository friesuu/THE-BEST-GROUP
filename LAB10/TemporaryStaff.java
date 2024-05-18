package LAB10;

public class TemporaryStaff 
{
    double workHours;

    public TemporaryStaff(double workHour)
    {
        this.workHours = workHour;
    }

    public double displaySalary()
    {
        double salary = (workHours * 15);
        return salary;
    }
}
