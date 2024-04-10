package pkg013_getauscht;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.print("Zahl 1: ");
        int zahl1 = GetValue();
        System.out.print("Zahl 2: ");
        int zahl2 = GetValue();
        
        // int zahl2temp = zahl2;
        
        System.out.println("Vor dem Tausch: Zahl 1 = " + zahl1 + ", Zahl 2 = " + zahl2);
        
        zahl1 += zahl2;
        zahl2 = zahl1 - zahl2;
        zahl1 -= zahl2;
        
        System.out.println("Nach dem Tausch: Zahl 1 = " + zahl1 + ", Zahl 2 = " + zahl2); 
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
