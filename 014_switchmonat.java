package pkg014_switchmonat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.print("Gib mir die Monatnummer: ");
        int monat = GetValue();
        
        switch (monat) {
            case 1: 
                System.out.println("Januar");
                break;
            case 2:
                System.out.println("Februar");
                break;
            case 3:
                System.out.println("Maerz");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("Mai");
                break;
            case 6:
                System.out.println("Juni");
                break;
            case 7:
                System.out.println("Juli");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("Oktober");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("Dezember");
                break;
            case 17:
                System.out.println("Sinamber");
                break;
            default:
                System.out.println("Nullvember");
                break;
        }
    }
    
    public static int GetValue() 
    {
        int zahl;
        Scanner input = new Scanner(System.in);
        // diese Funktion prüft, ob die Eingabe ein int ist und gibt sie zurück
        // Am sonsten muss der User nochmal versuchen
        while (true)
        {
        try 
        {
            zahl = Integer.parseInt(input.nextLine());
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
