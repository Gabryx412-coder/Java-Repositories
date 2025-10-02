package com.gabry.temperatureconverter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConverter {

    // Costante per il punto di congelamento, utile per la documentazione interna
    private static final double FREEZING_POINT_CELSIUS = 0.0; 

    /**
     * Converte la temperatura da Celsius a Fahrenheit.
     * Formula: F = C * (9/5) + 32
     *
     * @param celsius La temperatura in gradi Celsius.
     * @return La temperatura in gradi Fahrenheit.
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Converte la temperatura da Fahrenheit a Celsius.
     * Formula: C = (F - 32) * (5/9)
     *
     * @param fahrenheit La temperatura in gradi Fahrenheit.
     * @return La temperatura in gradi Celsius.
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);
        int sceltaConversione = 0;
        double temperaturaIniziale = 0.0;
        double temperaturaFinale = 0.0;

        System.out.println("--- Convertitore di Temperatura ---");

        // Richiesta e validazione della scelta
        try {
            System.out.println("Scegli la direzione di conversione:");
            System.out.println("1: Celsius (C) -> Fahrenheit (F)");
            System.out.println("2: Fahrenheit (F) -> Celsius (C)");
            System.out.print("Inserisci 1 o 2: ");
            sceltaConversione = scannerInput.nextInt();
            
            if (sceltaConversione != 1 && sceltaConversione != 2) {
                System.err.println("Scelta non valida. Devi inserire 1 o 2.");
                scannerInput.close();
                return;
            }

            // Richiesta della temperatura
            System.out.print("Inserisci il valore della temperatura da convertire: ");
            temperaturaIniziale = scannerInput.nextDouble();
            
        } catch (InputMismatchException e) {
            System.err.println("Errore di Input: Assicurati di inserire numeri per la temperatura e 1 o 2 per la scelta.");
            scannerInput.close();
            return;
        }

        System.out.println("------------------------------------");

        // Esecuzione della conversione in base alla scelta dell'utente
        if (sceltaConversione == 1) {
            temperaturaFinale = celsiusToFahrenheit(temperaturaIniziale);
            System.out.printf("Temperatura iniziale: %.2f °C%n", temperaturaIniziale);
            System.out.printf("Temperatura convertita: %.2f °F%n", temperaturaFinale);
        } else if (sceltaConversione == 2) {
            temperaturaFinale = fahrenheitToCelsius(temperaturaIniziale);
            System.out.printf("Temperatura iniziale: %.2f °F%n", temperaturaIniziale);
            System.out.printf("Temperatura convertita: %.2f °C%n", temperaturaFinale);
        }

        System.out.println("------------------------------------");

        // Chiusura dello Scanner
        scannerInput.close();
    }
}