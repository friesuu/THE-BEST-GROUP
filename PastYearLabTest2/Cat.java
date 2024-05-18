package PastYearLabTest2;

public class Cat extends Pet 
{
    private String name;

    public Cat(String name, String breed, double weight, String sickness) 
    {
        super(breed, weight, sickness);
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
