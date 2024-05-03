package pkg037_hourglass;

public class Main {

    public static void main(String[] args) {
        int limit = 21;
        int mitte = limit/2;
        
        for (int i = 0; i < limit; i++) {
            if (i == 0 || i == limit - 1) {
                // erste und letzte Zeile
                for (int j = 0; j < (limit+1)/2; j++) {
                    System.out.print("* ");
                }
            } else if (i <= mitte) {
                // Leerzeichen Schleife
                for (int k = 0; k < i; k++) {
                    System.out.print(" ");
                }
                // Oberer Teil des "Dreiecks"
                for (int j = 0; j < limit + (i * -2); j++) {
                    if (j == 0 || j == (limit + (i * -2)) - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                // Unterer Teil
                // Leerzeichen
                for (int k = limit - 1; k > i; k--) {
                    System.out.print(" ");
                }
                // Kopfschmerzen
                for (int j = 0; j < ((i - mitte) * 2 + 1); j++) {
                    if (j == 0 || j == ((i - mitte) * 2 + 1) - 1){
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
        
    }
}

