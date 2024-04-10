package pkg010_vergleich;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        System.out.println("Erste Wert:");
        int a = GetValue();
        System.out.println("Zweite Wert:");
        int b = GetValue();
        System.out.println("Dritte Wert:");
        int c = GetValue();
        if (a == b) {
            if (a == c) {
                System.out.println(a + " = " + b + " = " + c);
            } else {
                // a = b but not c
                if (a > c) {
                    System.out.println(a + " = " + b + " > " + c);
                } else 
                {
                    System.out.println(a + " = " + b + " < " + c);
                }
            }
        } else {
            // a und b sind nicht gleich
            if (a == c) {
                // a und c sind gleich
                if (a > b) {
                    System.out.println(a + " = " + c + " > " + b);
                } else {
                    System.out.println(a + " = " + c + " < " + b);
                }
            } else {
                if (b == c) {
                    // b und c sind gleich
                    if (b > a) {
                        System.out.println(b + " = " + c + " > " + a);
                    } else {
                        System.out.println(b + " = " + c + " < " + a);
                    }
                } else {
                    // keine sind gleich
                    if (a > b) {
                        if (a > c) {
                            if (b > c) {
                                System.out.println(a + " > " + b + " > " + c);
                            } else {
                                System.out.println(a + " > " + c + " > " + b);
                            }
                        } else {
                            System.out.println(c + " > " + a + " > " + b);
                        }
                    } else {
                        // b > a
                        if (b > c) {
                            if (a > c) {
                                System.out.println(b + " > " + a + " > " + c);
                            } else {
                                System.out.println(b + " > " + c + " > " + a);
                            }
                        } else {
                            // b < c && b > a
                            System.out.println(c + " > " + b + " > " + a);
                        }
                    }
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
            // zahl = input.nextInt();
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