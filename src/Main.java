import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Konto> konten = new ArrayList<>();

    public static void main(String[] args) {

        int auswahl;
        boolean menu = true;

        while (menu) {
            System.out.println("Menü");
            System.out.println("-1 Konto erstellen");
            System.out.println("-2 auszahlen");
            System.out.println("-3 einzahlen");
            System.out.println("-4 Kontodaten");
            System.out.println("-5 Programm beenden");
            auswahl = scanner.nextInt();
            switch (auswahl) {
                case 1:
                    int auswahl2;
                    System.out.println("Welches konto möchten Sie erstellen?" + "\n" + "1- Girokonto" + "\n" + "2- Sparkonto" + "\n" + "3- Kreditkonto");
                    auswahl2 = scanner.nextInt();
                    kontoerstellen(auswahl2);
            }

        }

    }

    private static void kontoerstellen(int auswahl2) {
        String kontoInhaber;
        String kontoNummer;
        int bankleitzahl;
        switch (auswahl2) {
            case 1:
                float limit;
                System.out.println("Wie heißt der Inhaber? ");
                kontoInhaber = scanner.next();
                System.out.println("Wie soll die Kontonummer sein? ");
                kontoNummer = scanner.next();
                System.out.println("Wie soll die Bankleitzahl sein?");
                bankleitzahl = scanner.nextInt();
                System.out.println("Wie hoch soll das limit sein? ");
                limit = scanner.nextFloat();
                Girokonto acc = new Girokonto(kontoInhaber, kontoNummer, bankleitzahl, limit);
                konten.add(acc);
                break;
            case 2:
                System.out.println("Wie heißt der Inhaber? ");
                kontoInhaber = scanner.next();
                System.out.println("Wie soll die Kontonummer sein? ");
                kontoNummer = scanner.next();
                System.out.println("Wie soll die Bankleitzahl sein?");
                bankleitzahl = scanner.nextInt();
                Sparkonto acc1 = new Sparkonto(kontoInhaber, kontoNummer, bankleitzahl);
                konten.add(acc1);
                break;

            case 3:
                System.out.println("Wie heißt der Inhaber? ");
                kontoInhaber = scanner.next();
                System.out.println("Wie soll die Kontonummer sein? ");
                kontoNummer = scanner.next();
                System.out.println("Wie soll die Bankleitzahl sein?");
                bankleitzahl = scanner.nextInt();
                Kreditkonto acc2 = new Kreditkonto(kontoInhaber, kontoNummer, bankleitzahl);
                konten.add(acc2);
        }
    }
}