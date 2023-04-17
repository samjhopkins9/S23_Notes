package week3;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Bakery {
    public static void main(String[] args){
        System.out.println("Welcome to Dana's Bakery!");
        System.out.println("Pastries are 4.5 dollars each.");
        System.out.println("Coffees are 3.0 dollars each.");
        System.out.println("Sandwiches are 6.0 dollars each.");
        System.out.println("Loaves of bread are each 7.0 dollars.");

        Scanner uin = new Scanner(System.in);
        int pastries, coffees, sandwiches, bread;
        double subtotal, tax, total;
        DecimalFormat f = new DecimalFormat("###.##"); // to clean up double outputs

        System.out.println("How many pastries?");
        pastries = uin.nextInt();
        subtotal = 4.5 * pastries;
        System.out.println("Subtotal is " + f.format(subtotal) + " dollars.");

        System.out.println("How many coffees?");
        coffees = uin.nextInt();
        subtotal += 3.0 * coffees;
        System.out.println("Subtotal is " +  f.format(subtotal)  + " dollars.");

        System.out.println("How many sandwiches?");
        sandwiches = uin.nextInt();
        subtotal += 6.0 * sandwiches;
        System.out.println("Subtotal is " +  f.format(subtotal)  + " dollars.");

        System.out.println("How many loaves of bread?");
        bread = uin.nextInt();
        subtotal += 7.0 * bread;
        System.out.println("Subtotal is " +  f.format(subtotal)  + " dollars.");

        tax = (subtotal * 0.07 * 100 ) / 100.0;
        total = subtotal + tax;

        System.out.println("Tax is " + f.format(tax) + " dollars. ");
        System.out.println("Total is " + f.format(total) + " dollars. ");
    } // end of main method
} // end of class
