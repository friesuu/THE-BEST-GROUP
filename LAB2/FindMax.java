package LAB2;

public class FindMax 
{
    public static void main(String[] args) 
    {
        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"red", "green", "blue"};
        Circle[] circleArray = {new Circle(3), new Circle(2.9), new Circle(5.9)};

        System.out.println("The max value is: " + max(intArray));
        System.out.println("The max value is: " + max(strArray));

        Circle maxCircle = max(circleArray);
        System.out.println("The max value is: " + maxCircle.getRadius());
    }

    public static <E extends Comparable<E>> E max(E[] list)
    {
        E max = list[0];

        for(int i = 0; i < list.length; i++)
        {
            if(list[i].compareTo(max) > 0)
            {
                max = list[i];
            }
        }
        return max;
    }
}
