package TUTORIAL2;

public class Container<Thing> 
{
    private Thing t;

    public void add(Thing item)
    {
        this.t = item;
    }

    public Thing retrieve()
    {
        return t;
    }
}
