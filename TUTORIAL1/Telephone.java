package TUTORIAL1;

public class Telephone 
{
    private int areaCode;
    private String number;
    private static int numberOfTelephoneObject = 0;

    public Telephone(int areaCode, String number)
    {
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject++;
    }

    public void setAreaCode(int areaCode)
    {
        this.areaCode = areaCode;
    }

    public double getAreaCode()
    {
        return areaCode;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return number;
    }

    public String makeFullNumber()
    {
        return areaCode + " - " + number;
    }

    public int getNumberOfTelephoneObjects()
    {
        return numberOfTelephoneObject;
    }
}
