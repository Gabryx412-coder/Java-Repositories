package com.gabry.minicalendar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleMiniAgenda {

    private static List<String> eventi = new ArrayList<>();

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int scelta;

        System.out.println("--- Mini Agenda Console ---");

        do {
            stampaMenu();
            
            try {
                scelta = inputLettore.nextInt();
                inputLettore.nextLine(); // Consuma newline
            } catch (InputMismatchException e) {
                System.err.println("Input non valido. Inserisci un numero tra 1 e 4.");
                inputLettore.nextLine();
                scelta = 0;
                continue;
            }

            switch (scelta) {
                case 1:
                    aggiungiEvento(inputLettore);
                    break;
                case 2:
                    visualizzaEventi();
                    break;
                case 3:
                    rimuoviEvento(inputLettore);
                    break;
                case 4:
                    System.out.println("Chiusura agenda. Ciao, Gabry!");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 4);
        
        inputLettore.close();
    }
    
    private static void stampaMenu() {
        System.out.println("\nCosa vuoi fare?");
        System.out.println("1. Aggiungi Evento");
        System.out.println("2. Visualizza Eventi");
        System.out.println("3. Rimuovi Evento (per indice)");
        System.out.println("4. Esci");
        System.out.print("Scelta (1-4): ");
    }
    
    private static void aggiungiEvento(Scanner scanner) {
        System.out.print("Inserisci la descrizione dell'evento (es. Riunione 10:00): ");
        String descrizione = scanner.nextLine().trim();
        
        if (!descrizione.isEmpty()) {
            eventi.add(descrizione);
            System.out.println("[✅ Evento aggiunto! Totale eventi: " + eventi.size() + "]");
        } else {
            System.out.println("[❌ Descrizione evento non valida.]");
        }
    }
    
    private static void visualizzaEventi() {
        if (eventi.isEmpty()) {
            System.out.println("\n[ℹ️ L'agenda è vuota.]");
            return;
        }

        System.out.println("\n--- ELENCO EVENTI ---");
        // Gli indici partono da 1 per l'utente, ma l'array parte da 0
        for (int i = 0; i < eventi.size(); i++) {
            System.out.println((i + 1) + ". " + eventi.get(i)); 
        }
        System.out.println("---------------------");
    }
    
    private static void rimuoviEvento(Scanner scanner) {
        if (eventi.isEmpty()) {
            System.out.println("\n[ℹ️ L'agenda è vuota. Nessun elemento da rimuovere.]");
            return;
        }
        
        visualizzaEventi(); // Mostra l'elenco prima di chiedere quale rimuovere
        
        try {
            System.out.print("Inserisci il numero dell'evento da rimuovere (es. 1): ");
            int indiceDaRimuovere = scanner.nextInt();
            
            // L'utente inserisce 1, 2, 3... ma l'array usa 0, 1, 2...
            int indiceArray = indiceDaRimuovere - 1; 

            if (indiceArray >= 0 && indiceArray < eventi.size()) {
                String eventoRimosso = eventi.remove(indiceArray);
                System.out.println("[✅ Evento rimosso: " + eventoRimosso + "]");
            } else {
                System.err.println("[❌ Indice non valido. Devi inserire un numero tra 1 e " + eventi.size() + ".]");
            }
            scanner.nextLine(); // Consuma newline
        } catch (InputMismatchException e) {
            System.err.println("[❌ Input non valido. Inserisci un numero intero.]");
            scanner.nextLine();
        }
    }
}