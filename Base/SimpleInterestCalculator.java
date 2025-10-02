package com.gabry.interestcalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleInterestCalculator {

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        double capitaleIniziale = 0.0;
        double tassoPercentuale = 0.0;
        int anni = 0;
        boolean inputValido = false;

        System.out.println("--- Calcolatore di Interessi Semplici ---");

        // Cicli per ottenere input validi
        try {
            System.out.print("Inserisci il Capitale iniziale (es. 1000.00): ");
            capitaleIniziale = inputLettore.nextDouble();

            System.out.print("Inserisci il Tasso di interesse annuale (es. 5.5 per 5.5%): ");
            tassoPercentuale = inputLettore.nextDouble();

            System.out.print("Inserisci il Numero di anni di investimento: ");
            anni = inputLettore.nextInt();
            
            inputValido = true;
        } catch (InputMismatchException e) {
            System.err.println("Errore di Input: Assicurati di inserire numeri validi e interi per gli anni.");
            inputLettore.close();
            return;
        }
        
        // Verifica valori non negativi
        if (inputValido && (capitaleIniziale < 0 || tassoPercentuale < 0 || anni < 0)) {
            System.err.println("Errore: I valori devono essere non negativi.");
            inputLettore.close();
            return;
        }

        // --- Logica di Calcolo ---
        // Formula Interesse Semplice: Interesse = Capitale * Tasso * Tempo
        
        // Converti il tasso da percentuale a decimale (es. 5.5% -> 0.055)
        double tassoDecimale = tassoPercentuale / 100.0;
        
        // Calcolo dell'interesse totale maturato
        double interesseTotale = capitaleIniziale * tassoDecimale * anni;
        
        // Calcolo del Montante finale (Capitale + Interesse)
        double montanteFinale = capitaleIniziale + interesseTotale;

        System.out.println("-------------------------------------------------");
        System.out.println("Capitale Iniziale:        " + String.format("€ %.2f", capitaleIniziale));
        System.out.println("Tasso Annuale:            " + String.format("%.2f %%", tassoPercentuale));
        System.out.println("Durata (Anni):            " + anni);
        System.out.println("-------------------------------------------------");
        System.out.println("Interesse Totale Matura:  " + String.format("€ %.2f", interesseTotale));
        System.out.println("MONTANTE FINALE:          " + String.format("€ %.2f", montanteFinale));
        System.out.println("-------------------------------------------------");

        inputLettore.close();
    }
}