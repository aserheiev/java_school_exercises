package pkg045_sort;
import java.util.Random;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        int[] numbers = new int[22];
        Random generator = new Random();
        Scanner input = new Scanner(System.in);
        int obereGrenze;
        System.out.println("Untene RNG Grenze: ");
        int unteneGrenze = input.nextInt();
        while (true) {
            System.out.println("Obere RNG Grenze: ");
            obereGrenze = input.nextInt() + 1;
            if (obereGrenze > unteneGrenze) {
                break;
            }
            System.out.println("Obere Grenze kann nicht kleiner als die Untene sein!");
        }
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(unteneGrenze, obereGrenze);
        }
        System.out.print("Unsortiertes Array: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // Wertwechsel
                if (numbers[i] > numbers[j]) {
                    numbers[i] += numbers[j];
                    numbers[j] = numbers[i] - numbers[j];
                    numbers[i] -= numbers[j];
                }
            }
        }
        System.out.print("Sortiertes Array: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
    }
}