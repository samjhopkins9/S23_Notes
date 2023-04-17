package week4;
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class BallReach {
    public static final double G_EARTH = 9.807;
    public static final double G_MOON = 1.62;

    public static void message(String m){
        System.out.printf( "........ %s ........%n", m );
    } // end of message method

    public static void myPrint(String name, double value, String unit){
        System.out.printf( "%30s:%14.4f (%s)%n", name, value, unit );
    } // end of myPrint method

    public static void compute(double gravity, double angle, double velocity, double height) {
        double hs, vs, t0, h0, t1, h1, t2, h2;
        double distance;

        hs = Math.cos(Math.toRadians(angle)) * velocity;
        vs = Math.sin(Math.toRadians(angle)) * velocity;

        t0 = vs/gravity;
        h0 = (0.5*gravity)*(t0*t0);

        h1 = h0 + height;
        t1 = Math.sqrt(2*h1/gravity);

        t2 = t0 + t1;
        distance = vs * t2;

        myPrint("Height of cliff", height, "m/s");
        myPrint("Horizontal speed:", hs, "m/s");
        myPrint("Initial vertical speed", vs, " m/s");
        myPrint("Gravity", gravity, "m/s^2");
        myPrint("Upward time", t0, "s");
        myPrint("Upward distance", h0, "m");
        myPrint("Downward time", t1, "s");
        myPrint("Downward distance", h1, "m");
        myPrint("Total time", t2, "s");
        myPrint("Horizontal distance", distance, "m");

    } // end of compute method

    public static void main(String[] args) {
        double angle, velocity, height;

        Scanner uin = new Scanner(System.in);

        System.out.print("Enter angle (degrees): ");
        angle = uin.nextDouble();

        System.out.print("Enter speed (m/s): ");
        velocity = uin.nextDouble();

        System.out.print("Enter height (m): ");
        height = uin.nextDouble();

        message("On the Earth");
        compute(G_EARTH, angle, velocity, height);
        message("On the Moon");
        compute(G_MOON, angle, velocity, height);

    } // end of main method

} // end of class
