public abstract class Personnage implements Cible {
    protected String nom;
    protected int pointsVie, x, y, v, precision;
    protected Arme arme;  // Nouvel attribut pour l'arme

    public Personnage(String n, int x, int y, int v, int precision) {
        this.nom = n;
        this.x = x;
        this.y = y;
        this.pointsVie = 100;
        this.v = v;
        this.precision = precision;
    }

    // Méthodes existantes ...

    // Implémentation de la méthode de l'interface Cible
    public void etreTouche(int degats) {
        this.pointsVie -= degats;
        if (this.pointsVie < 0) this.pointsVie = 0;  // Éviter les points de vie négatifs
    }

    // Méthodes pour gérer l'arme
    public void equiperArme(Arme arme) {
        this.arme = arme;
    }

    public void utiliserArme(Cible cible) {
        if (arme != null) {
            arme.tirer(cible);
        }
    }

    // Getters et Setters pour la précision
    public int getPrecision() {
        return precision;
    }

    public int getPointsVie() {
        return this.pointsVie;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }
}