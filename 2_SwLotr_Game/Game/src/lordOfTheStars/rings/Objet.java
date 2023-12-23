package lordOfTheStars.rings;

public class Objet {
    private String nom;
    private double prix;

    public Objet(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Méthode toString() pour afficher des informations sur l'objet
    @Override
    public String toString() {
        return "Objet{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}

