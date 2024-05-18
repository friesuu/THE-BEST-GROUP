package TUTORIAL2;

public class T2Q6 
{
    public static void main(String[] args) 
    {
        Duo<String, Integer> sideShape = new Duo<String, Integer>("Circle", 0);
        Duo<Double, Double> points = new Duo<>(10.0, 0.5);

        System.out.println("The shape is a " + sideShape.getFirst() + " with sides " + sideShape.getSecond());
        System.out.println("The sum is: " + (points.getFirst() + points.getSecond()));
    }
}
