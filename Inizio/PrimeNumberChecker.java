package com.gabry.primenumberchecker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumberChecker {

    /**
     * Controlla se il numero fornito è primo.
     * Un numero è primo se è maggiore di 1 e non ha divisori oltre 1 e se stesso.
     * L'efficienza è garantita dal controllo dei divisori solo fino alla radice quadrata del numero.
     * * @param numero Il numero intero da testare.
     * @return true se il numero è primo, false altrimenti.
     */
    public static boolean isPrime(int numero) {
        // I numeri minori o uguali a 1 non sono primi per definizione
        if (numero <= 1) {
            return false;
        }

        // Il 2 è l'unico numero primo pari
        if (numero == 2) {
            return true;
        }

        // Se il numero è pari (e maggiore di 2), non è primo
        if (numero % 2 == 0) {
            return false;
        }

        // Controlla i divisori dispari a partire da 3 fino alla radice quadrata del numero
        // Se un numero ha un fattore, ne ha uno minore o uguale alla sua radice quadrata
        int limiteMassimo = (int) Math.sqrt(numero);
        for (int i = 3; i <= limiteMassimo; i += 2) {
            if (numero % i == 0) {
                // Trovato un divisore, quindi il numero NON è primo
                return false;
            }
        }

        // Se nessun divisore è stato trovato, il numero è primo
        return true;
    }

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int numeroDaVerificare = 0;

        System.out.println("--- Verificatore di Numeri Primi ---");
        
        // Gestione dell'input
        try {
            System.out.print("Inserisci un numero intero positivo: ");
            numeroDaVerificare = inputLettore.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Errore di Input: Devi inserire un numero intero valido.");
            inputLettore.close();
            return;
        }

        System.out.println("----------------------------------------");

        // Chiamata al metodo di verifica e stampa del risultato
        if (isPrime(numeroDaVerificare)) {
            System.out.println("RISULTATO: Il numero " + numeroDaVerificare + " è un numero primo! 🎉");
        } else {
            System.out.println("RISULTATO: Il numero " + numeroDaVerificare + " non è un numero primo. 🙁");
        }

        System.out.println("----------------------------------------");

        inputLettore.close();
    }
}