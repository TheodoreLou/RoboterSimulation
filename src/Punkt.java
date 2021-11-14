import java.lang.Math;

public class Punkt {
    private int x;
    private int y;

    public Punkt() {
        x = 0;
        y = 0;
    }

    public Punkt(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void ausgabeAttribute() {
        System.out.println(x + "," + y);
    }

    public void bewegeUm(int dx, int dy) {
        x = dx;
        y = dy;
    }

    public double gibAbstand(Punkt andererPunkt) {
        return Math.sqrt((andererPunkt.getX()-x)*(andererPunkt.getX()-x)+
                         (andererPunkt.getY()-y)*(andererPunkt.getY()-y));
    }


}
