public class Main {
    public static void main(String[] args) {
        // Création d'un personnage
        Personnage hero = new Heros("Hero", 0, 0, 10, 80);

        // Création d'un drone avec une précision de 50
        Drone drone = new Drone(100, 3, 50);

        // Création d'un vaisseau spatial ordinaire
        VaisseauSpatial vaisseau = new VaisseauSpatial(200, 2);

        // Création de l'Étoile de la Mort
        DeathStar etoileDeLaMort = DeathStar.getInstance(hero); // Le héros est le pilote

        // Création d'un autre personnage qui pilotera un vaisseau
        Personnage pilote = new Heros("Pilote", 1, 1, 8, 70);
        VaisseauPilote vaisseauPilote = new VaisseauPilote(300, 4, pilote);

        // Simulation d'échanges de tirs
        System.out.println("Le drone tire sur le héros.");
        drone.tirer(hero);
        System.out.println("Points de vie du héros après l'attaque du drone: " + hero.getPointsVie());

        System.out.println("L'Étoile de la Mort tire sur le vaisseau piloté.");
        etoileDeLaMort.tirer(vaisseauPilote);
        System.out.println("État du vaisseau piloté après l'attaque de l'Étoile de la Mort: " + vaisseauPilote.getEtat());

        System.out.println("Le vaisseau spatial ordinaire tire sur le drone.");
        vaisseau.tirer(drone);
        // Le drone n'a pas d'état à afficher, étant un simple Arme

        System.out.println("Le vaisseau piloté tire sur le héros.");
        vaisseauPilote.tirer(hero);
        System.out.println("Points de vie du héros après l'attaque du vaisseau piloté: " + hero.getPointsVie());
    }
}
