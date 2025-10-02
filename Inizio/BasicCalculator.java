package com.gabry.calcolatrice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        // Inizializzazione dello scanner per leggere l'input
        Scanner inputLettore = new Scanner(System.in);
        
        // Dichiarazione delle variabili per i numeri e l'operatore
        double numeroUno = 0.0;
        double numeroDue = 0.0;
        char operatoreMatematico;
        double risultatoFinale = 0.0;

        System.out.println("Benvenuto nella Calcolatrice Base.");
        System.out.println("Sono supportate solo le operazioni: +, -, *, /");

        try {
            // Ottenimento del primo numero
            System.out.print("Inserisci il primo numero: ");
            numeroUno = inputLettore.nextDouble();

            // Ottenimento dell'operatore
            System.out.print("Inserisci l'operatore (+, -, *, /): ");
            // Legge la prima lettera della riga successiva
            operatoreMatematico = inputLettore.next().charAt(0); 

            // Ottenimento del secondo numero
            System.out.print("Inserisci il secondo numero: ");
            numeroDue = inputLettore.nextDouble();

        } catch (InputMismatchException erroreInput) {
            // Gestione di un input non numerico (ad esempio, se l'utente inserisce una lettera al posto di un numero)
            System.err.println("Errore: Input non valido. Assicurati di inserire numeri per gli operandi.");
            // Uscita dal programma in caso di errore critico di input
            inputLettore.close();
            return; 
        }

        // Logica di calcolo basata sull'operatore scelto con una struttura switch
        switch (operatoreMatematico) {
            case '+':
                risultatoFinale = numeroUno + numeroDue;
                break;

            case '-':
                risultatoFinale = numeroUno - numeroDue;
                break;

            case '*':
                risultatoFinale = numeroUno * numeroDue;
                break;

            case '/':
                // Controllo essenziale per la divisione per zero
                if (numeroDue != 0) {
                    risultatoFinale = numeroUno / numeroDue;
                } else {
                    System.err.println("Errore matematico: Non è possibile dividere per zero!");
                    inputLettore.close();
                    return; // Interrompe il programma
                }
                break;

            default:
                // Gestione di un operatore non riconosciuto
                System.err.println("Errore: Operatore non valido. Usa solo +, -, *, /");
                inputLettore.close();
                return; // Interrompe il programma
        }

        // Stampa il risultato in un formato pulito
        System.out.println("------------------------------------");
        System.out.println("Il risultato di " + numeroUno + " " + operatoreMatematico + " " + numeroDue + " è: " + risultatoFinale);
        System.out.println("------------------------------------");

        // Chiude lo scanner per liberare le risorse
        inputLettore.close();
    }
}