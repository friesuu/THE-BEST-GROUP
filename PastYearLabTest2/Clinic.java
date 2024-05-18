package PastYearLabTest2;

import java.util.ArrayList;

public class Clinic 
{
    Cat ethan = new Cat("Ethan", "Cat", 69, "Diabetes");

    ArrayList<Prescription<?>> prescriptions = new ArrayList<>();
    prescriptions.add(new Prescription<>(ethan, "Thyroxine", 50));
}
