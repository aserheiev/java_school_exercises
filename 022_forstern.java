package pkg022_forstern;

public class Main {

    public static void main(String[] args) 
    {
        int limit = 6;
        int limit2 = 5;
        
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit2; j++){
                if (i == 0 || i == (limit - 1)) {
                    System.out.print("* ");
                } else if (j == 0 || j == (limit2 - 1) ) {
                    System.out.print("* S");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }
}