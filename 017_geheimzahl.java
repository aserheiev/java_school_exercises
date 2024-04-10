package pkg017_geheimzahl;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String name;
        boolean weiterSpielen = true;
        boolean vielleicht = true;
        Random generator = new Random();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Willkommen bei Geheimzahlspiel!!!");
        
        System.out.println("Gib mir dein Name: ");
        name = input.nextLine();
        
        System.out.println("Ok " + name + ", ich habe eine Zahl zwischen 1 bis 100 ausgewaehlt.");
        System.out.println("Versuch es zu raten und gewinne [gar nix]");
        
        // Spiel spielen (eigene Funktion)
        TheGame(generator, input);
        
        // Der User wird gefragt, ob er nochmal spielen will.
        // Beim "vielleicht" gibt es eine 50/50 Chance, weiter zu spielen
        
        while (weiterSpielen) {
            String antwort;
            System.out.println("Nochmal spielen?");
            antwort = input.nextLine();

            if (antwort.equalsIgnoreCase("ja")) {
                TheGame(generator, input);
            } else if (antwort.equalsIgnoreCase("nein")) {
                weiterSpielen = false;
            } else if (antwort.equalsIgnoreCase("vielleicht") || antwort.equalsIgnoreCase("jein")) {
                vielleicht = generator.nextBoolean();
                if (vielleicht) {
                    TheGame(generator, input);
                } else {
                    System.out.println("Dann vielleicht nicht");
                    break;
                }
            } else {
                System.out.println("Nix verstanden");
            }
        }
        
        System.out.println("Danke FRED");
        System.out.println("FRED: nichts zu danken :)");
        
    }
    
    public static void TheGame(Random generator, Scanner input) 
    {
        // Das Spiel selbst. Ich will Random und Scanner nicht zweimal haben,
        // deswegen passe ich die Referenzen drin
        
        int geheimZahl = generator.nextInt(1, 101);
        int versuch = 0;
        int benutzerZahl;
        
        System.out.println("Hier ist dein erster Versuch: ");
        
        benutzerZahl = GetValue();
        
        while (benutzerZahl != geheimZahl) 
        {
            if (benutzerZahl < 1 || benutzerZahl > 100) {
                System.out.println("Ich hab gesagt von 1 bis 100. Versuch nochmal.");
                versuch++;
                benutzerZahl = GetValue();
            } else if (benutzerZahl > geheimZahl) {
                System.out.println("Leider falsch. Die Geheimzahl ist kleiner. Versuch nochmal.");
                versuch++;
                benutzerZahl = GetValue();
            } else if (benutzerZahl < geheimZahl) {
                System.out.println("Leider falsch. Die Geheimzahl ist groesser. Versuch nochmal.");
                versuch++;
                benutzerZahl = GetValue();
            }
        }
        
        versuch++;
        System.out.println("Winner winner chicken dinner.");
        System.out.println("Versuche bis jetzt: " + versuch);
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
