package TUTORIAL2;

public class MyArray 
{
    public static void main(String[] args) 
    {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Jane", "Tom", "Bob"};
        Character[] charArray = {'a', 'b', 'c'};

        listAll(intArray);
        listAll(stringArray);
        listAll(charArray);
    }

    public static <Thing> void listAll(Thing[

    
    ] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
