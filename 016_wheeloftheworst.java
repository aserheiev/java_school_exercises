package pkg016_wheeloftheworst;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int einsatz;
        int zahl;
        boolean spielAktiv = true;
        int spielCount = 0;

        System.out.println("Wilkommen beim WHEEL OF THE WORST");

        System.out.print("Sag dein Name: ");
        String name = input.nextLine();

        System.out.print("Wie alt bist du: ");
        int alter = GetValue();
        
        if (alter >= 100) {
            System.out.println("Beeindruckend!");
        }
        
        if (alter < 18) {
            System.out.println("DENIED");
        } else {
            System.out.print("Ok, wie viel wettest du: ");
            einsatz = GetValue();

            // solange zahl ist nicht 12 und der User spielt weiter, 
            // bleiben wir in der Schleife
            while (spielAktiv) {
                System.out.println("SPIN THE WHEEL OF THE WORST");
                zahl = SpinTheWheel();
                spielCount++;
                if (zahl == 12) {
                    einsatz = 0;
                    spielAktiv = false;
                } else if (zahl % 2 == 0) {
                    // einsatz ist gleich
                    spielAktiv = WeiterFrage(einsatz, zahl);
                } else {
                    einsatz *= 2;

                    spielAktiv = WeiterFrage(einsatz, zahl);
                }
            }
            System.out.println("/////////////////////////////////////");
            if (einsatz == 0) {
                System.out.println("Deine Zahl war 12. Schade.");
            }
            System.out.println("Okay " + name + ", du hast das Wheel " + spielCount + " Mal gedreht.");
            System.out.println("Dein Gewinn: " + einsatz + ".");
            if (einsatz == 0) {
                System.out.println("THE HOUSE ALWAYS WINS");
            } else if (einsatz > 10000) {
                System.out.println("Nicht schlecht!");
            }
            System.out.println("/////////////////////////////////////");
        }
    }

    public static boolean WeiterFrage(int einsatz, int zahl)
    {
        // Die Funktion fragt den Benutzer, ob er weiter spielen will
        // und gibt eine booleanishe Wert zurück
        String spielAntwort;
        Scanner input = new Scanner(System.in);
        boolean klareAntwort = false;
        boolean weiterSpielen = false;
        System.out.println("/////////////////////////////////////");
        System.out.println("Deine Zahl ist: " + zahl + "!");

        if (zahl % 2 == 0) {
            System.out.println("Einsatz bleibt bei dir gleich.");
        } else {
            System.out.println("Einsatz ist doppelt gemoppelt!");
        }

        System.out.println("Dein Einsatz ist zurzeit : " + einsatz + ".");
        System.out.println("/////////////////////////////////////");
        System.out.println("Weiter spielen?");

        while (!klareAntwort) {
            spielAntwort = input.nextLine();
            if (spielAntwort.equalsIgnoreCase("ja")) {
                System.out.println("Los gehts");
                klareAntwort = true;
                weiterSpielen = true;
            } else if (spielAntwort.equalsIgnoreCase("nein")) {
                System.out.println("Dann sehen wir uns das Ergebnis:");
                klareAntwort = true;
                weiterSpielen = false;
            } else {
                System.out.println("Was bitte?");
            }
        }
        return weiterSpielen;
    }

    public static int SpinTheWheel()
    {
        // Die Funktion wählt und druckt eine neue Nummer 100mal 
        // und gibt dann die letzte Wert zurück
        Random generator = new Random();

        int i = 100;
        int zahl = 0;
        while (i > 0) {
            try {
                i--;
                zahl = generator.nextInt(1, 13);
                System.out.println("Spinning: " + zahl);
                // hier wird ich gekündigt für Thread Schlafen in einer Schleife
                // ULTRA JANK
                Thread.sleep(10l);
            } catch (InterruptedException e) {

            }
        }

        return zahl;
    }

    public static int GetValue()
    {
        int zahl;
        Scanner input = new Scanner(System.in);
        // diese Funktion prüft, ob die Eingabe ein int ist und gibt sie zurück
        // Am sonsten muss der User nochmal versuchen
        while (true) {
            try {
                zahl = Integer.parseInt(input.nextLine());
                if (zahl <= 0) {
                    System.out.println("Bitte positive Zahl angeben.");
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
}
