package PastYearLabTest1;

import java.util.ArrayList;
import java.util.List;

public class FoodStore extends ShopLot 
{
    private List<Item<String, Double>> menu;

    public FoodStore(String shopName, Person contactPerson) 
    {
        super(shopName, contactPerson);
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(String item, Double price)
    {
        menu.add(new Item<>(item, price));
    }

    public List<Item<String, Double>> getMenu()
    {
        return menu;
    }
}
