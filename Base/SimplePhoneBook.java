package com.gabry.phonebook;

import java.util.Scanner;

public class SimplePhoneBook {

    // Dimensione massima fissa della rubrica (limitazione tipica degli array)
    private static final int MAX_CONTACTS = 5; 

    // Array paralleli per memorizzare nomi e numeri
    private static String[] nomi = new String[MAX_CONTACTS];
    private static String[] numeri = new String[MAX_CONTACTS];

    // Contatore per tenere traccia di quanti contatti sono stati effettivamente aggiunti
    private static int contatoreContatti = 0;

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int sceltaMenu;

        System.out.println("--- Rubrica Telefonica Semplice (Max " + MAX_CONTACTS + " contatti) ---");

        // Ciclo principale del menu
        do {
            stampaMenu();
            
            try {
                sceltaMenu = inputLettore.nextInt();
                inputLettore.nextLine(); // Consuma il carattere newline
            } catch (Exception e) {
                System.err.println("Errore di input. Inserisci un numero valido (1-4).");
                inputLettore.nextLine(); // Consuma input errato
                sceltaMenu = 0; // Forza la ripetizione del ciclo
                continue;
            }

            switch (sceltaMenu) {
                case 1:
                    aggiungiContatto(inputLettore);
                    break;
                case 2:
                    visualizzaContatti();
                    break;
                case 3:
                    cercaContatto(inputLettore);
                    break;
                case 4:
                    System.out.println("Uscita dalla rubrica. Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (sceltaMenu != 4);

        inputLettore.close();
    }

    /**
     * Stampa le opzioni del menu principale.
     */
    private static void stampaMenu() {
        System.out.println("\nCosa vuoi fare?");
        System.out.println("1. Aggiungi Contatto");
        System.out.println("2. Visualizza Tutti i Contatti");
        System.out.println("3. Cerca Contatto per Nome");
        System.out.println("4. Esci");
        System.out.print("Inserisci la tua scelta: ");
    }

    /**
     * Aggiunge un nuovo contatto agli array, se c'è spazio.
     * @param scanner L'oggetto Scanner per l'input.
     */
    private static void aggiungiContatto(Scanner scanner) {
        if (contatoreContatti < MAX_CONTACTS) {
            System.out.print("Inserisci il Nome del contatto: ");
            String nome = scanner.nextLine();
            System.out.print("Inserisci il Numero di telefono: ");
            String numero = scanner.nextLine();

            // Assegna i valori alla posizione attuale
            nomi[contatoreContatti] = nome;
            numeri[contatoreContatti] = numero;
            
            // Incrementa il contatore per il prossimo inserimento
            contatoreContatti++; 
            System.out.println("\n[✅ Contatto " + nome + " aggiunto con successo!]");
        } else {
            System.err.println("\n[❌ Errore: Rubrica piena! Non è possibile aggiungere più di " + MAX_CONTACTS + " contatti.]");
        }
    }

    /**
     * Stampa tutti i contatti presenti nella rubrica.
     */
    private static void visualizzaContatti() {
        if (contatoreContatti == 0) {
            System.out.println("\n[ℹ️ La rubrica è vuota. Aggiungi un contatto per visualizzarlo.]");
            return;
        }

        System.out.println("\n--- ELENCO CONTATTI (" + contatoreContatti + " totali) ---");
        // Cicla solo fino al numero di contatti effettivamente aggiunti
        for (int i = 0; i < contatoreContatti; i++) {
            System.out.println((i + 1) + ". Nome: " + nomi[i] + " | Numero: " + numeri[i]);
        }
        System.out.println("-------------------------------------");
    }

    /**
     * Cerca un contatto per nome e stampa il risultato.
     * @param scanner L'oggetto Scanner per l'input.
     */
    private static void cercaContatto(Scanner scanner) {
        System.out.print("Inserisci il nome da cercare: ");
        String nomeCercato = scanner.nextLine().trim(); // Trim per pulizia
        boolean trovato = false;
        
        System.out.println("--- RISULTATI RICERCA ---");
        
        // Cicla solo sui contatti presenti
        for (int i = 0; i < contatoreContatti; i++) {
            // Confronta il nome (ignorando la distinzione tra maiuscole/minuscole per una ricerca più comoda)
            if (nomi[i].equalsIgnoreCase(nomeCercato)) { 
                System.out.println("Trovato! Nome: " + nomi[i] + " | Numero: " + numeri[i]);
                trovato = true;
                break; // Usciamo dal ciclo appena troviamo il primo risultato
            }
        }

        if (!trovato) {
            System.out.println("Nessun contatto trovato con il nome: '" + nomeCercato + "'");
        }
        System.out.println("-------------------------");
    }
}