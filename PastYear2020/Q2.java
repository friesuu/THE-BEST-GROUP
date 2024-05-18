package PastYear2020;

import java.util.Scanner;

public class Q2 
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        double[] decimalDegree = new double[4];
        char[] direction = new char[2];
        double[] degree = new double[2];
        double[] minute = new double[2];
        double[] second = new double[2];
        String[] type = new String[4];
        
        System.out.println("Enter location " + (1));
        for(int i = 0; i < 2; i++)
        {
            System.out.print("Enter direction(N, S, E, W): ");
            direction[i] = keyboard.next().charAt(0);

            System.out.print("Enter Degree, Minute and Second: ");
            degree[i] = keyboard.nextInt();
            minute[i] = keyboard.nextInt();
            second[i] = keyboard.nextInt();
            
            switch(direction[i])
            {
                case 'N':
                {
                    decimalDegree[i] = (degree[i] + ((minute[i] * 60) + second[i])/3600);
                    type[i] = "Latitude";
                    break;
                }
                case 'S': 
                {
                    decimalDegree[i] = ((degree[i] * -1) + ((minute[i] * 60) + second[i])/3600);
                    type[i] = "Latitude";
                    break;
                }
                case 'E':
                {
                    decimalDegree[i] = (degree[i] + ((minute[i] * 60) + second[i])/3600);
                    type[i] = "Longitude";
                    break;
                }
                case 'W':
                {
                    decimalDegree[i] = ((degree[i] * -1) + ((minute[i] * 60) + second[i])/3600);
                    type[i] = "Longitude";
                    break;
                }
                default:
                {
                    System.out.println("Invalid direction!");
                    break;
                }
            }
        }

        System.out.println("Enter location 2: ");
        for(int i = 0; i < 2; i++)
        {
            System.out.print("Enter direction(N, S, E, W): ");
            direction[i] = keyboard.next().charAt(0);

            System.out.print("Enter Degree, Minute and Second: ");
            degree[i] = keyboard.nextInt();
            minute[i] = keyboard.nextInt();
            second[i] = keyboard.nextInt();
            
            switch(direction[i])
            {
                case 'N':
                {
                    decimalDegree[i+2] = (degree[i] + ((minute[i] * 60) + second[i])/3600);
                    type[i+2] = "Latitude";
                    break;
                }
                case 'S': 
                {
                    decimalDegree[i+2] = (-degree[i] + ((minute[i] * 60) + second[i])/3600);
                    type[i+2] = "Latitude";
                    break;
                }
                case 'E':
                {
                    decimalDegree[i+2] = (degree[i] + ((minute[i] * 60) + second[i])/3600);
                    type[i+2] = "Longitude";
                    break;
                }
                case 'W':
                {
                    decimalDegree[i+2] = (-degree[i] + ((minute[i] * 60) + second[i])/3600);
                    type[i+2] = "Longitude";
                    break;
                }
                default:
                {
                    System.out.println("Invalid direction!");
                    break;
                }
            }
        }

        System.out.println("Location 1: " + decimalDegree[0] + " " + type[0] + ", " + decimalDegree[1] + " " + type[1]);
        System.out.println("Location 1: " + decimalDegree[2] + " " + type[2] + ", " + decimalDegree[3] + " " + type[3]);
    }    
}
