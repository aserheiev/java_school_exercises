// ein einfaches Programm zur Berechnung des Umfangs und der Fläche eines Rechtecks

package pkg002_rechteck;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int laenge;
        int breite;
        int umfang;
        int flaeche;
        
        System.out.println("Ich bin ein Rechteck.");
        System.out.println("Meine Laenge:");
        // Funktion unten um die Wert zu lesen
        laenge = GetValue();
        System.out.println("Meine Breite:");
        breite = GetValue();
        // Funktionen unten um die Flaeche und den Umfang zu holen
        umfang = GetUmfang(laenge, breite);
        flaeche = GetFlaeche(laenge, breite);
        System.out.println("Umfang: " + umfang + ", Flaeche: " + flaeche);

    }
    
    public static int GetValue() 
    {
        int zahl;
        Scanner input = new Scanner(System.in);
        
        // diese Funktion prüft, ob die Eingabe ein int ist, und ob 
        // sie groesser als null ist und gibt sie zurück
        // Am sonsten muss der User nochmal versuchen
        
        while (true)
        {
        try 
        {
            zahl = Integer.parseInt(input.nextLine());
            if (zahl <= 0) 
            {
                // Zahl ist null oder negativ
                System.out.println("Zahl muss positiv sein!");
                continue;
            }
            break;
        } catch (Exception e) {
            // Zahl ist keine Zahl
            System.out.println("Das ist keine richtige Zahl, versuch nochmal");
        }
        }
        return zahl;
    }
    
    
    private static int GetFlaeche(int laenge, int breite) 
    {
        int flaeche = laenge * breite;
        return flaeche;
    }
    
    private static int GetUmfang(int laenge, int breite) 
    {
        int umfang = 2 * (laenge + breite);
        return umfang;
    }
}