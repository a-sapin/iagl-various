package lordOfTheStars.rings;

import lordOfTheStars.Personnage;

import java.util.ArrayList;
import java.util.List;

public class Humanoide extends Personnage {
    private List<Objet> inventaire;

    public Humanoide(String nom, int x, int y, int v, int coc) {
        super(nom, x, y, v, 50);
        this.inventaire = new ArrayList<>();
        this.connaissances=coc;
    }

    public void ramasserObjet(Objet objet) {
        inventaire.add(objet);
    }

    public void seSeparerDeObjet(Objet objet) {
        inventaire.remove(objet);
    }

    public void donnerObjet(Humanoide autreHumanoide, Objet objet) {
        if (inventaire.contains(objet)) {
            seSeparerDeObjet(objet);
            autreHumanoide.ramasserObjet(objet);
        }
    }

    // Implementer la méthode parler() héritée de Personnage
    @Override
    public String parler() {
        return "Je suis un Humanoide et je m'appelle " + nom;
    }

    // Reste des méthodes...
}

