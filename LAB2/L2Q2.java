package LAB2;

public class L2Q2 
{
    public static void main(String[] args) 
    {
        CompareMax compareMax = new CompareMax();
        System.out.println("Maximum of 3, 5, 2 is: " + compareMax.maximum(3, 5, 2)); // Integer
        System.out.println("Maximum of 2.5, 1.2, 3.6 is: " + compareMax.maximum(2.5, 1.2, 3.6)); // Double
        System.out.println("Maximum of 'apple', 'banana', 'orange' is: " + compareMax.maximum("apple", "banana", "orange")); // String
    }
}
