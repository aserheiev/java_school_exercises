
package pkg003_datentypen;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args)
    {

////      prüft, ob ein Wert gerade ist
//        Scanner input = new Scanner(System.in);
//        
//        int a = Integer.parseInt(input.nextLine());
//        
//        if (a % 2 == 0)
//        {
//            System.out.println("gerade zahl");
//        } else {
//            System.out.println("ungerade zahl");
//        }
        
        double zahl1 = 10f;
        double zahl2 = 10.22f;
        
        // gibt aus 20.22000026702881 weil es kann nicht so genau gespeichert werden (?)
        System.out.println("Sum of two doubles: " + (zahl1 + zahl2));
        
        BigDecimal zahl3 = new BigDecimal("10");
        BigDecimal zahl4 = new BigDecimal("10.1");
        
        BigDecimal bigErgebnis = zahl3.add(zahl4);
        // interessanterweise haben wir eine bessere Genauigkeit
        // wenn wir BigDecimal den Wert aus einer String konstruieren lassen
        
        System.out.println("Sum of two BIG decimals: " + bigErgebnis);
        
    }
    
}
