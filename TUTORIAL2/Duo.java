package TUTORIAL2;

public class Duo<A, B>  
{
    private A a;
    private B b;

    public Duo(A a, B b)
    {
        this.a = a;
        this.b = b;
    }

    public void setFirst(A first) 
    {
        this.a = first;
    }
    
    public A getFirst() 
    {
        return a;
    }

    public void setSecond(B second) 
    {
        this.b = second;
    }
    
    public B getSecond() 
    {
        return b;
    }
}
