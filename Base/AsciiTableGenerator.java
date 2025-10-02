package com.gabry.asciitable;

public class AsciiTableGenerator {

    // Limiti standard per i caratteri ASCII stampabili
    private static final int ASCII_START = 33; // Punto esclamativo '!'
    private static final int ASCII_END = 126;  // Tilde '~'

    public static void main(String[] args) {
        
        System.out.println("--- Generatore di Tabella ASCII (Caratteri Stampabili) ---");
        System.out.println("DEC | CAR | DEC | CAR | DEC | CAR");
        System.out.println("---------------------------------");
        
        int contatoreColonna = 0;

        // Ciclo che va dal valore decimale iniziale a quello finale
        for (int i = ASCII_START; i <= ASCII_END; i++) {
            // Conversione implicita da int a char
            char carattere = (char) i; 
            
            // Uso di printf per formattare e allineare le colonne
            System.out.printf("%3d | %3c ", i, carattere);
            
            contatoreColonna++;

            // Metti un a capo ogni 3 colonne
            if (contatoreColonna % 3 == 0) {
                System.out.println();
            } else {
                // Stampa un separatore se non è l'ultima colonna
                System.out.print("| ");
            }
        }
        
        System.out.println("\n---------------------------------");
    }
}