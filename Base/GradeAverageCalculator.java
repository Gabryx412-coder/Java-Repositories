package com.gabry.schoolaveragecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeAverageCalculator {

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        // Usiamo List<Double> (ArrayList) perché non sappiamo quanti voti l'utente inserirà.
        List<Double> listaVoti = new ArrayList<>();
        double votoCorrente;
        boolean continuaInserimento = true;

        System.out.println("--- Calcolatore di Media Voti Scolastici ---");
        System.out.println("Inserisci i voti uno alla volta. Digita '0' o una lettera/parola per terminare.");
        System.out.println("---------------------------------------------");

        // Ciclo principale per l'inserimento dei voti
        while (continuaInserimento) {
            System.out.print("Inserisci un voto (o '0' per calcolare la media): ");
            
            if (inputLettore.hasNextDouble()) {
                votoCorrente = inputLettore.nextDouble();
                
                // Un voto 0 può essere interpretato come stop
                if (votoCorrente == 0) {
                    continuaInserimento = false;
                } else if (votoCorrente < 1 || votoCorrente > 10) {
                    // Controllo sul range dei voti (assumendo una scala 1-10)
                    System.err.println("Voto non valido. Inserisci un voto tra 1 e 10.");
                } else {
                    listaVoti.add(votoCorrente);
                    System.out.println("[Voto " + votoCorrente + " aggiunto.]");
                }
            } else {
                // Se l'input non è un double (es. l'utente digita "fine" o una lettera)
                continuaInserimento = false; 
                inputLettore.next(); // Consuma l'input non valido
            }
        }
        
        System.out.println("---------------------------------------------");

        // Calcolo e stampa della media
        calcolaEScattaMedia(listaVoti);

        inputLettore.close();
    }

    /**
     * Calcola la media aritmetica dei voti e stampa il risultato finale.
     * @param voti La lista dei voti inseriti.
     */
    private static void calcolaEScattaMedia(List<Double> voti) {
        // Se non è stato inserito nessun voto, gestiamo il caso
        if (voti.isEmpty()) {
            System.out.println("Nessun voto inserito. La media non può essere calcolata.");
            return;
        }

        double sommaTotale = 0.0;
        
        // Calcolo della somma di tutti i voti
        for (double voto : voti) {
            sommaTotale += voto;
        }

        int numeroVoti = voti.size();
        // Calcolo della media: Somma / Numero di voti
        double media = sommaTotale / numeroVoti;

        System.out.println("Voti inseriti: " + numeroVoti);
        System.out.println("Somma totale dei voti: " + String.format("%.2f", sommaTotale));
        // Stampiamo il risultato finale formattato a due cifre decimali
        System.out.println("LA MEDIA ARITMETICA DEI VOTI È: " + String.format("%.2f", media));
        
        // Breve valutazione didattica
        if (media >= 6.0) {
            System.out.println("Complimenti, Gabry! Media sufficiente. 🎉");
        } else {
            System.out.println("Media insufficiente. C'è bisogno di un piccolo sforzo in più. 💪");
        }
    }
}