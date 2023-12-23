package tolkien;

public abstract class Personnage {
    protected String nom;
    protected int pointsVie, connaissances, x, y, v;

    public Personnage(String n, int x, int y, int v) {
        this.nom = n;
        this.x = x;
        this.y = y;
        this.pointsVie = 100;
        this.connaissances = 0;
        this.v = v;
    }

    public int getPointsVie() {
        return this.pointsVie;
    }

    public void setPointsVie(int pv) {
        this.pointsVie = pv;
    }

    public int getConnaissances() {
        return this.connaissances;
    }

    public void setConnaissances(int co) {
        this.connaissances = co;
    }

    public void seDeplacer(int dx, int dy, int t) {
        // ...
    }

    public abstract String parler();
}
