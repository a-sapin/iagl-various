package tolkien;

public class Troll extends Personnage implements Monstre {
    private int force;
    private int puanteur;

    public Troll(String nom, int x, int y, int v, int force, int puanteur) {
        super(nom, x, y, v);
        this.force = force;
        this.puanteur = puanteur;
    }

    @Override
    public void attaque(Personnage p) {
        // Un troll n'attaque pas un autre troll
        if (p instanceof Troll) {
            return;
        }

        // Réduction des points de vie de la cible
        int degats = this.force + (this.puanteur / 10);
        p.setPointsVie(p.getPointsVie() - degats);
    }

    @Override
    public int getPuanteur() {
        return puanteur;
    }

    // Méthode parler() héritée de Personnage
    @Override
    public String parler() {
        return "Je suis un Troll et je m'appelle " + nom;
    }

    // Getters et Setters pour force et puanteur
    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setPuanteur(int puanteur) {
        this.puanteur = puanteur;
    }

    // Méthode seDeplacer() héritée et autres méthodes de Personnage...
}
