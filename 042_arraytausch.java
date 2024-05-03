package pkg042_arraytausch;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array;
        // int[] array2;
        int eingabe;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Wie viele Zahlen: ");
        eingabe = input.nextInt();
        array = new int[eingabe];
        // array2 = new int[eingabe];
        
        for (int i = 0; i < eingabe; i++) {
            System.out.println("Naechste Zahl: ");
            array[i] = input.nextInt();
        }
        
        // jank
        /* for (int i = 0; i < eingabe; i++) {
            array2[i] = array[array.length - 1 - i];
        }
        
        array = array2; */
        
        // tauscht Werte und nähert sich der Mitte von beiden Seiten
        for (int i = 0; i < array.length / 2; i++) {
            int wert = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = wert;
        }
        
        // Ausgabe
        for (int i = 0; i < eingabe; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
}