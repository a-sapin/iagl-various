package lordOfTheStars;

import lordOfTheStars.wars.*;
import lordOfTheStars.rings.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Personnage implements Cible {
    protected String nom;
    protected int pointsVie, x, y, v, precision, connaissances;
    protected Arme arme;  // Attribut pour l'arme
    protected List<Objet> inventaire;  // Liste pour stocker les objets

    public Personnage(String nom, int x, int y, int v, int precision) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.v = v;
        this.pointsVie = 100;
        this.precision = precision;
        this.connaissances = 0;  // Initialisation des connaissances
        this.inventaire = new ArrayList<Objet>();

    }

    public void ramasserObjet(Objet objet) {
        if (objet != null) {
            this.inventaire.add(objet);
        }
    }

    public void lacherObjet(Objet objet) {
        this.inventaire.remove(objet);
    }

    // Méthodes existantes ...

    // Implémentation de la méthode de l'interface Cible
    public void etreTouche(int degats) {
        this.pointsVie -= degats;
        if (this.pointsVie < 0) this.pointsVie = 0;
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

    // Getters et Setters pour la précision, les points de vie, et les connaissances
    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }

    public int getConnaissances() {
        return connaissances;
    }

    public void setConnaissances(int connaissances) {
        this.connaissances = connaissances;
    }

    public void seDeplacer(int dx, int dy, int t) {
        // Implémentation de la méthode de déplacement
    }

    // Méthode parler() abstraite à implémenter dans les sous-classes
    public abstract String parler();
}
