public class DeathStar extends VaisseauPilote {
    private static DeathStar instance;  // Unique instance de l'Étoile de la Mort

    // Le constructeur est privé pour empêcher l'instanciation directe
    private DeathStar(Personnage pilote) {
        super(1000, 5, pilote);  // Puissance de 1000 et blindage de 5
    }

    // Méthode pour obtenir l'instance de l'Étoile de la Mort
    public static DeathStar getInstance(Personnage pilote) {
        if (instance == null) {
            instance = new DeathStar(pilote);
        }
        return instance;
    }

    // Autres méthodes spécifiques à DeathStar si nécessaire ...

    // Override de méthodes si nécessaire pour un comportement spécifique
}
