package pkg046_2dsort;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Zeilen: ");

        int zeilen = input.nextInt();

        System.out.println("Spalten: ");
        int spalten = input.nextInt();

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

        int[][] array = new int[zeilen][spalten];

        Random generator = new Random();

        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                array[i][j] = generator.nextInt(unteneGrenze, obereGrenze);
            }
        }

        int maxWert = array[0][0];
        int stellen = 0;

        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                if (array[i][j] > maxWert) {
                    maxWert = array[i][j];
                }
            }
        }

        while (maxWert != 0) {
            stellen++;
            maxWert /= 10;
        }

        System.out.println("Unsortiert:");
        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                String leerzeichen = "";
                int stellenCheck = array[i][j];
                int currentStellen = 0;

                if (stellenCheck == 0) {
                    currentStellen = 1;
                } else {
                    while (stellenCheck != 0) {
                        currentStellen++;
                        stellenCheck /= 10;
                    }
                }

                for (int k = 0; k < stellen - currentStellen; k++) {
                    leerzeichen += " ";
                }

                System.out.print(array[i][j] + leerzeichen + " ");
            }
            System.out.println("");
        }

        System.out.println("WAHL:\n1. Aufsteigend\n2. Absteigend\n3. Vertikal aufsteigend\n4. Vertikal absteigend");

        String wahl = input.next();

        switch (wahl) {
            case "1":
                for (int i = 0; i < zeilen; i++) {
                    for (int j = 0; j < spalten; j++) {
                        for (int k = 0; k < zeilen; k++) {
                            for (int l = 0; l < spalten; l++) {
                                if (array[i][j] < array[k][l]) {
                                    array[i][j] += array[k][l];
                                    array[k][l] = array[i][j] - array[k][l];
                                    array[i][j] -= array[k][l];
                                }
                            }
                        }
                    }
                }
                break;
            case "2":
                for (int i = 0; i < zeilen; i++) {
                    for (int j = 0; j < spalten; j++) {
                        for (int k = 0; k < zeilen; k++) {
                            for (int l = 0; l < spalten; l++) {
                                if (array[i][j] > array[k][l]) {
                                    array[i][j] += array[k][l];
                                    array[k][l] = array[i][j] - array[k][l];
                                    array[i][j] -= array[k][l];
                                }
                            }
                        }
                    }
                }
                break;
            case "3":
                for (int i = 0; i < spalten; i++) {
                    for (int j = 0; j < zeilen; j++) {
                        for (int k = 0; k < spalten; k++) {
                            for (int l = 0; l < zeilen; l++) {
                                if (array[j][i] < array[l][k]) {
                                    array[j][i] += array[l][k];
                                    array[l][k] = array[j][i] - array[l][k];
                                    array[j][i] -= array[l][k];
                                }
                            }
                        }
                    }
                }
                break;
            case "4":
                for (int i = 0; i < spalten; i++) {
                    for (int j = 0; j < zeilen; j++) {
                        for (int k = 0; k < spalten; k++) {
                            for (int l = 0; l < zeilen; l++) {
                                if (array[j][i] > array[l][k]) {
                                    array[j][i] += array[l][k];
                                    array[l][k] = array[j][i] - array[l][k];
                                    array[j][i] -= array[l][k];
                                }
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Nix verstanden. Keine Sortierung fuer dich");
        }

        System.out.println("Ausgabe:");
        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                String leerzeichen = "";
                int stellenCheck = array[i][j];
                int currentStellen = 0;

                if (stellenCheck == 0) {
                    currentStellen = 1;
                } else {
                    while (stellenCheck != 0) {
                        currentStellen++;
                        stellenCheck /= 10;
                    }
                }

                for (int k = 0; k < stellen - currentStellen; k++) {
                    leerzeichen += " ";
                }

                System.out.print(array[i][j] + leerzeichen + " ");
            }
            System.out.println("");
        }
    }
}
