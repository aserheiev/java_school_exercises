package pkg012_disco;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);    
        
        System.out.println("Wie heisst du?");
        String name = input.nextLine();
        
        System.out.println("Hallo " + name + ".");
        System.out.println("Wie alt bist du?");
        int age = GetValue();
        
        
        if (age < 18) {
            System.out.println("Auf Wiedersehen");
        } else if (age >= 100) {
            System.out.println("Impressive");
        }
        {
            System.out.println("Das passt. Siehst du gut aus? JA ODER NEIN");
            String antwort = input.nextLine();
            boolean klareAntwortGegeben = false;
            while(!klareAntwortGegeben) {
                if (antwort.equalsIgnoreCase("ja")) {
                System.out.println("du kommst rein :)");
                // wir bleiben in der Schleife solange wir eine richtige Antwort bekommen
                klareAntwortGegeben = true;
            } else if (antwort.equalsIgnoreCase("nein")) {
                    System.out.println("Hmm. Hast du zumindest eine Frau mit?");
                    antwort = input.nextLine();
                    // gleiche Schleife wie oben
                    while(!klareAntwortGegeben) {
                        if (antwort.equalsIgnoreCase("ja")) {
                            System.out.println("du kommst rein :)");
                            klareAntwortGegeben = true;
                        } else if (antwort.equalsIgnoreCase("nein")) {
                            System.out.println("Auf Wiedersehen :)");
                            klareAntwortGegeben = true;
                        } else {
                            // der User hat Unsinn angegeben
                            System.out.println("Hab ich nix verstanden, versuch nochmal");
                            antwort = input.nextLine();
                        }
                    }
            } else {
                    // der User hat Unsinn angegeben
                    System.out.println("Hab ich nix verstanden, versuch nochmal");
                    antwort = input.nextLine();
            }
            }   
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
