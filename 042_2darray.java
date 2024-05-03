package pkg042_2darray;

public class Main {

    public static void main(String[] args) {
        float[][] array = new float[3][5];
        
        // Füllen des Arrays
        for (int i = 0; i < 3; i++) {
            float zahl = 0;
            for (int j = 0; j < 5; j++) {
                array[i][j] = i + zahl/10;
                zahl++;
            }
        }
        
        String ausgabe = "";
        // Ausgabe des Arrays
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                ausgabe += Float.toString(array[i][j]) + " | ";
            }
            ausgabe += "\n";
        }
        ausgabe = ausgabe.replace('.', ',');
        System.out.println(ausgabe);
    }
}