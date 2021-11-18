import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;


enum Stichwort{
    HELLO,
    HI,
    NAME,
    ALTER,
    HERSTELLER,
    GESCHLECHT,
    GEBURTSDATUM,
    PUNKTE,
    UMFAHREN,
    ENDE;
}

public class Roboter extends Kreis{
    private int roboterGeschwindigkeitX = 0;
    private int roboterGeschwindigkeitY = 0;

    public Roboter() {
        super();
        setPosition(new Punkt(0,0));
        setBreite(10);
        setLaenge(10);
        setBezeichnung("RobotervonEmu");
        setFarbe(Color.BLACK);
        setDurchmesser(10);
        setMittelpunkt(new Punkt(this.getPosition().getX()+getDurchmesser()/2,this.getPosition().getY()+getDurchmesser()/2));
    }

    public void spacherkennung() {
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Bitte geben Sie eine Frage");
        String frage;
        while(eingabe.hasNext() &&
                !(frage = eingabe.next().toUpperCase()).equals("ENDE")) { //gross und kleinschreibung ist egal�
            //das Stichwort mit Groß- oder Kleinbuchs(taben geschrieben werden kann
            for(Stichwort sti : Stichwort.values()) {
                //Wenn mehrere Stichworte in der Frage enthalten sind
                switch(sti){
                    case HELLO:
                        if(frage.contains("HELLO")) {
                            System.out.println("HELLO!~ Ein schönes Tag!");
                        }
                        break;
                    case HI:
                        if(frage.contains("HI")) {
                            System.out.println("Hi!");
                        }
                        break;
                    case NAME:
                        if(frage.contains("NAME")) {
                            System.out.println("Mein Name ist vonEmu.");
                        }
                        break;
                    case ALTER:
                        if(frage.contains("ALTER")) {
                            System.out.println("Ich bin 1 Jahr alt.");
                        }
                        break;
                    case HERSTELLER:
                        if(frage.contains("HERSTELLER")) {
                            System.out.println("Ich bin von Nobody produziert.");
                        }
                        break;
                    case GESCHLECHT:
                        if(frage.contains("GESCHLECHT")) {
                            System.out.println("Ich bin ein Junge.");
                        }
                        break;
                    case UMFAHREN:
                        if(frage.contains("UMFAHREN")) {
                            //这个是规避障碍的方法
                            Spielfeld spielfeld = new Spielfeld();
                            ArrayList<Rechteck> rechtecks = spielfeld.hindernislisteErzeugen();
                            ArrayList<Punkt> punkts = new ArrayList<>();
                            Punkt punkt = new Punkt(0,0);
                            punkts.add(0,punkt);
                            spielfeld.zeichnen(rechtecks, this, punkts);
                            Spielfeld.hindernisseUmfahren();
                        }
                        break;
                    case PUNKTE:
                        if(frage.contains("PUNKTE")) {
                            //这个是调用最短路径的方法
                            Spielfeld s = new Spielfeld();
                            Rechteck rechteck = new Rechteck(new Punkt(400,400),0,0,"a", Color.BLACK);
                            ArrayList<Rechteck> rechtecks = new ArrayList<>();
                            rechtecks.add(0,rechteck);
                            s.zeichnen(rechtecks, this, s.poiSortieren(s.punkteEingeben()));
                            Spielfeld.kurzenWegabfahren();
                        }
                        break;
                    default:
                        System.out.println("Bitte auf korrekte Rechtschreibung achten!");
                        break;
                /* Verwenden Sie eine Switch-Case-Ver-zweigung,
                um dem gefundenen Stichwort
                eine zuvor von Ihnen festgelegte Antwort zuzuweisen*/
                }


            }

        }
    }
    public boolean anWand(int WandX, int WandY) {
        if (this.getPosition().getX()+this.getDurchmesser() >= WandX-15 || this.getPosition().getX() < 0
                || this.getPosition().getY()+this.getDurchmesser() >= WandY-35 || this.getPosition().getY() < 0) {
            return true;
        }
        return false;
    }

    public boolean zwischenX(Figur figur) {
        if(this.getMittelpunkt().getX() > figur.getPosition().getX()
                && this.getMittelpunkt().getX() < figur.getPosition().getX()+figur.getBreite()) {
            return true;
        }
        return false;
    }

    public int getRoboterGeschwindigkeitX(){
        return roboterGeschwindigkeitX;
    }

    public void setRoboterGeschwindigkeitX(int roboterGeschwindigkeitX){
        this.roboterGeschwindigkeitX = roboterGeschwindigkeitX;
    }

    public int getRoboterGeschwindigkeitY(){
        return roboterGeschwindigkeitY;
    }

    public void setRoboterGeschwindigkeitY(int roboterGeschwindigkeitY) {
        this.roboterGeschwindigkeitY = roboterGeschwindigkeitY;
    }

    public boolean ZuNah_rechte(Rechteck rechteck){ //ueberprueft, ob sich roboter an der rechten kante eines Hindernis befindet
        if(this.minX()<rechteck.maxX()){
            if(((rechteck.minX()-this.maxX()<5))
                    &((this.maxY()>rechteck.minY()
                    &this.maxY()<rechteck.maxY())
                    |(this.minY()>rechteck.minY()
                    &this.minY()<rechteck.maxY())
                    |(this.maxY()>rechteck.maxY()
                    &this.minY()<rechteck.minY()))){

                return true;
            }

            else{return false;}}
        else{return false;}
    }

    public boolean ZuNah_untere(Rechteck rechteck) {//ueberprueft, ob sich roboter an der unteren kante eines Hindernis befindet
        if (this.minY() < rechteck.maxY()) {
            if ((rechteck.minY() - this.maxY() < 5)
                    & ((this.maxX() > rechteck.minX()
                    & this.maxX() < rechteck.maxX())
                    | (this.minX() > rechteck.minX()
                    & this.minX() < rechteck.maxX())
                    | (this.maxX() > rechteck.maxX()
                    & this.minX() < rechteck.minX()))) {
                return true;
            }
        }
        return false;
    }

}