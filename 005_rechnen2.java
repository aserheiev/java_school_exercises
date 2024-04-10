package pkg005_rechnen2;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {


    public static void main(String[] args)
    {       
        float a = 17f;
        float b = 22f;
        String textA = String.valueOf(Math.round(a));
        String textB = String.valueOf(Math.round(b));
        
        System.out.println("Die Zahlen sind " + textA + " und " + textB);
                
        System.out.println(textA + " + " + textB + " = " + (a + b));
        System.out.println(textA + " - " + textB + " = " + (a - b));
        System.out.println(textA + " * " + textB + " = " + (a * b));
        System.out.println(textA + " / " + textB + " = " + (a / b));
        System.out.println(textA + " % " + textB + " = " + (a % b));
    }
    
}
