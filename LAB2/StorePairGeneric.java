package LAB2;

public class StorePairGeneric <Thing>
{
    private Thing first, second;

    public StorePairGeneric(Thing first, Thing second) 
    {
        this.first = first;
        this.second = second;
    }

    public Thing getFirst() 
    {
        return first;
    }

    public Thing getSecond() 
    {
        return second;
    }

    public void setPair(Thing first, Thing second) 
    {
        this.first = first;
        this.second = second;
    }

    public String toString() 
    {
        return "first = " + first + " second = " + second;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StorePairGeneric other = (StorePairGeneric) obj;
        return this.first == other.first;
    }

}
   
