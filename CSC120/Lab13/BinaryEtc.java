package week15;
import java.util.Scanner;

public class BinaryEtc {

    static String convert(int x, int r){

        if (x == 0){

            return "";

        } // end of if

        int m = x % r;
        int q = x/r;
        return convert(q, r) + m;

    } // end of convert function

    public static void main(String[] args){

        Scanner uin = new Scanner(System.in);

        System.out.print("Enter input number: ");


        while (uin.hasNext()){

            int x = uin.nextInt();
            System.out.print("Enter radix (2--10): ");
            int r = uin.nextInt();
            if (x >= 0 && (r>=2 && r<=10)){

                System.out.println(convert(x, r));

            } else {

                System.out.println("Invalid numbers");

            } // end of if-else

            System.out.print("Enter input number: ");

        } // end of while loop

    } // end of main function

} // end of BinaryEtc class
