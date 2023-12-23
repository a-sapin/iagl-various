package tolkien;

public class Arme extends Objet {
    private int puissance;
    private Personnage proprietaire;  // Le propriétaire de l'arme

    public Arme(String nom, double prix, int puissance, Personnage proprietaire) {
        super(nom, prix);
        this.puissance = puissance;
        this.proprietaire = proprietaire;
    }

    public void utiliserContre(Personnage cible) {
        if (this.proprietaire.equals(cible)) {
            return; // Un personnage ne peut pas s'attaquer lui-même.
        }

        if (cible != null && this.proprietaire != null) {
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

