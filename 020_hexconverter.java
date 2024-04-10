package pkg020_hexadecimal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String hexZahl = "";
        int pos = 0;
        int ergebnis = 0;

        System.out.println("Bitte eine Hexadezimale Zahl eingeben:");
        hexZahl = input.nextLine();
        for (int i = 0; i < hexZahl.length(); i++) {
            pos = hexZahl.length() - (i + 1);
            ergebnis += berechne_Stellenwert(hexZahl.charAt(i), pos);
        } 
        
        System.out.println("Hex Zahl: " + hexZahl);
        System.out.println("Ergebnis: " + ergebnis);
        
    }

    public static int berechne_Stellenwert(char zeichen, int stelle)
    {
        int stellenwert = 0;
        int ziffernwert = 0;
        double stelle2 = stelle;

        if (zeichen >= '0' && zeichen <= '9') {
            ziffernwert = zeichen - 48;
        } else {
            switch (zeichen) {
                case 'A':
                    ziffernwert = 10;
                    break;
                case 'B':
                    ziffernwert = 11;
                    break;
                case 'C':
                    ziffernwert = 12;
                    break;
                case 'D':
                    ziffernwert = 13;
                    break;
                case 'E':
                    ziffernwert = 14;
                    break;
                case 'F':
                    ziffernwert = 15;
                    break;
            }
        }
        
        stellenwert = ziffernwert * (int)Math.pow(16, stelle2);
        
        return stellenwert;
    }
}
