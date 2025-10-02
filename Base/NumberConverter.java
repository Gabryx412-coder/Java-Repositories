package com.gabry.converters;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberConverter {

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int scelta;
        
        System.out.println("--- Convertitore di Base Numerica ---");

        do {
            System.out.println("\nScegli la conversione:");
            System.out.println("1. Decimale a Binario/Esadecimale");
            System.out.println("2. Binario a Decimale/Esadecimale");
            System.out.println("3. Esadecimale a Decimale/Binario");
            System.out.println("4. Esci");
            System.out.print("Scelta (1-4): ");
            
            try {
                scelta = inputLettore.nextInt();
                inputLettore.nextLine(); // Consuma newline
            } catch (InputMismatchException e) {
                System.err.println("Input non valido. Inserisci un numero.");
                inputLettore.nextLine();
                scelta = 0;
                continue;
            }

            switch (scelta) {
                case 1:
                    convertFromDecimal(inputLettore);
                    break;
                case 2:
                    convertFromBinary(inputLettore);
                    break;
                case 3:
                    convertFromHex(inputLettore);
                    break;
                case 4:
                    System.out.println("Uscita dal convertitore. Arrivederci.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 4);
        
        inputLettore.close();
    }
    
    private static void convertFromDecimal(Scanner scanner) {
        try {
            System.out.print("Inserisci il numero Decimale: ");
            int dec = scanner.nextInt();
            String bin = Integer.toBinaryString(dec);
            String hex = Integer.toHexString(dec).toUpperCase();
            System.out.println("Decimale: " + dec);
            System.out.println("Binario: " + bin);
            System.out.println("Esadecimale: " + hex);
            scanner.nextLine(); // Consuma newline
        } catch (InputMismatchException e) {
            System.err.println("Input non valido. Assicurati di inserire un numero intero.");
            scanner.nextLine();
        }
    }
    
    private static void convertFromBinary(Scanner scanner) {
        System.out.print("Inserisci il numero Binario: ");
        String bin = scanner.nextLine().trim();
        try {
            int dec = Integer.parseInt(bin, 2);
            String hex = Integer.toHexString(dec).toUpperCase();
            System.out.println("Binario: " + bin);
            System.out.println("Decimale: " + dec);
            System.out.println("Esadecimale: " + hex);
        } catch (NumberFormatException e) {
            System.err.println("Input binario non valido. Assicurati contenga solo 0 e 1.");
        }
    }
    
    private static void convertFromHex(Scanner scanner) {
        System.out.print("Inserisci il numero Esadecimale: ");
        String hex = scanner.nextLine().trim();
        try {
            int dec = Integer.parseInt(hex, 16);
            String bin = Integer.toBinaryString(dec);
            System.out.println("Esadecimale: " + hex.toUpperCase());
            System.out.println("Decimale: " + dec);
            System.out.println("Binario: " + bin);
        } catch (NumberFormatException e) {
            System.err.println("Input esadecimale non valido.");
        }
    }
}