package lordOfTheStars.wars;

import lordOfTheStars.Personnage;

public class Heros extends Personnage {
    public Heros(String n, int x, int y, int v, int precision) {
        super(n, x, y, v, precision);
    }

    @Override
    public String parler() {
        {
            return "Je suis un Heros et je m'appelle " + nom;
        }
    }
}