package PastYearLabTest2;

public class Pet implements Comparable<Pet>
{
    private String breed, sickness;
    private double weight;
    
    public Pet(String breed, double weight, String sickness)
    {
        this.breed = breed;
        this.weight = weight;
        this.sickness = sickness;
    }

    public String getBreed()
    {
        return breed;
    }

    public double getWeight()
    {
        return weight;
    }

    public String getSickness()
    {
        return sickness;
    }

    @Override
    public int compareTo(Pet o) 
    {
        return Double.compare(this.weight, o.getWeight());
    }
}
