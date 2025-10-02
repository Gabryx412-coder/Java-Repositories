package com.gabry.rockpaperscissors;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    // Costanti per mappare le scelte
    private static final int SASSO = 1;
    private static final int CARTA = 2;
    private static final int FORBICE = 3;
    
    // Oggetti riutilizzabili per input e casualità
    private static Scanner inputLettore = new Scanner(System.in);
    private static Random randomGenerator = new Random();

    public static void main(String[] args) {
        
        int sceltaUtente = 0;
        int sceltaComputer;
        
        System.out.println("--- GIOCO: CARTA, FORBICE, SASSO ---");

        // Loop principale del gioco
        do {
            stampaMenuScelta();
            
            try {
                sceltaUtente = inputLettore.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Input non valido. Inserisci un numero tra 1 e 4.");
                inputLettore.next(); // Consuma l'input errato
                sceltaUtente = 0;
                continue; // Ritorna all'inizio del loop
            }

            if (sceltaUtente == 4) {
                System.out.println("Partita terminata. Arrivederci!");
                break;
            } else if (sceltaUtente < 1 || sceltaUtente > 3) {
                System.out.println("Scelta non riconosciuta. Inserisci 1, 2, 3 o 4.");
                continue;
            }

            // Generazione della mossa casuale del computer
            // nextInt(3) genera un numero tra 0 e 2. Aggiungiamo 1 per avere 1, 2, o 3.
            sceltaComputer = randomGenerator.nextInt(3) + 1; 

            System.out.println("----------------------------------------");
            System.out.println("La tua scelta: " + getNomeScelta(sceltaUtente));
            System.out.println("Scelta del computer: " + getNomeScelta(sceltaComputer));
            System.out.println("----------------------------------------");

            // Determina e stampa il risultato
            determinaVincitore(sceltaUtente, sceltaComputer);
            
            System.out.println("========================================\n");
            
        } while (true); 

        inputLettore.close();
    }
    
    /**
     * Stampa il menu delle opzioni per l'utente.
     */
    private static void stampaMenuScelta() {
        System.out.println("\nFai la tua mossa:");
        System.out.println(SASSO + " - Sasso 🪨");
        System.out.println(CARTA + " - Carta 📄");
        System.out.println(FORBICE + " - Forbice ✂️");
        System.out.println("4 - Esci dal gioco");
        System.out.print("La tua scelta (1-4): ");
    }
    
    /**
     * Traduce il codice numerico della scelta nel nome testuale.
     * @param codiceScelta Il codice numerico (1, 2 o 3).
     * @return La stringa corrispondente alla scelta.
     */
    private static String getNomeScelta(int codiceScelta) {
        switch (codiceScelta) {
            case SASSO:
                return "Sasso";
            case CARTA:
                return "Carta";
            case FORBICE:
                return "Forbice";
            default:
                return "Sconosciuta";
        }
    }

    /**
     * Contiene la logica del gioco e determina il vincitore.
     * @param utente La scelta dell'utente (1, 2 o 3).
     * @param computer La scelta del computer (1, 2 o 3).
     */
    private static void determinaVincitore(int utente, int computer) {
        // Caso di pareggio
        if (utente == computer) {
            System.out.println("RISULTATO: PARI! Riprova. 🤝");
            return;
        }

        String risultato;

        // Logica per determinare la vittoria
        // Carta (2) batte Sasso (1)
        // Sasso (1) batte Forbice (3)
        // Forbice (3) batte Carta (2)
        switch (utente) {
            case SASSO: // Utente ha Sasso
                risultato = (computer == FORBICE) ? "HAI VINTO! Sasso batte Forbice." : "HAI PERSO. Carta batte Sasso.";
                break;
            case CARTA: // Utente ha Carta
                risultato = (computer == SASSO) ? "HAI VINTO! Carta batte Sasso." : "HAI PERSO. Forbice batte Carta.";
                break;
            case FORBICE: // Utente ha Forbice
                risultato = (computer == CARTA) ? "HAI VINTO! Forbice batte Carta." : "HAI PERSO. Sasso batte Forbice.";
                break;
            default:
                risultato = "Errore nella logica di gioco.";
                break;
        }
        
        System.out.println("RISULTATO: " + risultato);
    }
}