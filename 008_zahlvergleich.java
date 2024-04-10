package pkg008_zahlvergleich;

public class Main {

    public static void main(String[] args)
    {
        int a = 22;
        int b = 17;
        
        // erst überprüfen ob die Zahlen gleich sind
        if (a == b) {
            System.out.println("Die Zahlen sind gleich.");
        } else {
            // die Zahlen sind nicht gleich, dann vergleichen
            if (a > b) {
                System.out.println("a ist groesser als b");
            } else {
                System.out.println("b ist groesser als a");
            }
        }
    }
}