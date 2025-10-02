package com.gabry.tablesprinter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplicationTablePrinter {

    // Definiamo il limite massimo della tabellina
    private static final int MOLTIPLICATORE_MASSIMO = 10; 

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int numeroUtente = 0;

        System.out.println("--- Stampante di Tabelline ---");
        
        // Blocco try-catch per gestire l'input non numerico
        try {
            System.out.print("Inserisci il numero intero di cui vuoi stampare la tabellina: ");
            numeroUtente = inputLettore.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Errore di Input: Devi inserire un numero intero valido.");
            inputLettore.close();
            return;
        }

        System.out.println("----------------------------------------");
        System.out.println("Tabellina del numero " + numeroUtente + ":");
        
        // Ciclo for che va da 1 al MOLTIPLICATORE_MASSIMO (10)
        for (int i = 1; i <= MOLTIPLICATORE_MASSIMO; i++) {
            // Calcolo del prodotto
            int risultato = numeroUtente * i;
            
            // Stampa della singola riga nel formato: Numero x Moltiplicatore = Risultato
            System.out.println(numeroUtente + " x " + i + " = " + risultato);
        }

        System.out.println("----------------------------------------");
        
        // Chiusura dello Scanner
        inputLettore.close();
    }
}