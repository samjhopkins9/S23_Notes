package week2;

public class Trapezoid {
    public void area1(int bottom, int top, int height){
        System.out.println(" --- Trapezoid number 1 --- ");
        System.out.println("Top: " + top);
        System.out.println("Bottom: " + bottom);
        System.out.println("Height: " + height);
        System.out.println("Area: " + (bottom + top) * height / 2);
        System.out.println("");
    }
    public void area2(double bottom, double top, double height){
        System.out.println(" --- Trapezoid number 2 --- ");
        System.out.print("Top: ");
        System.out.println(top);
        System.out.print("Bottom: ");
        System.out.println(bottom);
        System.out.print("Height: ");
        System.out.println(height);
        System.out.print("Area: ");
        System.out.println((bottom + top) * height / 2.0);
        System.out.println("");
    }
}

