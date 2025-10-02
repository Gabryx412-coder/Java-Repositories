package com.gabry.stringreverser;

import java.util.Scanner;

public class StringReverser {

    /**
     * Inverte la stringa di input utilizzando il metodo reverse() di StringBuilder.
     * * @param stringaDaInvertire La stringa originale.
     * @return La stringa invertita.
     */
    public static String invertiStringa(String stringaDaInvertire) {
        // Creiamo un oggetto StringBuilder partendo dalla stringa data.
        StringBuilder sb = new StringBuilder(stringaDaInvertire);
        
        // Chiamiamo il metodo reverse(), che inverte la sequenza dei caratteri.
        sb.reverse();
        
        // Convertiamo il risultato finale da StringBuilder a String.
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        
        System.out.println("--- Invertitore di Stringhe ---");
        System.out.print("Inserisci la stringa che vuoi invertire: ");
        
        // Leggiamo l'intera linea di input
        String inputOriginale = inputLettore.nextLine();
        
        // Chiamiamo il metodo per l'inversione
        String stringaInvertita = invertiStringa(inputOriginale);

        System.out.println("----------------------------------------");
        System.out.println("Stringa originale: " + inputOriginale);
        System.out.println("Stringa invertita: " + stringaInvertita);
        System.out.println("----------------------------------------");

        inputLettore.close();
    }
}