package pkg051_lottov2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("LOTTOSPIEL v4");

        System.out.println("MAKE YOUR CHOICE MAKE YOUR STAND");

        int[][] luckyNumbers = FillArrays();

        System.out.println("Deine ausgewaehlte Zahlen: ");
        PrintNumbers(luckyNumbers);

        System.out.println("SPIN THE WHEEL OF THE WORST");

        PlayGame(luckyNumbers);
    }

    public static int[] SpinTheWheel()
    {
        int[] randomNumbers = new int[6];
        Random randy = new Random();

        for (int i = 0; i < 6; i++) {
            boolean valid = false;

            while (!valid) {
                boolean repeatCheck = false;
                int zahl = randy.nextInt(1, 50);

                if (i == 0) {
                    randomNumbers[i] = zahl;
                    valid = true;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (randomNumbers[j] == zahl) {
                            repeatCheck = true;
                        }
                    }
                }
                // wenn die Zahl sich nicht wiederholt
                if (!repeatCheck) {
                    randomNumbers[i] = zahl;
                    valid = true;
                }
            }
        }
        return randomNumbers;
    }

    public static void PlayGame(int[][] numbers)
    {
        boolean jackpot = false;
        int wochen = 0;
        int gewinn = 0;
        int dreimal = 0;
        int viermal = 0;
        int fuenfmal = 0;
        int[] randomNumbers;
        int[] heatMap = new int[49];

        while (!jackpot) {
            int matchingNumbers = 0;
            randomNumbers = SpinTheWheel();
            
            for (int i = 0; i < 6; i++) {
                heatMap[randomNumbers[i] - 1]++;
            }
            
            for (int i = 0; i < numbers.length; i++) {
                // current ticket
                matchingNumbers = 0;
                for (int j = 0; j < 6; j++) {
                    // current array
                    for (int k = 0; k < 6; k++) {
                        if (randomNumbers[k] == numbers[i][j]) {
                            matchingNumbers++;
                        }
                    }
                }

                switch (matchingNumbers) {
                    case 3:
                        dreimal++;
                        gewinn += 8;
                        break;
                    case 4:
                        viermal++;
                        gewinn += 98;
                        break;
                    case 5:
                        fuenfmal++;
                        gewinn += 4998;
                        break;
                    case 6:
                        jackpot = true;
                        gewinn += 1999998;
                        System.out.println("Winning ticket: ");
                        for (int j = 0; j < 6; j++) {
                            System.out.print(randomNumbers[j] + " ");
                        }
                        System.out.println("");
                        break;
                    default:
                        gewinn -= 2;
                        break;
                }
            }
            wochen++;
        }
        // Menschlische Ausgabe von dem Zeitraum
        ParseWochen(wochen);
        
        System.out.println("Dein Gewinn ist: " + gewinn + " Euro.");
        System.out.println("Davon ist: ");
        System.out.println("3x Zahl Gewinn: " + dreimal + "mal - " + dreimal * 10 + " Euro.");
        System.out.println("4x Zahl Gewinn: " + viermal + "mal - " + viermal * 100 + " Euro.");
        System.out.println("5x Zahl Gewinn: " + fuenfmal + "mal - " + fuenfmal * 5000 + " Euro.");

        System.out.println("Fuer Tickets hast du dann " + wochen * 2 + " Euro ausgegeben.");
        
        System.out.println("Drucke 1, um die Haeufigkeit von Zahlen zeigen. Drucke 2 um zu beenden.");
        
        int auswahl = GetValue();
        
        switch (auswahl) {
            case 1:
                PrintHeatmap(heatMap, wochen);
                break;
            case 2:
                System.out.println("Thanks for playing");
                break;
            default:
                System.out.println("Nicht verstanden, auf Wiedersehen");
                break;
        }
        
    }

    public static void PrintNumbers(int[][] numbers)
    {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("\nTICKET NR. " + (i + 1) + "\n");
            for (int j = 0; j < 6; j++) {
                System.out.print(numbers[i][j] + " ");
            }
        }
        System.out.println("");
    }

    public static int[][] FillArrays()
    {
        System.out.println("Wie viele Tickets?");
        // add checks, can't be less than 0
        int auswahl = GetValue();
        int[] tempArray;

        int[][] userNumbers = new int[auswahl][6];

        for (int i = 0; i < auswahl; i++) {
            tempArray = SelectNumbers();
            for (int j = 0; j < 6; j++) {
                userNumbers[i][j] = tempArray[j];
            }
        }
        return userNumbers;
    }

    public static int[] SelectNumbers()
    {
        int[] luckyNumbers = new int[6];

        for (int i = 0; i < 6; i++) {
            System.out.println("ZAHL NR. " + (i + 1));
            boolean valid = false;

            while (!valid) {
                int inputNumber = GetValue();
                boolean repeatCheck = true;

                // uberpruft ob die Zahl im Range ist
                if (0 < inputNumber && inputNumber < 50) {
                    if (i == 0) {
                        luckyNumbers[i] = inputNumber;
                        valid = true;
                    } else {
                        for (int j = 0; j < i; j++) {
                            if (inputNumber == luckyNumbers[j]) {
                                repeatCheck = false;
                            }
                        }
                        if (!repeatCheck) {
                            System.out.println("Zahlen muessen sich nicht wiederholen!");
                        } else {
                            luckyNumbers[i] = inputNumber;
                            valid = true;
                        }

                    }
                } else {
                    System.out.println("Die Zahl muss inzwischen 1 und 49 sein!");
                }
            }
        }

        return luckyNumbers;

    }

    public static void ParseWochen(int wochen)
    {
        // Die Funktion gibt die formatierte Zeit bis zum Gewinn aus

        int jahren = wochen / 48;

        int monaten = (wochen % 48) / 4;

        int wochenRest = (wochen % 48) % 4;

        System.out.print("Du hast ");
        if (jahren != 0) {
            System.out.print(jahren + " Jahren");
        }
        if (monaten != 0) {
            if (jahren != 0) {
                System.out.print(", ");
            }
            System.out.print(monaten + " Monaten");
        }
        if (wochenRest != 0) {
            if (monaten != 0 || jahren != 0) {
                System.out.print(", ");
            }
            System.out.print(wochenRest + " Wochen");
        }
        System.out.println(" bis zum JACKPOT gewartet.");
    }

    public static int GetValue()
    {
        int zahl;
        Scanner input = new Scanner(System.in);
        // diese Funktion prüft, ob die Eingabe ein int ist und sagt true oder false
        // Am sonsten muss der User nochmal versuchen
        while (true) {
            try {
                zahl = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                // Zahl ist keine Zahl
                System.out.println("Das ist keine Zahl, versuch nochmal");
            }
        }
        return zahl;
    }
    
    public static void PrintHeatmap(int[] numberMap, int wochen) {
        int maxValue = numberMap[0];
        int maxZahl = 0;
        // Ausgibt die Hauefigkeit von Zahlen
        for (int i = 0; i < 49; i++) {
            
            if (numberMap[i] > maxValue) {
                maxValue = numberMap[i];
                maxZahl = i + 1;
            }
            
            if (i < 9) {
                System.out.print("Nummer: " + (i + 1) + " ");
            } else {
                System.out.print("Nummer: " + (i + 1));
            }
            
            System.out.print("| Hauefigkeit: " + numberMap[i]);
            System.out.println("| Percentuell: " + ((float) numberMap[i] / (float) wochen) * 100 + "%");
            
        }
        System.out.println("Die glueklichste Zahl war: " + maxZahl);
    }
}