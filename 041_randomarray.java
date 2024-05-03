package pkg041_randomarray;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
    
    int[] array;
    int negativAnzahl = 0;
    int positivAnzahl = 0;
    int nullen = 0;
    int summe = 0;
    Random generator = new Random();
    Scanner inpuli = new Scanner(System.in);
    
    System.out.println("Wie gross soll der Array sein?");
    int angaben = inpuli.nextInt();
    array = new int[angaben];
    
        for (int i = 0; i < angaben; i++) {
            array[i] = generator.nextInt(-100, 101);
            summe += array[i];

            if (array[i] < 0) {
                negativAnzahl++;
            } else if (array[i] > 0) {
                positivAnzahl++;
            } else {
                nullen++;
            }
        }
        
        System.out.println("\nDie angegebene Werte sind: ");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                // Damit wir ein Punkt am Ende haben und keine Comma
                System.out.println(array[i] + ".\n");
            }
        }
        
        System.out.println("Die Summe ist: " + summe);
        
        System.out.println("Anzahl von negativen Zahlen: " + negativAnzahl);
        System.out.println("Anzahl von positiven Zahlen: " + positivAnzahl);
        System.out.println("Anzahl von Nullen: " + nullen);
        
    }
}