package pkg030_losange;

public class Main {

    public static void main(String[] args) 
    {
        int limit = 7;

        for(int i = 0; i < limit; i++){

            if (i < limit/2) {
                for (int k = 0; k < (limit - i); k++)
                {
                System.out.print(" ");
                }
                for (int j = 0; j <= i; j++) 
                {
                System.out.print("* ");
                }
            } else {
                for (int k = limit; k >= (limit - i); k--)
                {
                System.out.print(" ");
                }
                for (int j = limit; j > i; j--) 
                {
                System.out.print("* ");
                }
            }

            System.out.println("");
        }
    }
}
