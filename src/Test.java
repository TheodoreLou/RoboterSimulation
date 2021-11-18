public class Test {
    public static void main(String args[]) {

        /*个类怎样调用另一个类中的属性和方法


        一般来说会用两种最常用的方式
        new一个对象，通过对象来调用类中的变量和方法
        如果一个类的方法是静态的，那么直接用类名.方法的方式就可以调用*/
        /*Spielfeld s = new Spielfeld();
        Roboter roboter = new Roboter();
        roboter.spacherkennung();*/

        System.out.println("Hello!");
        System.out.println("Herzlich willkommen!");
        System.out.println("Für die Eigenschaften des Roboter können Sie- ");
        System.out.println("NAME,ALTER,HERSTELLER,GESCHLECHT"+" -- "+"die Eigenschaft suchen.");
        System.out.println("Für die Funktion : hindernisseUmfahren bitten Sie mit 'UMFAHREN'");
        System.out.println("Für die Funktion : kurzenWegAbfahren bitten Sie mit 'PUNKTE'");
        System.out.println("ein schönes Tag!");
        Roboter roboter = new Roboter();
        roboter.spacherkennung();
        /*//这个是调用最短路径的方法
        Spielfeld s = new Spielfeld();
        Roboter roboter = new Roboter();
        Rechteck rechteck = new Rechteck(new Punkt(400,400),0,0,"a", Color.BLACK);
        ArrayList<Rechteck> rechtecks1 = new ArrayList<>();
        rechtecks1.add(0,rechteck);
        ArrayList<Punkt> poiSort = s.poiSortieren(s.punkteEingeben());
        for(Punkt punkt : poiSort){
            punkt.ausgabeAttribute();
        }
        s.zeichnen(rechtecks1,  roboter, poiSort);
        s.kurzenWegabfahren();*/

        /*//这个是规避障碍的方法
        Spielfeld spielfeld = new Spielfeld();
        Roboter roboter = new Roboter();
        ArrayList<Rechteck> rechtecks = spielfeld.hindernislisteErzeugen();
        ArrayList<Punkt> punkts = new ArrayList<>();
        Punkt punkt = new Punkt(0,0);
        punkts.add(0,punkt);
        spielfeld.zeichnen(rechtecks, roboter, punkts);
        Spielfeld.hindernisseUmfahren();*/
    }
}
