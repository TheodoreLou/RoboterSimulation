import javax.swing.*;
import java.util.ArrayList;


public class Leinwand {

    private JFrame fenster;
    private Zeichenflaeche zeichenflaeche;
    private static Thread thread = new Thread();

    public Leinwand(int laenge, int breite){

        fenster = new JFrame();
        fenster.setSize(breite,laenge);
        fenster.setTitle("Robotersimulation");
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(false);
        fenster.setResizable(false);
    }

    public static void warten(long millisekunden) {
        try{
            Thread.sleep(millisekunden);
        }catch (Exception e)
        {
            // Exception ignorieren
        }
    }

    public void zeichnen(ArrayList<Rechteck> hindernisse , Roboter roboter , ArrayList<Punkt> poiSort) {
        zeichenflaeche = new Zeichenflaeche(hindernisse, roboter, poiSort);
        thread = new Thread(zeichenflaeche);
        thread.start();
        fenster.add(zeichenflaeche);
        fenster.setVisible(true);
    }

    public void resetFrame(){
        fenster.setVisible(false);
        thread.interrupt();
        fenster.getContentPane().removeAll();
        fenster.repaint();
    }
}
