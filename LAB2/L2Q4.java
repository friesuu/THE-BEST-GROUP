package LAB2;

public class L2Q4
{
    public static void main(String[] args) 
    {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};

        minmax(intArray);
        minmax(strArray);
    }

    public static <Thing extends Comparable<Thing>> void minmax(Thing[] t)
    {
        Thing min = t[0];
        Thing max = t[0];

        for(int i = 0; i < t.length; i++)
        {
            if(t[i].compareTo(min) < 0)
            {
                min = t[i];
            }
            if(t[i].compareTo(max) > 0)
            {
                max = t[i];
            }
        }

        System.out.println("Min = " + min + ", Max = " + max);
    }
}
