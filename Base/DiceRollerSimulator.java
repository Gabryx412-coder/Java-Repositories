package com.gabry.diceroller;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DiceRollerSimulator {

    private static final int FACCE_DADO = 6;
    private static Random randomGenerator = new Random();

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int numeroDadi = 0;
        
        System.out.println("--- Simulazione Lancio di Dadi (D" + FACCE_DADO + ") ---");
        
        try {
            System.out.print("Quanti dadi vuoi lanciare? ");
            numeroDadi = inputLettore.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Errore di Input: Devi inserire un numero intero.");
            inputLettore.close();
            return;
        }

        if (numeroDadi <= 0) {
            System.err.println("Devi lanciare almeno un dado.");
            inputLettore.close();
            return;
        }

        lanciaDadi(numeroDadi);

        inputLettore.close();
    }

    /**
     * Simula il lancio del numero specificato di dadi e stampa i risultati.
     * @param numeroDadi Il numero di dadi da lanciare.
     */
    private static void lanciaDadi(int numeroDadi) {
        int totale = 0;
        
        System.out.println("----------------------------------------");
        System.out.println("Lancio di " + numeroDadi + " dadi...");
        
        // Ciclo per simulare ogni singolo dado
        for (int i = 1; i <= numeroDadi; i++) {
            // nextInt(N) genera un numero da 0 a N-1. Aggiungiamo 1 per avere da 1 a N.
            int risultatoLancio = randomGenerator.nextInt(FACCE_DADO) + 1; 
            
            System.out.println("Dado " + i + ": " + risultatoLancio);
            totale += risultatoLancio;
        }

        System.out.println("----------------------------------------");
        System.out.println("TOTALE COMPLESSIVO DEL LANCIO: " + totale);
        System.out.println("----------------------------------------");
    }
}