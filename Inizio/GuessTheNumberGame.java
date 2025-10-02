package com.gabry.guessthenumber;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        // Parametri del gioco
        final int MIN_NUMERO = 1;
        final int MAX_NUMERO = 100;
        
        // Inizializzazione degli oggetti necessari
        Scanner inputLettore = new Scanner(System.in);
        Random generatoreCasuale = new Random();
        
        // Generazione del numero segreto tra MIN_NUMERO e MAX_NUMERO (inclusi)
        // nextInt(MAX - MIN + 1) + MIN
        final int numeroSegreto = generatoreCasuale.nextInt(MAX_NUMERO - MIN_NUMERO + 1) + MIN_NUMERO;
        
        int tentativiEffettuati = 0;
        int indovinelloUtente = -1; // Inizializzato a un valore non valido
        boolean indovinato = false;

        System.out.println("----------------------------------------------");
        System.out.println("Benvenuto nel gioco 'Indovina il Numero'!");
        System.out.println("Sto pensando a un numero tra " + MIN_NUMERO + " e " + MAX_NUMERO + ".");
        System.out.println("Prova a indovinare qual è!");
        System.out.println("----------------------------------------------");

        // Ciclo principale del gioco: continua finché il numero non viene indovinato
        while (!indovinato) {
            System.out.print("Inserisci il tuo tentativo: ");
            
            try {
                // Legge l'input e incrementa il contatore
                indovinelloUtente = inputLettore.nextInt();
                tentativiEffettuati++;
                
                // Logica di confronto
                if (indovinelloUtente < MIN_NUMERO || indovinelloUtente > MAX_NUMERO) {
                    // Gestione di un numero fuori range, ma si conta come tentativo
                    System.out.println("Attenzione: Il numero deve essere tra " + MIN_NUMERO + " e " + MAX_NUMERO + ". Riprova!");
                } else if (indovinelloUtente < numeroSegreto) {
                    // Suggerimento: troppo basso
                    System.out.println("Sbagliato. Il numero segreto è più alto! ⬆️");
                } else if (indovinelloUtente > numeroSegreto) {
                    // Suggerimento: troppo alto
                    System.out.println("Sbagliato. Il numero segreto è più basso! ⬇️");
                } else {
                    // Vittoria!
                    indovinato = true;
                    System.out.println("----------------------------------------------");
                    System.out.println("CONGRATULAZIONI! Hai indovinato il numero!");
                    System.out.println("Il numero segreto era: " + numeroSegreto);
                    System.out.println("Ti ci sono voluti solo " + tentativiEffettuati + " tentativi!");
                    System.out.println("----------------------------------------------");
                }
            } catch (InputMismatchException e) {
                // Gestione di un input non numerico (es. l'utente digita una lettera)
                System.err.println("Errore: Input non valido. Devi inserire un numero intero.");
                // Consuma l'input non valido per evitare un loop infinito
                inputLettore.next(); 
            }
        }
        
        // Chiusura dello Scanner
        inputLettore.close();
    }
}