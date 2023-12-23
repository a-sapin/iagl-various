package lordOfTheStars.wars;

import lordOfTheStars.Personnage;

import java.util.Random;

// Classe VaisseauPilote
public class VaisseauPilote extends VaisseauSpatial {
    private Personnage pilote;  // Le pilote du vaisseau

    public VaisseauPilote(int puissance, int blindage, Personnage pilote) {
        super(puissance, blindage);
        this.pilote = pilote;
    }

    public void tirer(Cible cible) {
        Random rand = new Random();
        if (pilote != null && rand.nextInt(100) < pilote.getPrecision()) {
            super.tirer(cible);  // Appelle la méthode tirer de la classe Arme
        }
    }

    // Getters et Setters pour le pilote
    public Personnage getPilote() {
        return pilote;
    }

    public void setPilote(Personnage pilote) {
        this.pilote = pilote;
    }
}