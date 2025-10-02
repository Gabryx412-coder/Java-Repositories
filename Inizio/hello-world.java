package com.gabry.helloworld;

import java.util.Scanner;

public class SimpleInteractiveHelloWorld {

    public static void main(String[] args) {
        // Creazione di un oggetto Scanner per leggere l'input da tastiera
        Scanner tastieraInput = new Scanner(System.in);

        // Richiesta di input all'utente
        System.out.println("Inserisci il tuo nome qui sotto:");

        // Lettura della linea di testo inserita dall'utente
        String nomeUtente = tastieraInput.nextLine();

        // Stampa il saluto personalizzato
        System.out.println("Hello World, e un caloroso benvenuto a te, " + nomeUtente + "!");
        
        // Stampa un messaggio di chiusura
        System.out.println("L'esecuzione del programma 'SimpleInteractiveHelloWorld' è completata.");

        // Chiude l'oggetto Scanner per rilasciare le risorse
        tastieraInput.close();
    }
}