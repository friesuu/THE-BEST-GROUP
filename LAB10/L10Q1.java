package LAB10;

import java.util.Scanner;

public class L10Q1 
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter type of employee (pe for permanent employee, cs for contract staff, ts for temporary staff)");
        String employeeType = keyboard.nextLine();

        switch (employeeType) 
        {
            case "pe":
            {
                System.out.print("Enter category (A,B,C): ");
                String category = keyboard.nextLine();   
                PermanentEmployee pe = new PermanentEmployee(category);
                System.out.println(pe.displaySalary());
                break;   
            }
            case "cs":
            {
                System.out.print("Enter total sales for Contract Staff: ");
                double totalSales = keyboard.nextDouble();
                ContractStaff cs = new ContractStaff(totalSales);
                System.out.println(cs.displaySalary());
                break;
            }
            case "te":
            {
                System.out.print("Enter work hours: ");
                double workHours = keyboard.nextDouble();
                TemporaryStaff ts = new TemporaryStaff(workHours);
                System.out.println(ts.displaySalary());
                break;
            }
            default:
            {
                System.out.println("Invalid employee type");
                break;
            }
        }

        keyboard.close();
    }
}
