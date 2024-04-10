package pkg015_rechner;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Erste Zahl: ");
        double a = GetValue();
        
        System.out.print("Operator: ");
        String operator = input.nextLine();
        
        System.out.print("Zweite Zahl: ");
        double b = GetValue();

        Random generator = new Random();
        
        switch (operator) {
            case "+":
                System.out.println("Ergebnis: " + (a + b));
                break;
            case "-":
                System.out.println("Ergebnis: " + (a - b));
                break;
            case "*":
                System.out.println("Ergebnis: " + (a * b));
                break;
            case "/":
                System.out.println("Ergebnis: " + (a / b));
                break;
            default:
                // Der User hat Unsinn als Operator angegeben
                // Einfach eine zufällige Zahl zeigen, das passt schon
                System.out.println("Ergebnis: " + generator.nextInt(0, 1112141722));
                break;
        }
        System.out.println("Danke FRED");
    }
    
        // ich habe hier probiert, die Funktion zu overloaden, aber hat nicht funktioniert.
        // ich finde danach heraus, warum nicht
        // jetzt habe ich einfach sie mit double überschrieben
        public static double GetValue() 
    {
        
        double zahl;
        Scanner input = new Scanner(System.in);
        // diese Funktion prüft, ob die Eingabe ein int ist und gibt sie zurück
        // Am sonsten muss der User nochmal versuchen
        while (true)
        {
        try 
        {
            zahl = Double.parseDouble(input.nextLine());
            break;
        } catch (Exception e) 
        {
            // Zahl ist keine Zahl
            System.out.println("Das ist keine richtige Zahl, versuch nochmal");
        }
        }
        return zahl;
    }
     
}