package LAB2;

public class L2Q1 
{
    public static void main(String[] args) 
    {
        MyGeneric<String> strObject = new MyGeneric<String>("What the frick");
        MyGeneric<Integer> intObject = new MyGeneric<Integer>(69420);

        System.out.println(strObject.get());
        System.out.println(intObject.get());
    }
}
