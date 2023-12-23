package lordOfTheStars.rings;

import lordOfTheStars.Personnage;

import java.util.HashSet;
import java.util.Set;

public class Document extends Objet {
    private int connaissances;
    private Set<Personnage> lecteurs;

    public Document(String nom, double prix, int connaissances) {
        super(nom, prix);
        this.connaissances = connaissances;
        this.lecteurs = new HashSet<>();
    }

    public void lire(Personnage lecteur) {
        if (lecteur != null && !lecteurs.contains(lecteur)) {
            lecteur.setConnaissances(lecteur.getConnaissances() + this.connaissances);
            lecteurs.add(lecteur);
        }
    }

    // Getters et Setters
    public int getConnaissances() {
        return connaissances;
    }

    public void setConnaissances(int connaissances) {
        this.connaissances = connaissances;
    }
}

