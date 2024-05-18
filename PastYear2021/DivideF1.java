package PastYear2021;

public class DivideF1 extends Eleven
{
    //private static String filename;
    public DivideF1(String fileName)
    {
        super(fileName);
    }
    
    @Override
    public void divide(int guess)
    {
        String temp = Integer.toString(guess);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < newGuess.length; i++)
        {
            //newGuess[i] = temp.charAt(i) - '0';
            newGuess[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
            System.out.println(newGuess[i]);
        }

        /*for(int i = 0; i < newGuess.length; i++)
        {
            int days = newGuess[i]*newGuess[i];
            System.out.println(days);
        }*/
    }

    public void multiply(int guess)
    {
        String temp = Integer.toString(guess);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < newGuess.length; i++)
        {
            //newGuess[i] = temp.charAt(i) - '0';
            newGuess[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
            System.out.println(newGuess[i] * 10);
        }
    }

    
}
