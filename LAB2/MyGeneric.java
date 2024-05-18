package LAB2;

public class MyGeneric <Thing> 
{
    private Thing e;

    public MyGeneric()
    {

    }

    public MyGeneric(Thing e)
    {
        this.e = e;
    }

    public void set(Thing e)
    {
        this.e = e;
    }

    public Thing get()
    {
        return e;
    }
}
