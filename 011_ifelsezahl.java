package pkg011_ifelsezahl;
import java.util.Scanner;


public class Main {


    public static void main(String[] args)
    {
        double a;
               
        Scanner input = new Scanner(System.in);
        
        System.out.print("Give me your number: ");
        
        while (true)
        {
        try 
        {
            a = Double.parseDouble(input.nextLine());
            break;
        } catch (Exception e) 
        {
            // Zahl ist keine Zahl
            System.out.println("Das ist keine richtige Zahl, versuch nochmal");
        }
        }
        
        if (a == 0) {
            System.out.println("Zahl ist ZERO");
        } else if (a > 0 && a <=1) {
            System.out.println("Positive kleine Zahl");
        } else if (a > 1000000) {
            System.out.println("Positive groesse Zahl");
        } else if (a > 0 && a >= 1) {
            System.out.println("Positive Zahl");
        } else if (a < 0 && a >= -1) {
            System.out.println("Negative kleine Zahl");
        } else if  (a < -1000000) {
            System.out.println("Negative groesse Zahl");
        } else {
            System.out.println("Negative Zahl");
        }
    }
}
