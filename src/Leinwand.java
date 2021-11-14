import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Leinwand {

    private JFrame fenster;
    private Zeichenflaeche zeichenflaeche;
    private static Thread thread;

    public Leinwand(int laenge, int breite, Color hintergrundfarbe){

        fenster = new JFrame();
        fenster.setSize(breite,laenge);
        fenster.setTitle("Robotersimulation");
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(false);
        fenster.setResizable(false);
    }

    public static void warten(long millisekunden) {
        try{
            thread.sleep(millisekunden);
        }catch (Exception e)
        {
            // Exception ignorieren
        }
    }

    public void zeichnen(ArrayList<Rechteck> hindernisse , Roboter roboter , ArrayList<Punkt> poiSort) {
        zeichenflaeche = new Zeichenflaeche(hindernisse, roboter, poiSort);
        Thread t = new Thread(zeichenflaeche);
        t.start();
        //zeichenflaeche.repaintFiguren(hindernisse,poiSort);
        fenster.add(zeichenflaeche);
        fenster.setVisible(true);
    }

}
