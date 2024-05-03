package pkg023_zahlbaum;

public class Main {

    public static void main(String[] args) {
        int limit = 4;
        int zahl = 1;
        
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < (limit - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(zahl + " ");
            }
            System.out.println("");
            zahl++;
        }
    }
}