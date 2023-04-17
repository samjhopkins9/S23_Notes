package week3;
import java.util.Scanner;

public class LinEq {
    public static void main(String[] args){
        System.out.println("This program solves systems of linear equations");
        System.out.println("Suppose ax + by = p, cx + dy = q");

        double a, b, p;
        double c, d, q;
        double det, x, y;

        Scanner uin = new Scanner(System.in);

        System.out.println("Enter a, b and p: ");
        a = uin.nextDouble();
        b = uin.nextDouble();
        p = uin.nextDouble();

        System.out.println("Enter c, d and q: ");
        c = uin.nextDouble();
        d = uin.nextDouble();
        q = uin.nextDouble();

        det = (a*d) - (b*c);
        x = ((d*p) - (b*q)) / det;
        y = ((a*q) - (c*p)) / det;

        System.out.print("The equations are: " + a + "x + " + b + "y = " + p + ", ");
        System.out.println(c + "x + " + d + "y = " + q);

        System.out.println("The solution is: (" + x + ", " + y + ") \n");
    } // end of main method
} // end of class
