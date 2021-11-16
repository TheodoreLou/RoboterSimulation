import java.util.ArrayList;
import java.util.*;
import java.awt.Color;

public class Spielfeld {

    static final int spielBreite = 800;
    static final int spielLaenge = 800;
    private Punkt[] poi;
    private ArrayList<Punkt> poiOrigi = new ArrayList<>();
    private static ArrayList<Punkt> poiSort = new ArrayList<>();
    private static ArrayList<Rechteck> hindernisListe;
    private static Roboter roboter;
    private static Leinwand leinwand;


    public Spielfeld() {
        roboter = new Roboter();
        leinwand = new Leinwand(spielLaenge,spielBreite,Color.white);
    }
    /*
    Erstellen Sie die Methode Punkt[] punkteEingeben(). Der Benutzer soll zunaechst
    ueber die Konsole eingeben, wie viele Punkte er haben moechte. Anschliessend soll er die Koordinaten der Punkte
    eingeben.
    Die Punkte werden in einem Array gespeichert, das als Rueckgabewert der Methode zurueckgegeben wird.
    Zu Beginn soll sich der Roboter in der linken oberen Ecke des Spielfelds befinden, d.h. der
    Punkt (0,0) ist der erste Punkt des Arrays
    Mit der Methode nextInt() koennen Sie die Koordinaten eines Punktes
    als einzelne Ganzzahlwerte einlesen.
    Alle eingegebenen Punkte muessen im Spielfeld liegen. Machen Sie den Benutzer darauf aufmerksam, wenn er einen
    ungueltigen Wert eingibt.
    Gehen Sie in dieser Uebung davon aus, dass
    der Benutzer nur ganze Zahlen eingibt, aber keine Buchstaben oder Sonderzeichen.
    */

    public Punkt[] punkteEingeben() {
        int zahl;
        Scanner poizahl = new Scanner(System.in);
        try {
            System.out.println("Bitte geben Sie ein Ganzzahl für die Punkte des Weg von Roboter.");
            zahl = poizahl.nextInt();
            poi = new Punkt[zahl + 1];
            poi[0] = new Punkt(0, 0);
            Scanner x = new Scanner(System.in);
            Scanner y = new Scanner(System.in);
            System.out.println("Bitte geben Sie den ersten Punkt~");
            for (int i = 1; i < zahl + 1; i++) {
                Punkt p = new Punkt(x.nextInt(), y.nextInt());
                poi[i] = p;
                System.out.println("der " + i + ". Punkt ist: ");
                poi[i].ausgabeAttribute();
            }
        }catch(InputMismatchException e){//The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
            System.out.println("Bitten Sie daher nur Ganzzahlen eingeben! \n" + e);
            System.exit(0);
        }

        return poi;
    }
    /*
    ich habe dager eine index und Arraylist benutzt
    um die Punkte einfacher zu sortieren.
    Methode:Bubblesort
    */

    public ArrayList<Punkt> poiSortieren(Punkt[] poi) {
        for(int i = 0; i<poi.length;i++){
            poiOrigi.add(i, poi[i]);
        }
        poiSort.add(poiOrigi.remove(0));
        while (!poiOrigi.isEmpty()) {
            int min_idx = -1;
            double dis = Integer.MAX_VALUE;
            for (int i = 0; i < poiOrigi.size(); i++) {
                if (poiSort.get(poiSort.size() - 1).gibAbstand(poiOrigi.get(i)) < dis) {
                    dis = poiSort.get(poiSort.size() - 1).gibAbstand(poiOrigi.get(i));
                    min_idx = i;

                }
            }
            poiSort.add(poiOrigi.remove(min_idx));
        }
        for (int i = 0; i < poiSort.size(); i++) {
            System.out.println(poiSort.get(i).getX() + " : " + poiSort.get(i).getY());
        }
        return poiSort;
    }
    /*
     * Methode poiAbfahren(), in der der Benutzer zunaechst
     * die Punkte eingeben kann und anschliessend der kuerzeste Weg berechnet wird
     */
    public double poiAbfahren() {
        double ganzDistanz = 0;
        for (int i = 1; i < poiSort.size(); i++) {
            ganzDistanz += poiSort.get(i).gibAbstand(poiSort.get(i - 1));
        }
        System.out.println(ganzDistanz);
        return ganzDistanz;
    }


