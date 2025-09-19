import java.text.BreakIterator;
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
            System.out.println("-5 Überweisen");
            System.out.println("-6 Konto löschen");
            System.out.println("-7 Programm beenden");
            auswahl = scanner.nextInt();
            int index;
            switch (auswahl) {
                case 1:
                    int auswahl2;
                    System.out.println("Welches konto möchten Sie erstellen?" + "\n" + "1- Girokonto" + "\n" + "2- Sparkonto" + "\n" + "3- Kreditkonto");
                    auswahl2 = scanner.nextInt();
                    kontoerstellen(auswahl2);
                    break;
                case 2:
                    index = kontoAuswahl();
                    if (index != -1) {
                        System.out.print("Betrag zum Abheben: ");
                        float betrag = scanner.nextFloat();
                        konten.get(index).Auszahlung(betrag);
                        System.out.println("Neuer Kontostand: " + konten.get(index).getKontostand());
                        break;
                    }
                    break;
                case 3:
                    index = kontoAuswahl();
                    if (index != -1) {
                        System.out.println("Betrag zum einzahlen: ");
                        float betrag = scanner.nextFloat();
                        konten.get(index).Einzahlung(betrag);
                        System.out.println("Neuer Kontostand " + konten.get(index).getKontostand());
                    }
                    break;
                case 4:
                    index = kontoAuswahl();
                    if (index != -1) {
                        System.out.println(konten.get(index));
                    }
                    break;
                case 5:
                    System.out.println("Von welchem Konto möchten Sie überweisen");
                    index = kontoAuswahl();
                    System.out.println("Auf welches Konto soll das Geld überwiesen werden?");
                    int index2 = kontoAuswahl();
                    if (index != -1 | index2 != -1) {
                        System.out.print("Betrag zum Überweisen: ");
                        float betrag = scanner.nextFloat();
                        konten.get(index).Auszahlung(betrag);
                        System.out.println("Neuer Kontostand: " + konten.get(index).getKontostand());
                        konten.get(index2).Auszahlung(betrag);
                        System.out.println("Neuer Kontostand: " + konten.get(index).getKontostand());
                        break;
                    }

                case 6:
                    index = kontoAuswahl();
                    konten.remove(index);
                    System.out.println("Konto wurde erfolgreich gelöscht");
                    break;

                case 7:
                    menu = false;
                    break;
            }
        }

    }

    private static void kontoerstellen(int auswahl2) {
        String kontoInhaber;
        String kontoArt;
        String kontoNummer;
        int bankleitzahl;
        switch (auswahl2) {
            case 1:
                kontoArt = "Girokonto";
                float limit;
                System.out.println("Wie heißt der Inhaber? ");
                kontoInhaber = scanner.next();
                System.out.println("Wie soll die Kontonummer sein? ");
                kontoNummer = scanner.next();
                System.out.println("Wie soll die Bankleitzahl sein?");
                bankleitzahl = scanner.nextInt();
                System.out.println("Wie hoch soll das limit sein? ");
                limit = scanner.nextFloat();
                Girokonto acc = new Girokonto(kontoInhaber, kontoNummer, bankleitzahl, limit, kontoArt);
                konten.add(acc);
                break;
            case 2:
                kontoArt = "sparKonto";
                System.out.println("Wie heißt der Inhaber? ");
                kontoInhaber = scanner.next();
                System.out.println("Wie soll die Kontonummer sein? ");
                kontoNummer = scanner.next();
                System.out.println("Wie soll die Bankleitzahl sein?");
                bankleitzahl = scanner.nextInt();
                Sparkonto acc1 = new Sparkonto(kontoInhaber, kontoNummer, bankleitzahl, kontoArt);
                konten.add(acc1);
                break;

            case 3:
                kontoArt = "Kreditkonto";
                System.out.println("Wie heißt der Inhaber? ");
                kontoInhaber = scanner.next();
                System.out.println("Wie soll die Kontonummer sein? ");
                kontoNummer = scanner.next();
                System.out.println("Wie soll die Bankleitzahl sein?");
                bankleitzahl = scanner.nextInt();
                Kreditkonto acc2 = new Kreditkonto(kontoInhaber, kontoNummer, bankleitzahl, kontoArt);
                konten.add(acc2);
        }
    }

    private static int kontoAuswahl() {
        if (konten.isEmpty()) {
            System.out.println("Keine Konten vorhanden!");
            return -1;
        }

        System.out.println("Bitte Konto auswählen:");
        for (int i = 0; i < konten.size(); i++) {
            System.out.println(i + " -> " + "Kontoinhaber: " + konten.get(i).getKontoInhaber() + " " + "Kontonummer: " + konten.get(i).getKontonummer());
        }

        System.out.print("Index eingeben: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= konten.size()) {
            System.out.println("Ungültige Auswahl!");
            return -1;
        }
        return index;
    }

}