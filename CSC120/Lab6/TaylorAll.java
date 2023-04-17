package week7;
import java.util.Scanner;

public class TaylorAll {
    public static void expandExp(double x, int n){
        System.out.printf("---Approximation of exp(%f)---%n", x);
        double g = x;
        double s = x + 1;

        for (int k=2; k<=n; k++){
            g *= x/k;
            s += g;

            System.out.printf("%d: %.15f%n", k, s);

        } // end of for loop
        System.out.println("Math.exp(" + x + "): " + Math.exp(x));

    } // end of expandExp function

    public static void expandSin(double x, int n){
        System.out.printf("---Approximation of sin(%f)---%n", x);
        double g = x;
        double s = x;

        for (int k=2; k<=n; k++){
            g *= x/k;

            if (k%4 == 1) {
                s += g;
            }
            else if (k%4 == 3) {
                s -= g;
            } // end of if-else statement

            System.out.printf("%d: %.15f%n", k, s);

        } // end of for loop

        System.out.println("Math.sin(" + x + "): " + Math.sin(x));
    } // end of expandSin function

    public static void expandLog(double x, int n){
        System.out.printf("---Approximation of log(%f)---%n", x);
        double g = x;
        double s = x;
        double derivative = 1.0;

        for (int k=2; k<=n; k++){
            g *= x/k;

            derivative *= -(k-1);
            s += g * derivative;

            System.out.printf("%d: %.15f%n", k, s);

        } // end of for loop
        System.out.println("Math.log(1 + "+ x + "): " + Math.log(1+x));

    } // end of expandLog function

    public static void main(String[] args) {
        double x;
        int n;
        Scanner in = new Scanner(System.in);

        System.out.println("For exp(x), enter x (|x| < 1.0) and n: ");
        x = in.nextDouble();
        n = in.nextInt();

        expandExp(x, n);

        System.out.println("For sin(x), enter x (|x| < 1.0) and n: ");
        x = in.nextDouble();
        n = in.nextInt();

        expandSin(x, n);

        System.out.println("For log(1+x), enter x(|x| < 1.0) and n: ");
        x = in.nextDouble();
        n = in.nextInt();

        expandLog(x, n);

    } // end of main method

} // end of TaylorAll class
