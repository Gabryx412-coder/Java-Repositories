package com.gabry.login;

import java.util.Scanner;

public class ConsoleLoginSystem {

    // Array di utenti e password (simulazione di un database)
    private static final String[] USERNAMES = {"gabrydev", "admin", "user01"};
    private static final String[] PASSWORDS = {"pass123", "secureadmin", "utente"};
    
    // Tentativi massimi prima di bloccare
    private static final int MAX_TENTATIVI = 3;

    public static void main(String[] args) {
        Scanner inputLettore = new Scanner(System.in);
        int tentativiRimasti = MAX_TENTATIVI;
        boolean autenticato = false;

        System.out.println("--- Sistema di Login in Console ---");

        while (tentativiRimasti > 0 && !autenticato) {
            System.out.print("Username: ");
            String usernameInput = inputLettore.nextLine().trim();
            
            System.out.print("Password: ");
            String passwordInput = inputLettore.nextLine().trim();

            if (verificaCredenziali(usernameInput, passwordInput)) {
                autenticato = true;
                break;
            } else {
                tentativiRimasti--;
                System.err.println("Credenziali errate. Tentativi rimasti: " + tentativiRimasti);
                if (tentativiRimasti > 0) {
                    System.out.println("Riprova, Gabry.");
                }
            }
        }

        if (autenticato) {
            System.out.println("\n[✅ Accesso Eseguito con Successo!] Benvenuto nel sistema, " + ricercaNomeUtente(inputLettore) + ".");
        } else {
            System.err.println("\n[❌ Accesso Negato!] Hai esaurito i tentativi. Il sistema è stato bloccato.");
        }

        inputLettore.close();
    }
    
    /**
     * Verifica se la coppia username/password è presente negli array.
     * @param user L'username inserito.
     * @param pass La password inserita.
     * @return true se le credenziali sono corrette e corrispondono, false altrimenti.
     */
    private static boolean verificaCredenziali(String user, String pass) {
        for (int i = 0; i < USERNAMES.length; i++) {
            // Controlla se l'username e la password corrispondono nella stessa posizione dell'array
            if (USERNAMES[i].equals(user) && PASSWORDS[i].equals(pass)) {
                return true;
            }
        }
        return false;
    }
    
    // Funzione fittizia per mostrare come recuperare il nome utente dopo il login (non strettamente usata sopra)
    private static String ricercaNomeUtente(Scanner scanner) {
        // Logica fittizia per recuperare il nome vero se avessimo una struttura dati più complessa
        return "Amministratore"; 
    }
}