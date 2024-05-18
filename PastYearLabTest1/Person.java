package PastYearLabTest1;

public class Person 
{
    private String name, contactNumber;

    public Person(String name, String contactNumber)
    {
        this.name = name;
        this.contactNumber = contactNumber;
    }
    
    public Person(String name)
    {
        this(name, "null");
    }

    public String getName()
    {
        return name;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }
}
