package pkg035_reverselosange;

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
                    if (j == 0 || j == i) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            } else {
                for (int k = limit; k >= (limit - i); k--)
                {
                System.out.print(" ");
                }
                for (int j = limit; j > i; j--) 
                {
                if (j == limit || j == i + 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("");
        }
    }
}

