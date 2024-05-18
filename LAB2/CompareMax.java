package LAB2;

public class CompareMax 
{
    public <T extends Comparable<T>> T maximum(T x, T y, T z) 
    {
        T max = x; // Assume x is initially the maximum

        if(y.compareTo(max) > 0) 
        {
            max = y; // Update max if y is greater
        }

        if(z.compareTo(max) > 0) 
        {
            max = z; // Update max if z is greater
        }

        return max;
    } 
}  
