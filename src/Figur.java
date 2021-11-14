import java.awt.*;

public abstract class Figur{
    private Punkt position;
    private int breite;
    private int laenge;
    private String bezeichnung;
    private Color farbe;

    public Figur(Punkt position, int breite, int laenge, String bezeichnung, Color farbe){
        this.position = position;
        this.breite = breite;
        this.laenge = laenge;
        this.bezeichnung = bezeichnung;
        this.farbe = farbe;
    }

    public Figur() {

    }

    public Punkt getPosition() {
        return position;
    }

    public void setPosition(Punkt position) {this.position = position;}

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getLaenge() {return laenge;}

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Color getFarbe() {
        Color whiteBai = new Color(255,255,255);
        if(farbe.equals(whiteBai) || !(farbe == java.awt.Color.white)) {
            //改一下
            //System.out.println("die Farbe des Hintergrund und Rechteckist gleich.");
            return farbe;
        }
        return farbe;
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }

    public void bewegeUm(int dx, int dy) {
        position.setX(position.getX()+dx);
        position.setY(position.getY()+dy);
    }

    public void bewegeUm(Punkt verschiebevektor) {
        position.setX(position.getX()+verschiebevektor.getX());
        position.setY(position.getY()+verschiebevektor.getY());
    }

    public void ausgabeAttribute() {
        System.out.println(position.getX() + "," + position.getY());
        System.out.println(breite);
        System.out.println(laenge);
        System.out.println(farbe);
        System.out.println(bezeichnung);
    }



    abstract int minX();
    abstract int minY();
    abstract int maxX();
    abstract int maxY();
}
