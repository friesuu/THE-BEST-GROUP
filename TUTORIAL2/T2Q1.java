package TUTORIAL2;

public class T2Q1
{
    public static void main(String[] args) 
    {
        Container<String> container1 = new Container<String>();
        Container<Integer> container2 = new Container<Integer>();

        container1.add("SHIBAL SEKIYA");
        container2.add(12369);

        System.out.println(container1.retrieve());
        System.out.println(container2.retrieve());
    }
}