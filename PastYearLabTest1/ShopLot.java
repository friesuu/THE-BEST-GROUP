package PastYearLabTest1;

import java.util.ArrayList;
import java.util.List;

public class ShopLot 
{
    private String shopName;
    private Person contactPerson;
    private List<Person> employees;

    public ShopLot(String shopName, Person contactPerson)
    {
        this.shopName = shopName;
        this.contactPerson = contactPerson;
        this.employees = new ArrayList<Person>();
    }

    public String getShopName()
    {
        return shopName;
    }

    public Person getContactPerson()
    {
        return contactPerson;
    }

    public void addEmployee(Person employee)
    {
        employees.add(employee);
    }

    public List<Person> getEmployee()
    {
        return employees;
    }

}
