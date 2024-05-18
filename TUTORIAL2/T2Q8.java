package TUTORIAL2;

import java.util.ArrayList;

public class T2Q8 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> numOfCars = new ArrayList<Integer>();
        numOfCars.add(10);
        numOfCars.add(20);
        ArrayList<Double> milesPerHour = new ArrayList<Double>();
        milesPerHour.add(55.5);
        milesPerHour.add(60.0);

        displayList(numOfCars);
        displayList(milesPerHour);
    }

    public static void displayList(ArrayList<?> list) 
    {
        for(int i = 0; i < list.size(); i++) 
        {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}