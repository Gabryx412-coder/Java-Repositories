package com.gabry.fattoriale;

import java.math.BigInteger; // Usiamo BigInteger per gestire fattoriali grandi
import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorialCalculator {

    public static void main(String[] args) {
        // Inizializzazione dello Scanner per l'input
        Scanner inputLettore = new Scanner(System.in);
        int numeroDaCalcolare = -1;

        System.out.println("Benvenuto nel Calcolatore di Fattoriale.");

        // Blocco per la gestione dell'input e dell'errore (InputMismatchException)
        try {
            System.out.print("Inserisci un numero intero non negativo per calcolare il suo fattoriale: ");
            numeroDaCalcolare = inputLettore.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Errore: Input non valido. Devi inserire un numero intero.");
            inputLettore.close();
            return;
        } finally {
            // Chiude lo scanner (assicura che venga chiuso anche in caso di eccezione)
            // L'ho lasciato fuori dal try per chiarezza, ma l'ho aggiunto alla fine.
        }

        // --- Logica di controllo e calcolo ---

        if (numeroDaCalcolare < 0) {
            // Gestione del caso in cui l'utente inserisce un numero negativo
            System.err.println("Errore: Il fattoriale non è definito per i numeri negativi.");
        } else if (numeroDaCalcolare == 0) {
            // Caso base: 0! = 1
            System.out.println("Il fattoriale di 0 è: 1");
        } else {
            // Inizializzazione del risultato
            // Usiamo BigInteger perché il fattoriale cresce molto velocemente (e.g., 20! è già troppo grande per un 'long')
            BigInteger risultatoFattoriale = BigInteger.ONE;

            // Ciclo for per il calcolo del fattoriale (n * (n-1) * ... * 1)
            for (int i = 1; i <= numeroDaCalcolare; i++) {
                // Moltiplica il risultato corrente per il valore di 'i'
                // Creiamo un nuovo BigInteger per la moltiplicazione
                risultatoFattoriale = risultatoFattoriale.multiply(BigInteger.valueOf(i));
            }

            // Stampa del risultato
            System.out.println("-----------------------------------------------------");
            System.out.println("Il fattoriale di " + numeroDaCalcolare + " (" + numeroDaCalcolare + "!) è: " + risultatoFattoriale);
            System.out.println("-----------------------------------------------------");
        }
        
        // Chiude lo scanner una volta terminato l'utilizzo
        inputLettore.close();
    }
}