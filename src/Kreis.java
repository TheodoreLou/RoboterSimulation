import java.awt.*;

public class Kreis extends Figur{

    private int durchmesser;
    private Punkt mittelpunkt;

    public Kreis() {
        super();
        durchmesser = 10;
        //注意代码顺序！！最后判断中点！！！
    }

    public Kreis(Punkt position, int breite, int laenge,
                String bezeichnung, Color farbe, Punkt mittelpunkt,
                int durchmesser) {
        super(position,breite,laenge,bezeichnung,farbe);
        this.durchmesser = durchmesser;
        this.mittelpunkt = mittelpunkt;
    }

    public int getDurchmesser() {
        return durchmesser;
    }

    public void setDurchmesser(int durchmesser){
        this.durchmesser = durchmesser;
    }

    public Punkt getMittelpunkt() {
        return mittelpunkt;
    }

    public void setMittelpunkt(Punkt mittelpunkt) {
        this.mittelpunkt = mittelpunkt;
        setPosition(new Punkt(mittelpunkt.getX()-getRadius(),mittelpunkt.getY()-getRadius()));
    }

    public void bewegeUm(int dx, int dy) {
        getPosition().setX(getPosition().getX()+dx);
        getPosition().setY(getPosition().getY()+dy);
        setMittelpunkt(new Punkt(getPosition().getX()+dx+getRadius(),
                                 getPosition().getY()+dy+getRadius()));
    }

    public void bewegeUm(Punkt verschiebevektor) {
        getPosition().setX(getPosition().getX()+verschiebevektor.getX());
        getPosition().setY(getPosition().getY()+verschiebevektor.getY());
        setMittelpunkt(new Punkt(getPosition().getX()+verschiebevektor.getX()+getRadius(),
                                 getPosition().getY()+verschiebevektor.getY()+getRadius()));
    }

    public int getRadius() {
        return durchmesser/2;
    }




    public boolean ueberlappt(Rechteck r) {
        //判断圆与作为障碍物的矩形是否碰撞
        //这个方法有问题

        //下面四个，true代表碰撞
        boolean eckeRechtsUnten     =
                this.getPosition().getX() <= r.getEckeRechtsUnten().getX() && this.getPosition().getY() <= r.getEckeRechtsUnten().getY();
        boolean eckeLinksUnten      =
                this.getPosition().getX()+durchmesser >= r.getEckeLinksUnten().getX() && this.getPosition().getY() <= r.getEckeLinksUnten().getY();
        boolean eckeRechtsOben      =
                this.getPosition().getX() <= r.getEckeRechtsOben().getX() && this.getPosition().getY()+durchmesser >= r.getEckeRechtsOben().getY();
        boolean eckeLinksOben       =
                this.getPosition().getX()+durchmesser >= r.getPosition().getX() && this.getPosition().getY()+durchmesser >= r.getEckeLinksOben().getY();

        boolean innen   =   r.getEckeLinksOben().getX() < this.getPosition().getX()
                            && r.getEckeLinksOben().getY() < this.getPosition().getY()
                            && r.getEckeRechtsUnten().getX() > this.getPosition().getX()+durchmesser
                            && r.getEckeRechtsUnten().getY() > this.getPosition().getY()-durchmesser;

        /*boolean linkeSeite      = Math.abs(this.getMittelpunkt().getX() - (r.getPosition().getX()))
                <= this.getRadius() && this.getMittelpunkt().getY() > r.getPosition().getY() && this.getMittelpunkt().getY() < r.getPosition().getY() + r.getLaenge();
        boolean rechteSeite     = Math.abs(this.getMittelpunkt().getX() - (r.getPosition().getX() + r.getBreite()))
                <= this.getRadius() && this.getMittelpunkt().getY() > r.getPosition().getY() && this.getMittelpunkt().getY() < r.getPosition().getY() + r.getLaenge();
        boolean oberSeite       = Math.abs(this.getMittelpunkt().getY() - (r.getPosition().getY()))
                <= this.getRadius() && this.getMittelpunkt().getX() > r.getPosition().getX() && this.getMittelpunkt().getX() < r.getPosition().getX() + r.getBreite();
        boolean unterSeite      = Math.abs(this.getMittelpunkt().getY() - (r.getPosition().getY() + r.getLaenge()))
                <= this.getRadius() && this.getMittelpunkt().getX() > r.getPosition().getX() && this.getMittelpunkt().getX() < r.getPosition().getX() + r.getBreite();
        boolean seiten          = linkeSeite || rechteSeite || oberSeite || unterSeite;*/


        return eckeRechtsUnten && eckeLinksOben || eckeLinksUnten && eckeRechtsOben  || innen;
    }

    public void ausgabeAttribute() {
        System.out.println(getPosition().getX() + "," + getPosition().getY());
        System.out.println(getBreite());
        System.out.println(getLaenge());
        System.out.println(getFarbe());
        System.out.println(getBezeichnung());
        System.out.println(getDurchmesser());
        System.out.println(getMittelpunkt().getX() + "," + getMittelpunkt().getY());
        System.out.println(getRadius());
    }

    public int minX() {
        return this.getPosition().getX();
    }

    public int minY() {
        return this.getPosition().getY();
    }

    public int maxX()
    {
        return this.getPosition().getX()+getDurchmesser();
    }

    public int maxY()
    {
        return this.getPosition().getY()+getDurchmesser();
    }

}