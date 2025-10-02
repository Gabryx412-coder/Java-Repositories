package com.gabry.passwordgenerator;

import java.security.SecureRandom; // Preferibile a java.util.Random per la sicurezza
import java.util.InputMismatchException;
import java.util.Scanner;

public class SimplePasswordGenerator {

    // Caratteri utilizzabili per la generazione della password
    private static final String CARATTERI_DISPONIBILI = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + // Lettere maiuscole
        "abcdefghijklmnopqrstuvwxyz" + // Lettere minuscole
        "0123456789";                   // Numeri

    /**
     * Genera una stringa casuale della lunghezza specificata.
     * * @param lunghezza La lunghezza desiderata della password.
     * @return La password casuale generata come String.
     */
    public static String generaPassword(int lunghezza) {
        // Usiamo SecureRandom per una maggiore casualità e sicurezza
        SecureRandom random = new SecureRandom();
        StringBuilder passwordBuilder = new StringBuilder(lunghezza);
        int lunghezzaCaratteri = CARATTERI_DISPONIBILI.length();

        // Ciclo per costruire la password carattere per carattere
        for (int i = 0; i < lunghezza; i++) {
            // Genera un indice casuale all'interno dell'array di caratteri disponibili
            int indiceCasuale = random.nextInt(lunghezzaCaratteri);
            
            // Aggiunge il carattere all'indice casuale alla password
            char carattereCasuale = CARATTERI_DISPONIBILI.charAt(indiceCasuale);
            passwordBuilder.append(carattereCasuale);
        }

        // Converte e restituisce il StringBuilder come String
        return passwordBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);
        int lunghezzaDesiderata = 0;
        final int LUNGHEZZA_MINIMA = 6; 

        System.out.println("--- Generatore di Password Casuali Semplici ---");

        // Richiesta e validazione della lunghezza
        try {
            System.out.print("Inserisci la lunghezza desiderata della password (es. 10): ");
            lunghezzaDesiderata = scannerInput.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Errore di Input: Devi inserire un numero intero per la lunghezza.");
            scannerInput.close();
            return;
        }

        if (lunghezzaDesiderata < LUNGHEZZA_MINIMA) {
            System.err.println("Errore: La lunghezza minima consigliata è " + LUNGHEZZA_MINIMA + " caratteri. Riprova.");
            scannerInput.close();
            return;
        }
        
        // Chiamata al metodo di generazione e stampa del risultato
        String passwordGenerata = generaPassword(lunghezzaDesiderata);

        System.out.println("-------------------------------------------------------");
        System.out.println("Password generata (Lunghezza: " + lunghezzaDesiderata + "):");
        System.out.println(passwordGenerata);
        System.out.println("-------------------------------------------------------");

        scannerInput.close();
    }
}