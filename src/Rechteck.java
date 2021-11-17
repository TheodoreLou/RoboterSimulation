
import java.awt.Color;
import java.security.cert.PKIXRevocationChecker;
import java.util.ArrayList;


public class Rechteck extends Figur{

    public Rechteck() {
        super();
    }

    public Rechteck(Punkt position, int breite, int laenge, String bezeichnung, Color farbe) {
        super(position,breite,laenge,bezeichnung,farbe);
    }

    public Punkt getEckeRechtsUnten() {
        return new Punkt(this.getPosition().getX()+getBreite(),this.getPosition().getY()+getLaenge());
    }

    public Punkt getEckeLinksUnten() {
        return new Punkt(this.getPosition().getX(),this.getPosition().getY()+getLaenge());
    }

    public Punkt getEckeRechtsOben() {
        return new Punkt(this.getPosition().getX()+getBreite(), this.getPosition().getY());
    }

    public Punkt getEckeLinksOben() {
        return new Punkt(this.getPosition().getX(), this.getPosition().getY());
    }

    public boolean ueberlappt (ArrayList<Rechteck> rechteckArrayList) {
        //如果后面障碍物出现重叠或粘滞，则回这里找问题。
        //已解决，使用方法：投影法
        //Projektion
        // https://leetcode-cn.com/problems/rectangle-overlap/solution/tu-jie-jiang-ju-xing-zhong-die-wen-ti-zhuan-hua-we/
        boolean ueberlapptResult = false;
        for(Rechteck rechteck : rechteckArrayList){
            boolean ueberlapptAufX = !(this.maxX()<rechteck.minX()||rechteck.maxX()<this.minX());
            boolean ueberlapptAufY = !(this.maxY()<rechteck.minY()||rechteck.maxY()<this.minY());
            if (ueberlapptAufX || ueberlapptAufY) {
            ueberlapptResult = true;}
        }
        return ueberlapptResult;
    }

    public int minX() {
        return this.getPosition().getX();
    }

    public int minY() {
        return this.getPosition().getY();
    }

    public int maxX() {
        return this.getPosition().getX()+getBreite();
    }

    public int maxY() {
        return this.getPosition().getY()+getLaenge();
    }


    /*
    Punkt position;
    int breite;
    int laenge;
    String bezeichnung;
    Color farbe;

    public Rechteck() {
        position = new Punkt(2,2);
        breite = 5;
        laenge = 5;
        bezeichnung = "Test";
        farbe = new Color(255,255,255);
    }

    public Rechteck(Punkt position, int breite, int laenge, String bezeichnung, Color farbe) {
        this.position = position;
        this.breite = breite;
        this.laenge = laenge;
        this.bezeichnung = bezeichnung;
        this.farbe = farbe;
    }

    public Punkt getPosition() {
        return position;
    }

    public void setPosition(Punkt position) {
        this.position = position;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getLaenge() {
        return laenge;
    }

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
            System.out.println("die Farbe des Hintergrund und Rechteckist gleich.");
            return farbe;
        }
        return farbe;
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }

    public void bewegeUm(int dx, int dy) {
        position.setX(dx);
        position.setY(dy);
    }

    public void bewegeUm(Punkt verschiebevektor) {
        position.setX(verschiebevektor.getX());
        position.setY(verschiebevektor.getY());
    }

        public void ausgabeAttribute()
    {
        System.out.println(position.getX()+","+position.getY());
        System.out.println(breite);
        System.out.println(laenge);
        System.out.println(farbe);
        System.out.println(bezeichnung);
        //die Koordinaten des aktuellen Punkts
        //geben auf der Konsole aus
    }

    public boolean ueberlappt (Rechteck r) {
        //如果后面障碍物出现重叠或粘滞，则回这里找问题。
        boolean thisLeft    = (r.position.getX() - this.position.getX()) > this.position.getX();
        boolean thisUp      = (r.position.getY() - this.position.getY()) > this.position.getY();
        if ((thisLeft &&
                r.position.getX() > (this.position.getX() + this.breite)) ||
                (thisUp && r.position.getY() > (this.position.getY() + this.laenge))
                        && (r.position.getX()+r.getBreite() < this.position.getX()+r.getBreite())
                        && (r.position.getY()+r.getLaenge() < this.position.getY()+r.getLaenge()))
        {
            return false;
        }
        else if((!thisLeft && this.position.getX() > (r.position.getX() + r.breite))
                || (!thisUp && this.position.getY() > (r.position.getY() + r.laenge))) {
            return false;
        }
        else {
            return true;
        }
    }
    */
}
