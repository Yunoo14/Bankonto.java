public class Kreditkonto extends Konto {

    Kreditkonto(String kontoInhaber, String kontonummer, int bankleitzahl) {
        super(kontoInhaber, kontonummer, bankleitzahl);
    }

    @Override
    public void Auszahlung(float amount) {
        setKontostand(getKontostand() - amount);
    }

    @Override
    public void Einzahlung(float amount) {
        if (getKontostand() + amount < 0) {
            setKontostand(getKontostand() + amount);
        } else {
            System.out.println("Error");
        }

    }
}
