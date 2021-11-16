import java.awt.*;
import java.util.ArrayList;

public class Test {
    public static void main(String args[]) {

        /*个类怎样调用另一个类中的属性和方法


        一般来说会用两种最常用的方式
        new一个对象，通过对象来调用类中的变量和方法
        如果一个类的方法是静态的，那么直接用类名.方法的方式就可以调用*/
        Spielfeld s = new Spielfeld();
        Roboter roboter = new Roboter();

    }
}
