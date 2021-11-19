import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    enum Antworten{ EINS,ZWEI,DREI,ENDE;}
    public static void main(String args[]) {

        /*个类怎样调用另一个类中的属性和方法


        一般来说会用两种最常用的方式
        new一个对象，通过对象来调用类中的变量和方法
        如果一个类的方法是静态的，那么直接用类名.方法的方式就可以调用*/
        /*//这个是规避障碍的方法
        Spielfeld spielfeld = new Spielfeld();
        ArrayList<Rechteck> rechtecks = spielfeld.hindernislisteErzeugen();
        ArrayList<Punkt> punkts = new ArrayList<>();
        Punkt punkt = new Punkt(0,0);
        punkts.add(0,punkt);
        spielfeld.zeichnen(rechtecks, this, punkts);
        Spielfeld.hindernisseUmfahren();*/

        /*//这个是调用最短路径的方法
        Spielfeld s = new Spielfeld();
        Roboter roboter = new Roboter();
        Rechteck rechteck = new Rechteck(new Punkt(400,400),0,0,"a", Color.BLACK);
        ArrayList<Rechteck> rechtecks = new ArrayList<>();
        rechtecks.add(0,rechteck);
        s.zeichnen(rechtecks, roboter, s.poiSortieren(s.punkteEingeben()));
        Spielfeld.kurzenWegabfahren();*/

        Scanner s = new Scanner(System.in);
        Spielfeld spielfeld = new Spielfeld();
        Roboter roboter = new Roboter();

        while(true){
            String antwort =new String();
            System.out.println("Hello!");
            System.out.println("Herzlich willkommen!");
            System.out.println("Für die Funktion : kurzenWegAbfahren bitten Sie mit 'EINS'");
            System.out.println("Für die Funktion : hindernisseUmfahren bitten Sie mit 'ZWEI'");
            System.out.println("Für die Eigenschaften des Roboter können Sie zuerst Eigenschaft dann ");
            System.out.println("NAME,ALTER,HERSTELLER,GESCHLECHT"+" -- "+"die Eigenschaft suchen.");
            System.out.println("ein schönes Tag!");
            String eingabe=s.nextLine().toUpperCase();
            if(eingabe.contains("ENDE")){
                System.exit(0);
            }

            for(Antworten  stichwort: Antworten.values()){ //ueberprueft den eingabesatz auf die stichwoerter
                if(eingabe.contains(stichwort.toString())){
                    antwort=stichwort.toString();
                }
            }
            switch(antwort){
                case "EINS":
                    spielfeld.reset();
                    System.out.println("Programm Eins wurde gewaehlt.");
                    Rechteck rechteck = new Rechteck(new Punkt(400,400),0,0,"a", Color.BLACK);
                    ArrayList<Rechteck> rechtecksEINS = new ArrayList<>();
                    rechtecksEINS.add(0,rechteck);
                    spielfeld.zeichnen(rechtecksEINS, roboter, spielfeld.poiSortieren(spielfeld.punkteEingeben()));
                    Spielfeld.kurzenWegabfahren();
                    break;

                case "ZWEI":
                    spielfeld.reset();
                    System.out.println("Programm Zwei wurde gewaehlt.");
                    ArrayList<Rechteck> rechtecksZWEI = spielfeld.hindernislisteErzeugen();
                    ArrayList<Punkt> punkts = new ArrayList<>();
                    Punkt punkt = new Punkt(0,0);
                    punkts.add(0,punkt);
                    spielfeld.zeichnen(rechtecksZWEI, roboter, punkts);
                    Spielfeld.hindernisseUmfahren();
                    break;

                case "DREI":
                    System.out.println("Programm Drei wurde gewaehlt.");
                    roboter.spacherkennung();
                    break;

                case "ENDE":
                    System.out.println("Programm wurde beendet.");
                    break;

                default:
                    System.out.println("Bitte auf korrekte Rechtschreibung achten!");
                    break;
            }
        }
    }
}
