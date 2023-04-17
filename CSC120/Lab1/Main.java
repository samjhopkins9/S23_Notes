package week2;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello,  World!");
        Intro sam = new Intro("Sam", "Human", "20", "Steak", "Skiing");
        Shapes s = new Shapes();
        Trapezoid t = new Trapezoid();
        t.area1(19, 20, 21);
        t.area2(19.0, 20.0, 21.0);
    }
}
