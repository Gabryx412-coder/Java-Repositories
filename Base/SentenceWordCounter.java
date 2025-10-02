package com.gabry.wordcounter;

import java.util.Scanner;

public class SentenceWordCounter {

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);

        System.out.println("--- Contatore di Parole in una Frase ---");
        System.out.print("Inserisci la frase o il testo da analizzare: ");
        
        // Leggiamo l'intera linea di input
        String fraseInput = inputLettore.nextLine();

        // --- Logica di Conteggio ---
        
        // 1. Rimuovi spazi iniziali/finali
        String frasePulita = fraseInput.trim(); 
        
        int numeroParole = 0;
        
        if (frasePulita.isEmpty()) {
            // Caso in cui l'utente inserisce solo spazi o nulla
            numeroParole = 0;
        } else {
            // 2. Dividi la stringa usando gli spazi come delimitatore
            // La regex "\\s+" indica uno o più spazi consecutivi, gestendo quindi gli spazi doppi
            String[] parole = frasePulita.split("\\s+");
            
            // 3. Il numero di parole è la lunghezza dell'array risultante
            numeroParole = parole.length;
        }

        System.out.println("----------------------------------------");
        System.out.println("Frase analizzata: \"" + fraseInput + "\"");
        System.out.println("Numero di parole contate: " + numeroParole);
        System.out.println("----------------------------------------");

        inputLettore.close();
    }
}