package PastYearLabTest1;

public class Item<Thing, Thing2> 
{
    private Thing item;
    private Thing2 price;

    public Item(Thing item, Thing2 price)
    {
        this.item = item;
        this.price =  price;
    }

    public Thing getItem()
    {
        return item;
    }

    public Thing2 getPrice()
    {
        return price;
    }
}
