package TUTORIAL1;

public abstract class Vehicle 
{
    private double maxSpeed;
    protected double currentSpeed;

    public Vehicle(double maxspeed)
    {
        this.maxSpeed = maxspeed;
        this.currentSpeed = 0.0;
    }

    public abstract void accelerate();
    //{
    //    System.out.println("ACCELERATING!!!!");
    //}

    public double getCurrentSpeed()
    {
        return currentSpeed;
    }

    public double getMaxSpeed()
    {
        return maxSpeed;
    }

    public void pedalToTheMedal()
    {
        while(currentSpeed < maxSpeed)
        {
            accelerate();
            currentSpeed++;
        }
    }
}
