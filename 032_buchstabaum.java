package pkg032_buchstabaum;
 
public class Main {
 
    public static void main(String[] args) 
    {
        int limit = 9;
        char buchstabe = 'A';
        for (int i = 0; i < limit; i += 2) {
            for (int k = 0; k < (limit - i); k++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                
                if (j == 0 || j == i) {
                    System.out.print(buchstabe + " ");
                } else {
                    System.out.print("* ");
                } 
            }
            buchstabe++;
            System.out.println("");
        }
    }
}