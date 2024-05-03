package pkg027_zahlbaum5;

public class Main {

    public static void main(String[] args) 
    {   
        char buchstabe = 'A';
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < (i + 1); j++) {
                System.out.print(buchstabe + " ");
            }
            System.out.println("");
            buchstabe++;
        }
    }
}