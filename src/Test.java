import java.awt.*;
import java.util.ArrayList;

public class Test {
    public static void main(String args[]) {
        //System.out.println("Hello World!");
        /*Punkt punkt1 = new Punkt(1,1);
        Punkt punkt2 = new Punkt(2,2);
        punkt1.ausgabeAttribute();*/
        /*double abstand = punkt1.gibAbstand(punkt2);
        System.out.println(abstand);*/
        /*Rechteck r = new Rechteck();
        r.ausgabeAttribute();
        r.getFarbe();*/
        /*Spielfeld s = new Spielfeld();
        s.punkteEingeben(3);
        s.poiSortieren();
        s.poiAbfahren();
        s.zufallszahl(1,100);
        s.zufallsfarbe();
        s.hindernislisteErzeugen();*/
        /*个类怎样调用另一个类中的属性和方法


        一般来说会用两种最常用的方式
        new一个对象，通过对象来调用类中的变量和方法
        如果一个类的方法是静态的，那么直接用类名.方法的方式就可以调用*/
        /*Roboter roboter = new Roboter();
        roboter.spacherkennung();*/
        /*Leinwand leinwand;
        leinwand = new Leinwand(100,100, Color.white);
        System.out.println("1");
        leinwand.warten(300);
        System.out.println("2");
        leinwand.makeFrame();*/;
   /*     Roboter roboter = new Roboter();
        roboter.setPosition(new Punkt(100,100));
        roboter.ausgabeAttribute();*/
  /*      Spielfeld s = new Spielfeld();
        Roboter roboter = new Roboter();
        Punkt[] punkten = s.punkteEingeben();
        ArrayList<Punkt> poiSort = s.poiSortieren(punkten);
        for(Punkt punkt : poiSort){
            punkt.ausgabeAttribute();
        }
        s.roboterFahren();
        s.zeichnen(s.hindernislisteErzeugen(), roboter , poiSort);*/
        /*Punkt p1 = new Punkt(5,5);
        Rechteck r1 = new Rechteck(p1,20,20,"a",Color.green);
        r1.ausgabeAttribute();
        Punkt p2 = new Punkt(5,5);
        Rechteck r2 = new Rechteck(p2,50,50,"b",Color.red);
        r2.ausgabeAttribute();
        boolean u = r1.ueberlappt(r2);
        System.out.println(u);*/
        //System.out.println("Hello World!");
        /*Punkt punkt1 = new Punkt(1,1);
        Punkt punkt2 = new Punkt(2,2);
        punkt1.ausgabeAttribute();*/
        /*double abstand = punkt1.gibAbstand(punkt2);
        System.out.println(abstand);*/
        /*Rechteck r = new Rechteck();
        r.ausgabeAttribute();
        r.getFarbe();*/
        /*Spielfeld s = new Spielfeld();
        s.punkteEingeben(3);
        s.poiSortieren();
        s.poiAbfahren();
        s.zufallszahl(1,100);
        s.zufallsfarbe();
        s.hindernislisteErzeugen();*/

        /*Roboter roboter = new Roboter();
        roboter.spacherkennung();*/
        /*Leinwand leinwand;
        leinwand = new Leinwand(100,100, Color.white);
        System.out.println("1");
        leinwand.warten(300);
        System.out.println("2");
        leinwand.makeFrame();*/;
        /*Roboter roboter = new Roboter();
        //roboter.spacherkennung();
        Spielfeld s = new Spielfeld();
        //Punkt[] punkten = s.punkteEingeben();
        //Rechteck rechteck = new Rechteck(new Punkt(400,400),200,200,"a", Color.BLACK);
        //ArrayList<Rechteck> rechtecks1 = new ArrayList<>();
        ArrayList<Rechteck> rechtecks2 = s.hindernislisteErzeugen();
        //rechtecks1.add(0,rechteck);
        ArrayList<Punkt> poiSort = s.poiSortieren(s.punkteEingeben());
        for(Punkt punkt : poiSort){
            punkt.ausgabeAttribute();
        }
        s.zeichnen(rechtecks2, roboter , poiSort);
        //s.kurzenWegabfahren();
        Spielfeld.hindernisseUmfahren();*/
        //Roboter roboter = new Roboter();
        //roboter.spacherkennung();
        /*Punkt p1 = new Punkt(5,5);
        Rechteck r1 = new Rechteck(p1,20,20,"a",Color.green);
        r1.ausgabeAttribute();
        Punkt p2 = new Punkt(5,5);
        Rechteck r2 = new Rechteck(p2,50,50,"b",Color.red);
        r2.ausgabeAttribute();
        boolean u = r1.ueberlappt(r2);
        System.out.println(u);*/
        Spielfeld s = new Spielfeld();
        Roboter roboter = new Roboter();
        Punkt[] punkten = s.punkteEingeben();
        Rechteck rechteck = new Rechteck(new Punkt(400,400),0,0,"a", Color.BLACK);
        ArrayList<Rechteck> rechtecks1 = new ArrayList<>();
        rechtecks1.add(0,rechteck);
        ArrayList<Punkt> poiSort = s.poiSortieren(punkten);
        for(Punkt punkt : poiSort){
            punkt.ausgabeAttribute();
        }
        s.zeichnen(rechtecks1, roboter , poiSort);
        s.kurzenWegabfahren();
    }
}
