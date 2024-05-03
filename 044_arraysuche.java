package pkg044_arraysuche;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        boolean wirSpielen = true;

        while (wirSpielen) {
            String wahl;

            int zeilen = 0;
            int spalten = 0;
            int rngrenze = 100;
            int suchWert;
            boolean inputCheck = false;
            while (!inputCheck) {
                System.out.println("Welches Array willst du: 1D oder 2D?");
                wahl = input.nextLine();
                switch (wahl) {
                    case "1D":
                        System.out.println("Wie lang soll der Array sein?");
                        // Gute Werte bekommen
                        while (true) {
                            try {
                                spalten = Integer.parseInt(input.nextLine());
                                if (spalten <= 0) {
                                    System.out.println("Zahl ist null oder negativ, versuch nochmal.");
                                    continue;
                                }
                                break;
                            } catch (NumberFormatException e) {
                                // Zahl ist keine Zahl
                                System.out.println("Das ist keine richtige Zahl, versuch nochmal.");
                            }
                        }

                        inputCheck = true;
                        break;
                    case "2D":
                        System.out.print("Wie viele Zeilen: ");
                        while (true) {
                            try {
                                zeilen = Integer.parseInt(input.nextLine());
                                if (zeilen <= 0) {
                                    System.out.println("Zahl ist null oder negativ, versuch nochmal.");
                                    continue;
                                }
                                break;
                            } catch (NumberFormatException e) {
                                // Zahl ist keine Zahl
                                System.out.println("Das ist keine richtige Zahl, versuch nochmal.");
                            }
                        }
                        System.out.print("Wie viele Spalten: ");
                        while (true) {
                            try {
                                spalten = Integer.parseInt(input.nextLine());
                                if (spalten <= 0) {
                                    System.out.println("Null oder negativ");
                                    continue;
                                }
                                break;
                            } catch (NumberFormatException e) {
                                // Zahl ist keine Zahl
                                System.out.println("Das ist keine richtige Zahl, versuch nochmal");
                            }
                        }
                        inputCheck = true;
                        break;
                    default:
                        System.out.println("Nix verstanden, versuch bitte nochmal.");
                        break;
                }
            }

            System.out.println("Bis wie viel sollten die RNG Werte gehen? (0 - ?)");
            while (true) {
                try {
                    rngrenze = Integer.parseInt(input.nextLine());
                    if (rngrenze <= 0) {
                        System.out.println("Zahl ist null oder negativ, versuch nochmal.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    // Zahl ist keine Zahl
                    System.out.println("Das ist keine richtige Zahl, versuch nochmal.");
                }
            }

            System.out.println("Nach welcher Wert willst du suchen?");
            while (true) {
                try {
                    suchWert = Integer.parseInt(input.nextLine());
                    if (suchWert > rngrenze || suchWert < 0) {
                        System.out.println("Du bist out of James Bonds Alter");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    // Zahl ist keine Zahl
                    System.out.println("Das ist keine richtige Zahl, versuch nochmal");
                }
            }

            if (zeilen < 2) {
                int[] array = new int[spalten];
                int hitCounter = 0;
                String sucheAusgabe = "Die Wert befindet sich unter den folgenden Positionen: ";

                // Array fuellen
                for (int i = 0; i < spalten; i++) {
                    array[i] = generator.nextInt(0, rngrenze + 1);
                }

                // Array ausgeben
                System.out.print("\n| ");
                for (int i = 0; i < spalten; i++) {

                    if (array[i] == suchWert) {
                        // rote Farbe + Suche Zaehler + Positionsausgabe speichern
                        System.out.print(ANSI_RED + suchWert + ANSI_RESET + " ");
                        hitCounter++;
                        sucheAusgabe += (i + 1) + ", ";
                    } else {
                        System.out.print(array[i] + " ");
                    }
                }
                System.out.println("|");

                // Suchergebnis
                if (hitCounter == 0) {
                    System.out.println("Wert nicht gefunden.");
                } else {
                    System.out.println("Die Wert wurde " + hitCounter + " Mal gefunden. ");
                    System.out.println(sucheAusgabe.substring(0, sucheAusgabe.length() - 2) + ".");
                }

            } else {
                int[][] array = new int[zeilen][spalten];
                int maxWert = 0;
                int maxStellen = 0;
                int hitCounter = 0;
                String sucheAusgabe = "Die Wert befindet sich unter den folgenden Koordinaten:\n";
                // der String unten hat die ganze Tabelle am Ende
                String ausgabe = "";

                // Array fuellen
                for (int i = 0; i < zeilen; i++) {
                    for (int j = 0; j < spalten; j++) {
                        if (i == 0 && j == 0) {
                            maxWert = array[i][j];
                        }
                        array[i][j] = generator.nextInt(0, rngrenze + 1);
                        if (array[i][j] > maxWert) {
                            maxWert = array[i][j];
                        }
                    }
                }

                // Ich suche die maximalen Dezimalstellen des größten Wertes, 
                // damit ich weiß, wie groß die Zellen sein müssen.
                while (maxWert != 0) {
                    maxStellen++;
                    maxWert /= 10;
                }

                for (int i = 0; i < zeilen; i++) {
                    ausgabe += "|";
                    for (int j = 0; j < spalten; j++) {
                        int checkj = array[i][j];
                        int checkStellen = 0;
                        String leerzeichen = "";

                        // Ich vergleiche die Dezimalstellen der aktuellen Zahl 
                        // und stelle fest, ob ich Leerzeichen zum Ausfüllen der Zelle benötige
                        if (checkj != 0) {
                            while (checkj != 0) {
                                checkStellen++;
                                checkj /= 10;
                            }
                        } else {
                            checkStellen = 1;
                        }

                        for (int k = 0; k < (maxStellen - checkStellen); k++) {
                            leerzeichen += " ";
                        }

                        if (array[i][j] == suchWert) {
                            hitCounter++;
                            ausgabe += " " + ANSI_RED + array[i][j] + ANSI_RESET + leerzeichen + " |";
                            sucheAusgabe += "Ergebnis " + hitCounter + ": Zeile " + (i + 1) + ", Spalte " + (j + 1) + ".\n";
                        } else {
                            ausgabe += " " + array[i][j] + leerzeichen + " |";
                        }

                    }
                    ausgabe += "\n";
                }

                System.out.println(ausgabe);

                if (hitCounter != 0) {
                    System.out.println("Die Wert wurde " + hitCounter + " Mal gefunden.");
                    System.out.println(sucheAusgabe);
                } else {
                    System.out.println("Die Wert wurde leider nicht gefunden.");
                }
            }

            System.out.println("Nochmal spielen?");
            String antwort = input.nextLine();
            boolean antwortErhalten = false;

            while (!antwortErhalten) {
                if (antwort.equalsIgnoreCase("Ja")) {
                    antwortErhalten = true;
                } else if (antwort.equalsIgnoreCase("Nein")) {
                    wirSpielen = false;
                    antwortErhalten = true;
                } else {
                    System.out.println("Nix verstanden, versuch nochmal bitte");
                }
            }
        }
        System.out.println("Okay, DANKE FRED.");
    }
}
