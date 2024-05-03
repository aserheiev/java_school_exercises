package pkg039_minmax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> zahlen = new ArrayList<>();
        System.out.println("Gib mir 14 Zahlen: ");
        
        for (int i = 0; i < 14; i++) {
            zahlen.add(GetValue());
        }
        
        System.out.print("Die eingegebene Zahlen sind: ");
        System.out.println(zahlen.toString().replace("[", "").replace("]", ""));
        
        System.out.print("Max Wert: ");
        System.out.println(Collections.max(zahlen));
        System.out.println(Collections.);
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