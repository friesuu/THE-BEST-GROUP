package PastYearLabTest2;

public class Prescription<Thing extends Pet> 
{
    private Thing pet;
    private String medication, dosage;

    public Prescription(Thing pet, String medication, String dosage)
    {   
        this.pet = pet;
        this.medication = medication;
        this.dosage = dosage;
    }

    public Thing getPet()
    {
        return pet;
    }

    public String getMedication()
    {
        return medication;
    }

    public String getDosage()
    {
        return dosage;
    }
}
