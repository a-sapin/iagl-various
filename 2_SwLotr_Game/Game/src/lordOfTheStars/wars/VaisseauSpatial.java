package lordOfTheStars.wars;

import lordOfTheStars.Arme;

public class VaisseauSpatial extends Arme implements Cible {
    private int etat;  // État du vaisseau de 100 (neuf) à 0 (détruit)
    private int blindage;  // Blindage du vaisseau de 1 à 5

    public VaisseauSpatial(int puissance, int blindage) {
        super(puissance);  // Appel au constructeur de la classe Arme
        this.blindage = blindage;
        this.etat = 100;  // État initial du vaisseau
    }

    // Implémentation de la méthode de l'interface Cible
    public void etreTouche(int degats) {
        this.etat -= degats / blindage;
        if (this.etat < 0) this.etat = 0;  // Éviter un état négatif
    }

    // Getters et Setters pour l'état et le blindage
    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getBlindage() {
        return blindage;
    }

    public void setBlindage(int blindage) {
        this.blindage = blindage;
    }

    // Autres méthodes nécessaires ...
}