    public ArrayList<Rechteck> hindernislisteErzeugen() {
        /*Daher habe ich ein "künstliche Index" erstellt.
           denn das braucht man gleichzeiitig zwei for-Schleife ausführen
           Eins ist für Hindernisse, die Andere ist für die Urteilung,
           ob es überlappt ist.*/
        int hinderX;
        int hinderY;
        Punkt hinderPosition;
        int hinderBreite;
        int hinderLaenge;
        Color hinderFarbe;
        String hinderBezeichnung;
        hindernisListe = new ArrayList<Rechteck>();
        int hindernisZahl = 0;
        int arrayIndex = 0;//man muss daher noch ein index zu schaffen.
        int arrayUeberlapptIndex = 0;
        int maximalHindernisZahl = 500;
        try {
            Scanner h = new Scanner(System.in);//mittels scanner ueber Konsole werte zuweisen
            System.out.println("die Hindersniszahl ist " + h);
            hindernisZahl = h.nextInt();
            if(hindernisZahl > maximalHindernisZahl) {
                System.out.println("diese Zahl ist mehr als maximale Hinderniszahl");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Bitee ein Ganzzahl eingeben" + e);
            System.exit(0);
        }

        while(arrayIndex < hindernisZahl) {

            hinderX = zufallszahl(5, spielBreite-100);
            hinderY = zufallszahl(5, spielLaenge-100);
            hinderBreite = zufallszahl(50, 100);
            hinderLaenge = zufallszahl(50, 100);
            hinderPosition = new Punkt(hinderX, hinderY);
            hinderFarbe = zufallsfarbe();
            hinderBezeichnung = "Rechteck" + String.valueOf(arrayIndex+1);
            Rechteck r = new Rechteck(hinderPosition, hinderBreite, hinderLaenge,hinderBezeichnung, hinderFarbe);

            while( arrayUeberlapptIndex < hindernisListe.size() &&
                    !(r.ueberlappt(hindernisListe.get(arrayUeberlapptIndex)))){
                arrayUeberlapptIndex ++;
            }
            if(arrayUeberlapptIndex == hindernisListe.size()){
                hindernisListe.add(r);
                r.ausgabeAttribute();
                arrayIndex ++;
                arrayUeberlapptIndex = 0;
            }
        }
        System.out.println("Es wird "+ hindernisListe.size() +" Hindernisse erzeugt");
        return hindernisListe;
    }
    /*
    * Diese Methoden erzeugen eine zufaellige Anzahl an Rechtecken, in zufaelligen Farben und ueberpruefen die
    Ueberlappung dieser.
    */
    public int zufallszahl(int von, int bis) {
        Random r = new Random();
        return r.nextInt(bis - von) + 1;
    }

    public Color zufallsfarbe() {
        Color farbe = new Color(zufallszahl(1,254),zufallszahl(1,254), zufallszahl(1,254));
        return farbe;
    }

    public void zeichnen(ArrayList<Rechteck> hindernisListe,Roboter roboter,ArrayList<Punkt> poiSort) {
        this.roboter = roboter;
        leinwand.zeichnen(hindernisListe,roboter,poiSort);
    }

    /*
     * Der Roboter soll sich zu Beginn oben links
     * auf dem Spielfeld befinden und sich schrittweise nach unten und nach rechts bis zum
     * Spielfeldrand bewegen. Dabei soll er dieHindernisse umfahren.
     * Falls die Hindernisse so eng bei einander stehen,
     * dass der Roboter nicht zwischen ihnen hindurch fahren
     * kann, soll er stehen bleiben.
     */

    public static void hindernisseUmfahren() {
        /*
       die Method daher ist;
       ich habe in dem Klass Roboter ein "int" heißt Geschwindigkeit geschafft
       Und Mit die Veränderung von Geschwindigkeit von verschiedene Sitiation um
       die Hindernisse umzufahren.*/
        roboter.setRoboterGeschwindigkeitX(1);
        roboter.setRoboterGeschwindigkeitY(1);
        if (roboter.maxX() < 780 & roboter.maxY() < 750) {
            for (Rechteck rechteck : hindernisListe) {
                if (roboter.ZuNah_untere(rechteck) || roboter.getPosition().getY() > 750) {
                    roboter.setRoboterGeschwindigkeitY(0);
                } else if (roboter.ZuNah_rechte(rechteck) ||
                        roboter.getPosition().getX() > 780) {
                    roboter.setRoboterGeschwindigkeitX(0);
                } else if (roboter.ZuNah_rechte(rechteck) && roboter.ZuNah_untere(rechteck)
                        || roboter.getPosition().getY() > 750 && roboter.getPosition().getX() > 780) {
                    roboter.setRoboterGeschwindigkeitX(0);
                    roboter.setRoboterGeschwindigkeitY(0);
                }
            }
            roboter.setPosition(new Punkt(    roboter.getPosition().getX() + roboter.getRoboterGeschwindigkeitX(),
                    roboter.getPosition().getY() + roboter.getRoboterGeschwindigkeitY()));
        }

    }

    public static void kurzenWegabfahren() {
        //diese Method ist noch problematisch
        //Es gibt noch ein "BUG"; wenn 2 Punkte auf eine gleich Achse ligen, dann wird das Roboter nocht mehr bewegen.
        //Ich weiß wahrscheinlich,dass das Problem von Richten ist.
        roboter.setRoboterGeschwindigkeitX(1);
        roboter.setRoboterGeschwindigkeitY(1);
        //die Meinung von dieser Methode ist; denn die kleinest Zahl von natürliche Ganzzahl ist 1.
        //So muss ich mit "1' bearbeiten. 1 und 0,damit ich alle richtung und schaffen soll.
        //wenn ich habe andere Chance, werder ich alle Dinge als "float" oder "double" variieren..:(
        //denn das kann man die Richtung besser steuern.
        if (roboter.maxX() < 780 & roboter.maxY() < 750) {
            for (int i = 1;i<poiSort.size();i++) {
                if(roboter.getPosition().getX()-poiSort.get(i).getX() == 0){
                    if(roboter.getPosition().getY()>poiSort.get(i).getY()){
                        roboter.setRoboterGeschwindigkeitY(-1);
                    }
                    roboter.setRoboterGeschwindigkeitX(0);
                }
                if(roboter.getPosition().getY()-poiSort.get(i).getY() == 0){
                    if(roboter.getPosition().getX()>poiSort.get(i).getX()){
                        roboter.setRoboterGeschwindigkeitX(-1);
                    }
                    roboter.setRoboterGeschwindigkeitY(0);
                }
                if(roboter.getPosition().getX()-poiSort.get(i).getX() == 0
                        && roboter.getPosition().getY()-poiSort.get(i).getY() == 0
                        && roboter.getPosition().gibAbstand(poiSort.get(poiSort.size()-1))!=0 ){
                    // 4 Richtung:Linksoben,linksunten,rechtsoben,rechtsunten
                    if(roboter.getPosition().getX()>poiSort.get(i+1).getX()&&
                            roboter.getPosition().getY()>poiSort.get(i+1).getY()){
                        roboter.setRoboterGeschwindigkeitX(-1);
                        roboter.setRoboterGeschwindigkeitY(-1);
                    }//linksoben
                    else if(roboter.getPosition().getX()>poiSort.get(i+1).getX()&&
                            roboter.getPosition().getY()<poiSort.get(i+1).getY()){
                        roboter.setRoboterGeschwindigkeitX(-1);
                        roboter.setRoboterGeschwindigkeitY(1);
                    }//linksunten
                    else if(roboter.getPosition().getX()<poiSort.get(i+1).getX()&&
                            roboter.getPosition().getY()>poiSort.get(i+1).getY()){
                        roboter.setRoboterGeschwindigkeitX(1);
                        roboter.setRoboterGeschwindigkeitY(-1);
                    }//rechtsoben
                    else if(roboter.getPosition().getX()<poiSort.get(i+1).getX()&&
                            roboter.getPosition().getY()<poiSort.get(i+1).getY()){
                        roboter.setRoboterGeschwindigkeitX(1);
                        roboter.setRoboterGeschwindigkeitY(1);
                    }
                    //4 Linie:links,rechts,oben,unten
                    else if(roboter.getPosition().getX()==poiSort.get(i+1).getX()&&
                            roboter.getPosition().getY()<poiSort.get(i+1).getY()){
                        roboter.setRoboterGeschwindigkeitX(0);
                        roboter.setRoboterGeschwindigkeitY(1);
                    }
                    else if(roboter.getPosition().getX()==poiSort.get(i+1).getX()&&
                            roboter.getPosition().getY()>poiSort.get(i+1).getY()){
                        roboter.setRoboterGeschwindigkeitX(0);
                        roboter.setRoboterGeschwindigkeitY(-1);
                    }
                    else if(roboter.getPosition().getX()>poiSort.get(i+1).getX()&&
                            roboter.getPosition().getY()==poiSort.get(i+1).getY()){
                        roboter.setRoboterGeschwindigkeitX(-1);
                        roboter.setRoboterGeschwindigkeitY(0);
                    }
                    else if(roboter.getPosition().getX()<poiSort.get(i+1).getX()&&
                            roboter.getPosition().getY()==poiSort.get(i+1).getY()){
                        roboter.setRoboterGeschwindigkeitX(1);
                        roboter.setRoboterGeschwindigkeitY(0);
                    }
                }
                if(roboter.getPosition().getX()-poiSort.get(i).getX() == 0
                        &&roboter.getPosition().getY()-poiSort.get(i).getY() == 0
                        &&roboter.getPosition().gibAbstand(poiSort.get(poiSort.size()-1))==0){
                    roboter.setRoboterGeschwindigkeitX(0);
                    roboter.setRoboterGeschwindigkeitY(0);
                }
            }
            roboter.setPosition(new Punkt(roboter.getPosition().getX()+roboter.getRoboterGeschwindigkeitX(),
                    roboter.getPosition().getY()+roboter.getRoboterGeschwindigkeitY()));
        }
    }
}





