package pkg006_minuten;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        // Eingabe in Minuten
        int minuten = 9999999;
        System.out.println(GetTime(minuten));
    }
    
    public static String GetTime(int minuten) 
    {
        String output;
        ArrayList<String> list = new ArrayList();
        // ich speichere die originelle Wert als String
        String ogMinuten = String.valueOf(minuten);
       
        // entschuldigung für die magichen Zahlen

        int jahre = minuten / 483840;
        if (jahre != 0) {
            String jahreText = String.valueOf(jahre) + " Jahre";
            list.add(jahreText);
        }
        minuten = minuten % 483840;
        
        int monate = minuten / 40320;
        if (monate != 0) {
            String monateText = String.valueOf(monate) + " Monate";
            list.add(monateText);
        }
        minuten = minuten % 40320;
        
        int wochen = minuten / 10080;
        if (wochen != 0) {
            String wochenText = String.valueOf(wochen) + " Wochen";
            list.add(wochenText);
        }  
        minuten = minuten % 10080;
        
        int tage = minuten / 1440;
        
        if (tage != 0) {
            String tageText = String.valueOf(tage) + " Tage";
            list.add(tageText);
        }
        minuten = minuten % 1440;
        
        int stunden = minuten / 60;
        if (stunden != 0) {
            String stundenText = String.valueOf(stunden) + " Stunden";
            list.add(stundenText);
        }
        minuten = minuten % 60;
        
        if (minuten != 0) {
            String minutenText = String.valueOf(minuten) + " Minuten";
            list.add(minutenText);
        }
        
        output = ogMinuten + " Minuten sind: " + list.toString().replace("[", "").replace("]", "") + ".";
        
        return output;
    }
}