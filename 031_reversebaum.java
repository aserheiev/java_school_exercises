package pkg031_reversebaum;

public class Main {

    public static void main(String[] args) {
        int limit = 5;
        
        for (int i = limit; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    } 
}
