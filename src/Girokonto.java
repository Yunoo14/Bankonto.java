public class Girokonto extends Konto {
    private float limit;

   Girokonto(String kontoInhaber, String kontonummer, int bankleitzahl, float limit, String kontoArt) {
    super(kontoInhaber, kontonummer, bankleitzahl, kontoArt);
    this.limit = limit;
   }


    @Override
    public void Auszahlung(float amount) {
        if (getKontostand() - amount < -limit) {
            System.out.println("Limit überzogen!");
        } else {
            setKontostand(getKontostand() - amount);
            System.out.println("Abhebung wurde durchgeführt");
        }
    }
}
