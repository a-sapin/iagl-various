import java.util.Random;

// Classe Drone
public class Drone extends VaisseauSpatial {
    private int precision;  // Précision intrinsèque du drone

    public Drone(int puissance, int blindage, int precision) {
        super(puissance, blindage);
        this.precision = precision;
    }

    public void tirer(Cible cible) {
        Random rand = new Random();
        if (rand.nextInt(100) < precision) {
            super.tirer(cible);  // Appelle la méthode tirer de la classe Arme
        }
    }

    // Getters et Setters pour la précision
    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }
}