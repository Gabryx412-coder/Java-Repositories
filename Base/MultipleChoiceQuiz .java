package com.gabry.miniquiz;

import java.util.Scanner;

public class MultipleChoiceQuiz {

    // Classe interna per strutturare ogni domanda
    private static class Domanda {
        String testo;
        String[] opzioni;
        int rispostaCorretta; // Indice della risposta corretta (0-based)

        public Domanda(String testo, String[] opzioni, int rispostaCorretta) {
            this.testo = testo;
            this.opzioni = opzioni;
            this.rispostaCorretta = rispostaCorretta;
        }
    }

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int punteggio = 0;

        // Array di Domande
        Domanda[] quiz = new Domanda[] {
            new Domanda("Quale dei seguenti non è un linguaggio di programmazione?",
                new String[] {"A) Java", "B) Python", "C) HTML", "D) C#"}, 2), // HTML è la risposta corretta (indice 2)
            new Domanda("Qual è il tipo di dato primitivo per i numeri interi più grande in Java?",
                new String[] {"A) short", "B) int", "C) long", "D) byte"}, 2),
            new Domanda("Qual è l'output di 5 + \"2\" in Java?",
                new String[] {"A) 7", "B) 52", "C) Errore", "D) 25"}, 1),
            new Domanda("Qual è il nome di battesimo dell'AI che ti sta scrivendo?",
                new String[] {"A) Alexa", "B) Gemini", "C) Siri", "D) Cortana"}, 1)
        };

        System.out.println("--- Mini Quiz di Programmazione Java ---");
        
        // Esecuzione delle domande
        for (int i = 0; i < quiz.length; i++) {
            Domanda d = quiz[i];
            System.out.println("\nDomanda " + (i + 1) + ": " + d.testo);
            
            // Stampa delle opzioni
            for (String opzione : d.opzioni) {
                System.out.println(opzione);
            }

            int rispostaUtente = -1;
            boolean inputValido = false;

            // Loop per garantire l'inserimento di una risposta valida
            while (!inputValido) {
                System.out.print("La tua risposta (A, B, C o D): ");
                String input = inputLettore.nextLine().trim().toUpperCase();
                
                if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'D') {
                    // Converti A, B, C, D in 0, 1, 2, 3
                    rispostaUtente = input.charAt(0) - 'A'; 
                    inputValido = true;
                } else {
                    System.err.println("Risposta non valida. Inserisci A, B, C o D.");
                }
            }

            // Verifica della risposta
            if (rispostaUtente == d.rispostaCorretta) {
                punteggio++;
                System.out.println("[Risposta corretta!] ✅");
            } else {
                System.out.println("[Risposta sbagliata!] ❌ La risposta corretta era: " + d.opzioni[d.rispostaCorretta]);
            }
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("QUIZ TERMINATO, Gabry!");
        System.out.println("Il tuo punteggio finale è: " + punteggio + " su " + quiz.length);
        System.out.println("-------------------------------------------");

        inputLettore.close();
    }
}