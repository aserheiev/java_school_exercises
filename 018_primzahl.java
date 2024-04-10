package pkg018_primes;
 
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args)
    {
        System.out.println("Bis wann: ");
        int limit = GetValue();
        // nimmt alle Werte bis (inkl.) die angegebene Wert
        // gibt diese aus nur wenn diese Primär sind
        for (int i = 2; i <= limit; i++) {
            if (IsPrime(i)) {
                System.out.println(i);
            }
        }
    }
    // uberprueft ob eine Wert primär ist (durch teilen jeder Wert von 2 bis sich selbst)
    // könnte verschachteln ohne eine Funktion aber das ist für mich mehr übersichtlich
    public static boolean IsPrime(int zahl) {
        boolean passt = true;
        for (int i = 2; i < zahl; i++) {
            if (zahl % i == 0) 
            {
                passt = false;
            }
        }
        return passt;
    }

    public static int GetValue() 
    {
        int zahl;
        Scanner input = new Scanner(System.in);
        // diese Funktion prüft, ob die Eingabe ein int ist und sagt true oder false
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
            System.out.println("Das ist keine Zahl, versuch nochmal (zaehlt nicht als Versuch)");
        }
        }
        return zahl;
    }
}