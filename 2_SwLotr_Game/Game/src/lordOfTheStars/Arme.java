package lordOfTheStars;
import lordOfTheStars.wars.*;
import lordOfTheStars.rings.*;

public class Arme extends Objet {
    private int puissance;
    private Personnage proprietaire;  // Le propriétaire de l'arme

    public Arme(String nom, double prix, int puissance) {
        super(nom, prix);
        this.puissance = puissance;
        this.proprietaire = null;  // Initialement, l'arme n'a pas de propriétaire
    }

    public Arme(int puissance) {
        super("genericWeapon", 0);
        this.puissance = puissance;
        this.proprietaire = null;  // Initialement, l'arme n'a pas de propriétaire
    }

    public void tirer(Cible cible) {
        // Vérifie si l'arme a un propriétaire et si la cible est différente du propriétaire
        if (proprietaire != null && cible != null && !cible.equals(proprietaire)) {
            cible.etreTouche(puissance);
        }
    }

    public void utiliserContre(Personnage cible) {
        if (this.proprietaire != null && cible != null && !this.proprietaire.equals(cible)) {
            cible.setPointsVie(cible.getPointsVie() - this.puissance);
        }
    }

    // Getters et Setters
    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public Personnage getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personnage proprietaire) {
        this.proprietaire = proprietaire;
    }
}

