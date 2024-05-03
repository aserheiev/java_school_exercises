package pkg99_baumbaum;
import java.util.Random;


public class Main {
 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    
    public static void main(String[] args) 
    {
        String text = "MERRY CHRISTMAS AND A HAPPY NEW YEAR ";
        int limit = 9;
        String currentColor = ANSI_YELLOW;
        
        for (int i = 0; i < 50; i++) {
            
            if (text.length() < limit * 2) {
            for (int j = 0; j < (limit / 2) ; j++) {
                System.out.print(" ");
            }
            System.out.println(text.substring(0, limit));
        } else {
              System.out.println(text.substring(0, limit * 2));
            }
            
            text = UpdateText(text);
            DrawTree(currentColor);
            currentColor = FlipColor(currentColor);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
            }
        }
        
    }
    
    public static String UpdateText(String text) {
        text = text.substring(1) + text.charAt(0);
        return text;
    }
    
    public static String FlipColor(String color) {
        if (color.equals(ANSI_BLUE)) {
            color = ANSI_YELLOW;
        } else if (color.equals(ANSI_YELLOW)) {
            color = ANSI_BLUE;
        }
        return color;
    }
    
    public static void DrawTree(String color) {
        Random generator = new Random();
        int balls;
        int limit = 9;
        String currentColor = color;
        
        for (int i = 0; i < limit; i++) {
            for (int k = 0; k < (limit - i); k++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                
                if (j == 0 && i == 0) {
                    System.out.println(currentColor + "/\\" + ANSI_RESET);
                    for (int k = 0; k < (limit - i)- 1; k++)
            {
                System.out.print(" ");
            }
                    System.out.print(currentColor + "< " + ANSI_RESET);
                    System.out.println(currentColor + " >" + ANSI_RESET);
                    for (int k = 0; k < (limit - i) ; k++)
            {
                System.out.print(" ");
            }
                    System.out.print(currentColor + "\\/" + ANSI_RESET);
                    
                } else if (i == limit - 1) {
                    System.out.print(ANSI_GREEN + "_ " + ANSI_RESET);
                }
                else if (j == 0) {
                    System.out.print(ANSI_GREEN + "/ " + ANSI_RESET);
                } else if (j == i) {
                    System.out.print(ANSI_GREEN + "\\ " + ANSI_RESET);
                } else {
                    balls = generator.nextInt(0, 100);
                    if (balls <= 15) {
                        System.out.print(ANSI_RED + "O " + ANSI_RESET);
                    } else {
                        System.out.print(ANSI_GREEN + "* " + ANSI_RESET);
                    }
                }
            }
            System.out.println("");
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= limit; j++) {
                if (j < limit) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }
}