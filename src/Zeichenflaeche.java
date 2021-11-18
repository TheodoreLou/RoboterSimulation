import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Zeichenflaeche extends JPanel implements Runnable{
    private ArrayList<Rechteck> hindernisse;
    private Roboter roboter;
    private ArrayList<Punkt> poiSort = new ArrayList<>();

    public Zeichenflaeche(ArrayList<Rechteck> hindernisse, Roboter roboter,ArrayList<Punkt> poiSort) {
        this.hindernisse = hindernisse;
        this.roboter = roboter;
        this.poiSort = poiSort;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(roboter.getPosition().getX(),
                roboter.getPosition().getY(),
                roboter.getBreite(),
                roboter.getLaenge());
        graphics2D.fill(circle);


        for (Rechteck rechteck : hindernisse) {
            g.setColor(rechteck.getFarbe());
            g.fillRect(rechteck.getPosition().getX(), rechteck.getPosition().getY(),
                    rechteck.getBreite(), rechteck.getLaenge());
        }

        if (poiSort != null){
            for(Punkt p : poiSort)
            {
                g.setColor(Color.BLACK);
                g.drawOval(p.getX(), p.getY(), 10, 10);
            }
        }
    }

    public void repaintFiguren(ArrayList<Rechteck> figuren,ArrayList<Punkt> poiSort){
        hindernisse = figuren;
        this.poiSort = poiSort;
        this.repaint();
    }



    public void run(){
        while(true){
            try{
                if(hindernisse.size() == 1){
                    Spielfeld.kurzenWegabfahren();
                }
                if(poiSort.size() == 1){
                    Spielfeld.hindernisseUmfahren();
                }
                this.repaint();
                Leinwand.warten(15);
            }
            catch(Exception ignored){

            }

        }
    }


}

