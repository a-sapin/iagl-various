public class Arme {
    private int puissance;

    public Arme(int puissance) {
        this.puissance = puissance;
    }

    public void tirer(Cible cible) {
        cible.etreTouche(puissance);
    }
}