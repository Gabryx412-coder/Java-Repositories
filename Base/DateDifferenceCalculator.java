package com.gabry.datecalculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateDifferenceCalculator {

    // Formato di input/output comune per l'utente
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        LocalDate dataUno = null;
        LocalDate dataDue = null;

        System.out.println("--- Calcolatore di Giorni tra Due Date ---");
        System.out.println("Formato richiesto: YYYY-MM-DD (es. 2025-01-20)");

        // Ciclo per ottenere la prima data valida
        dataUno = leggiDataValida(inputLettore, "Inserisci la prima data (inizio): ");
        if (dataUno == null) {
            inputLettore.close();
            return;
        }

        // Ciclo per ottenere la seconda data valida
        dataDue = leggiDataValida(inputLettore, "Inserisci la seconda data (fine): ");
        if (dataDue == null) {
            inputLettore.close();
            return;
        }

        // Calcolo della differenza in giorni
        long giorniDiDifferenza = ChronoUnit.DAYS.between(dataUno, dataDue);

        System.out.println("-------------------------------------------------");
        System.out.println("Data Inizio: " + dataUno.format(FORMATTER));
        System.out.println("Data Fine:   " + dataDue.format(FORMATTER));
        System.out.println("La differenza tra le due date è di: " + Math.abs(giorniDiDifferenza) + " giorni.");
        System.out.println("-------------------------------------------------");

        inputLettore.close();
    }
    
    /**
     * Legge una data dall'utente e tenta di parsificarla nel formato specificato.
     * @param scanner L'oggetto Scanner.
     * @param prompt Il messaggio da mostrare all'utente.
     * @return L'oggetto LocalDate parsificato, o null in caso di fallimento critico.
     */
    private static LocalDate leggiDataValida(Scanner scanner, String prompt) {
        LocalDate data = null;
        boolean inputValido = false;
        
        while (!inputValido) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            
            try {
                // Tenta di parsificare la stringa in un LocalDate
                data = LocalDate.parse(input, FORMATTER);
                inputValido = true;
            } catch (Exception e) {
                System.err.println("Errore nel formato data. Usa YYYY-MM-DD.");
            }
        }
        return data;
    }
}