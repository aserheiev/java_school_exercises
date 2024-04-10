package pkg19_primes_while_only;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Bis wann: ");
        int limit = GetValue();
        int counter = 2;
        int counter2 = 2;
        boolean passt = true;
        // die gleiche Logik als bevor, nur verschachtelt und ohne Funktion
        while (counter <= limit) 
        {
            // erst durch alle kleinen Werte teilen
            while (counter2 < counter)
            {
            if (counter % counter2 == 0) {
                passt = false;
                break;
            } else {
                counter2++;
            }
            }
            
            // wenn oben nicht teilbar war, ausgeben
            if (passt == true) 
            {
                System.out.println(counter);
                counter++;
            } else {
                counter++;
            }
            passt = true;
            counter2 = 2;
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
            System.out.println("Das ist keine Zahl, versuch nochmal (zaehlt nicht als Versuch)");
        }
        }
        return zahl;
    }
}

