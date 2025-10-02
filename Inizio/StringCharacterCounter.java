package com.gabry.stringanalyzer;

import java.util.Scanner;

public class StringCharacterCounter {

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int contatoreVocali = 0;
        int contatoreConsonanti = 0;
        
        System.out.println("--- Analizzatore di Stringhe ---");
        System.out.print("Inserisci una frase o una parola: ");
        
        // Lettura dell'intera linea di input dell'utente
        String inputOriginale = inputLettore.nextLine();
        
        // Convertiamo la stringa in minuscolo per semplificare il confronto delle vocali
        String stringaLavorazione = inputOriginale.toLowerCase(); 

        // Iterazione su ogni carattere della stringa
        for (int i = 0; i < stringaLavorazione.length(); i++) {
            char carattereCorrente = stringaLavorazione.charAt(i);

            // 1. Controlla se il carattere è una lettera dell'alfabeto
            if (carattereCorrente >= 'a' && carattereCorrente <= 'z') {
                
                // 2. Se è una lettera, controlla se è una vocale
                if (carattereCorrente == 'a' || carattereCorrente == 'e' || carattereCorrente == 'i' || 
                    carattereCorrente == 'o' || carattereCorrente == 'u') {
                    
                    contatoreVocali++;
                } else {
                    // 3. Altrimenti è una consonante
                    contatoreConsonanti++;
                }
            }
            // I caratteri non alfabetici (spazi, numeri, punteggiatura) vengono semplicemente ignorati
        }

        // Stampa dei risultati finali
        System.out.println("----------------------------------------");
        System.out.println("Stringa analizzata: \"" + inputOriginale + "\"");
        System.out.println("Risultati del conteggio:");
        System.out.println("Numero totale di Vocali (A, E, I, O, U): " + contatoreVocali);
        System.out.println("Numero totale di Consonanti: " + contatoreConsonanti);
        System.out.println("----------------------------------------");

        inputLettore.close();
    }
}