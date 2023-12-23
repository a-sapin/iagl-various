package lordOfTheStars;
import lordOfTheStars.wars.*;
import lordOfTheStars.rings.*;

public class Main {
    public static void main(String[] args) {
        // Création d'un personnage Hero de Star Wars
        Personnage heroSW = new Heros("HeroSW", 0, 0, 10, 80);

        // Affichage des connaissances initiales du héros SW
        System.out.println("Connaissances initiales du héros SW: " + heroSW.getConnaissances());

        // Création d'un drone avec une précision de 50 (Star Wars)
        Drone drone = new Drone(100, 3, 50);

        // Création d'un vaisseau spatial ordinaire (Star Wars)
        VaisseauSpatial vaisseau = new VaisseauSpatial(200, 2);

        // Création de l'Étoile de la Mort (Star Wars)
        DeathStar etoileDeLaMort = DeathStar.getInstance(heroSW); // Le héros est le pilote

        // Création d'un personnage Pilote de Star Wars
        Personnage piloteSW = new Heros("PiloteSW", 1, 1, 8, 70);
        VaisseauPilote vaisseauPilote = new VaisseauPilote(300, 4, piloteSW);

        // Création d'un Troll (Seigneur des Anneaux)
        Troll troll = new Troll("Troll", 2, 2, 5, 50, 10);

        // Création d'un document (Seigneur des Anneaux)
        Document grimoire = new Document("Grimoire Ancien", 50, 20);

        // Simulation d'échanges de tirs et interactions
        System.out.println("Le drone tire sur le héros SW.");
        System.out.println("Points de vie du héros SW avant l'attaque du drone: " + heroSW.getPointsVie());
        drone.tirer(heroSW);
        System.out.println("Points de vie du héros SW après l'attaque du drone: " + heroSW.getPointsVie());

        // Le Troll attaque le vaisseau spatial (si la logique est implémentée)
        System.out.println("PV du vaisseau avant l'attaque :"+ vaisseau.getEtat());
        System.out.println("Le Troll attaque le vaisseau spatial.");
        troll.attaque(vaisseau); // Si vous avez une logique pour gérer cette interaction
        System.out.println("PV du vaisseau après l'attaque :"+ vaisseau.getEtat());

        // Le héros SW lit le grimoire et gagne des connaissances
        System.out.println("Le héros SW lit le grimoire et gagne des connaissances.");
        heroSW.ramasserObjet(grimoire);
        ((Document) grimoire).lire(heroSW);
        System.out.println("Connaissances du héros SW après avoir lu le grimoire: " + heroSW.getConnaissances());


        // Création de Gandalf, un Humanoide avec des connaissances élevées
        Humanoide gandalf = new Humanoide("Gandalf", 5, 5, 7, 1000);
        // Gandalf possède un haut niveau de connaissances

        // Création d'un fusil de style Star Wars
        Arme fusil = new Arme("Fusil StarWars", 500.0, 150);
        gandalf.equiperArme(fusil); // Gandalf équipe le fusil
        fusil.setProprietaire(gandalf);

        // Gandalf tire sur le Troll avec son fusil
        System.out.println("Gandalf tire sur le Troll avec son fusil.");
        System.out.println("Points de vie du Troll avant l'attaque de Gandalf: " + troll.getPointsVie());
        gandalf.utiliserArme(troll);
        System.out.println("Points de vie du Troll après l'attaque de Gandalf: " + troll.getPointsVie());

        System.out.println("Points de vie de Gandalf avant l'attaque de l'Etoile de la Mort: " + gandalf.getPointsVie());
        System.out.println("L'étoile de la mort tire sur Gandalf!");
        etoileDeLaMort.tirer(gandalf);
        System.out.println("Points de vie de Gandalf après l'attaque de l'Etoile de la Mort: " + gandalf.getPointsVie());

        // Autres interactions...
    }
}
