package week10;
import java.util.Scanner;

public class PrimeFactor {

    static boolean isPrime(int base){

        boolean result = false;
        int d = 2;
        while (d < base && base % d != 0){
            d++;
        } // end of while loop

        if (d < base){
            result = true;
        }  // end of if statement
        return result;

    } // end of isPrime function


    static long convert(String w){

        w = w.replace("*", " * ");
        w = w.replace("^", " ^ ");
        w += " *";

        Scanner in = new Scanner(w);
        long result = 1;

        int exponent, base;
        int prevBase = 1;
        String op;

        while(in.hasNext()){

            base = in.nextInt();
            op = in.next();

            if (op.equals("^")){
                exponent = in.nextInt();
                op = in.next();
            } // end of opening if statement
            else {
                exponent = 1;
            } // end of if-else


            // the following three if-statements and the subsequent try-catch generate error messages

            if (prevBase >= base){
                System.out.println(prevBase + " >= " + base);
            } // end of if statement

            if (exponent <= 0){
                System.out.println("Exponent " + exponent + "<=0");
            } // end of if statement

            if (!(op.equals("*"))){
                System.out.println(op + " != \"*\"");
            } // end of if statement

            if (isPrime(base)){
                System.out.println(base + " is not prime");
            } // end of if statement

            result *= Math.pow(base, exponent);

            prevBase = base;

        } // end of while loop

        return result;

    } // end of convert function


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String input;
        long result;
        System.out.print("Enter expression: ");

        while (in.hasNext()){

            input = in.nextLine();

            System.out.println(convert(input));
            System.out.print("Enter expression: ");

        } // end of while loop

    } // end of main method


} // end of PrimeFactor class

