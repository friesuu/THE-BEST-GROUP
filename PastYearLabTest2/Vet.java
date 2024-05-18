package PastYearLabTest2;

import java.util.ArrayList;

public class Vet 
{
    private String name, qualification;

    public void giveTreatment(ArrayList<Prescription<?>> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i).getPet());
        }
    }
}
