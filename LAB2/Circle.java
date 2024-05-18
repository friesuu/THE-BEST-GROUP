package LAB2;

public class Circle implements Comparable<Circle>
{
    public double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    @Override
    public int compareTo(Circle o) 
    {
        if (this.radius < o.radius)
            return -1;
        else if (this.radius > o.radius)
            return 1;
        else
            return 0;
    }

}
