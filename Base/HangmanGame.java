package com.gabry.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    private static final String[] PAROLE = {"programmazione", "java", "sviluppatore", "console", "algoritmo", "intellij"};
    private static final int MAX_ERRORI = 6;

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        Random randomGenerator = new Random();
        
        // Scegli una parola casuale
        String parolaSegreta = PAROLE[randomGenerator.nextInt(PAROLE.length)].toUpperCase();
        
        // Array di caratteri per tenere traccia delle lettere indovinate, inizialmente tutti underscore
        char[] parolaIndovinata = new char[parolaSegreta.length()];
        Arrays.fill(parolaIndovinata, '_'); // Riempie l'array con '_'

        int erroriCorrenti = 0;
        String lettereTentate = ""; // Stringa che memorizza tutte le lettere già provate

        System.out.println("--- GIOCO DELL'IMPICCATO ---");
        System.out.println("Parola di " + parolaSegreta.length() + " lettere. Hai " + MAX_ERRORI + " errori disponibili.");

        // Ciclo di gioco principale
        while (erroriCorrenti < MAX_ERRORI && String.valueOf(parolaIndovinata).contains("_")) {
            
            System.out.println("\n----------------------------------------");
            System.out.println("Parola: " + String.valueOf(parolaIndovinata));
            System.out.println("Lettere già tentate: " + lettereTentate);
            System.out.println("Errori rimasti: " + (MAX_ERRORI - erroriCorrenti));
            System.out.print("Inserisci una lettera: ");

            String input = inputLettore.nextLine().trim().toUpperCase();
            
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.err.println("Input non valido. Inserisci una singola lettera.");
                continue;
            }
            
            char tentativo = input.charAt(0);

            // Controllo se la lettera è già stata tentata
            if (lettereTentate.contains(String.valueOf(tentativo))) {
                System.out.println("Hai già provato la lettera '" + tentativo + "'.");
                continue;
            }

            // Aggiungi il tentativo alla lista delle lettere provate
            lettereTentate += tentativo;
            
            boolean indovinataNellaParola = false;
            
            // Scansiona la parola segreta
            for (int i = 0; i < parolaSegreta.length(); i++) {
                if (parolaSegreta.charAt(i) == tentativo) {
                    parolaIndovinata[i] = tentativo; // Riscrivi l'underscore con la lettera
                    indovinataNellaParola = true;
                }
            }
            
            // Gestione del risultato del tentativo
            if (indovinataNellaParola) {
                System.out.println("Bene! La lettera '" + tentativo + "' è presente.");
            } else {
                erroriCorrenti++;
                System.out.println("Sbagliato. La lettera '" + tentativo + "' non è presente.");
            }
        }

        // --- Fine del Gioco ---
        System.out.println("\n========================================");
        if (!String.valueOf(parolaIndovinata).contains("_")) {
            System.out.println("🎉 CONGRATULAZIONI! Hai indovinato la parola!");
            System.out.println("PAROLA: " + parolaSegreta);
        } else {
            System.out.println("💀 HAI PERSO. Hai esaurito gli errori.");
            System.out.println("La parola segreta era: " + parolaSegreta);
        }
        System.out.println("========================================");

        inputLettore.close();
    }
}