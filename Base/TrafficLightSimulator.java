package com.gabry.trafficlight;

import java.util.concurrent.TimeUnit;

public class TrafficLightSimulator {

    // Enumerazione per definire gli stati del semaforo
    private enum ColoreSemaforo {
        ROSSO("STOP. Non Attraversare.", 5),
        GIALLO("ATTENZIONE. Preparati a fermarti o partire.", 2),
        VERDE("VIA LIBERA. Attraversa con cautela.", 5);

        private final String messaggio;
        private final int durataSecondi;

        ColoreSemaforo(String messaggio, int durata) {
            this.messaggio = messaggio;
            this.durataSecondi = durata;
        }

        public String getMessaggio() {
            return messaggio;
        }

        public int getDurataSecondi() {
            return durataSecondi;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Simulazione Semaforo (Ciclo Automatico) ---");

        // Inizializza con il rosso
        ColoreSemaforo statoCorrente = ColoreSemaforo.ROSSO;
        int cicliEseguiti = 0;
        final int CICLI_MASSIMI = 3; // Esegui solo 3 cicli completi per non girare all'infinito

        while (cicliEseguiti < CICLI_MASSIMI) {
            
            System.out.println("\nSTATO: " + statoCorrente + " | MESSAGGIO: " + statoCorrente.getMessaggio());
            System.out.println("Attesa per " + statoCorrente.getDurataSecondi() + " secondi...");

            // Simula l'attesa (try-catch richiesto per Thread.sleep)
            try {
                // Aspetta i secondi specificati per ogni colore
                TimeUnit.SECONDS.sleep(statoCorrente.getDurataSecondi());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Logica di transizione usando switch-case
            switch (statoCorrente) {
                case ROSSO:
                    statoCorrente = ColoreSemaforo.VERDE;
                    break;
                case VERDE:
                    statoCorrente = ColoreSemaforo.GIALLO;
                    break;
                case GIALLO:
                    statoCorrente = ColoreSemaforo.ROSSO;
                    cicliEseguiti++; // Incrementa il contatore solo alla fine del ciclo completo
                    break;
            }
        }
        
        System.out.println("\nSimulazione terminata dopo " + CICLI_MASSIMI + " cicli.");
    }
}