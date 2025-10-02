package com.gabry.fibonacci;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FibonacciSequence {

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int numeroTermini = 0;
        
        System.out.println("--- Calcolatore della Successione di Fibonacci ---");
        
        try {
            System.out.print("Quanti termini della sequenza di Fibonacci vuoi stampare? ");
            numeroTermini = inputLettore.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Errore di Input: Devi inserire un numero intero.");
            inputLettore.close();
            return;
        }

        if (numeroTermini < 1) {
            System.err.println("Il numero di termini deve essere almeno 1.");
            inputLettore.close();
            return;
        }

        stampaFibonacci(numeroTermini);

        inputLettore.close();
    }
    
    /**
     * Calcola e stampa i primi N termini della successione di Fibonacci.
     * @param N Il numero di termini da stampare.
     */
    private static void stampaFibonacci(int N) {
        // I primi due termini della sequenza sono 0 e 1
        long a = 0;
        long b = 1;
        long prossimoNumero;
        
        System.out.println("------------------------------------------");
        System.out.println("I primi " + N + " termini della sequenza sono:");

        if (N >= 1) {
            System.out.print(a);
        }
        
        if (N >= 2) {
            System.out.print(", " + b);
        }
        
        // Ciclo per calcolare i termini successivi
        for (int i = 3; i <= N; i++) {
            // Calcolo: prossimoNumero = a + b
            prossimoNumero = a + b;
            
            System.out.print(", " + prossimoNumero);
            
            // Aggiornamento dei valori per il prossimo ciclo
            a = b;
            b = prossimoNumero;
        }
        
        System.out.println("\n------------------------------------------");
        System.out.println("Nota: È stato usato 'long' per evitare overflow con numeri grandi.");
    }
}