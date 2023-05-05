package week15;
import java.util.Scanner;

public class McCarthy91 {

    static int mccarthy(int x){

        System.out.println(x);

        if (x > 100){

            return x-10;

        } // end of if

        return mccarthy(mccarthy(x+11));

    } // end of mccarthy function

    public static void main(String[] args){

        Scanner uin = new Scanner(System.in);
        System.out.print("Enter input number: ");
        int x = uin.nextInt();

        System.out.println("the value is " + mccarthy(x));

    } // end of main function

} // end of McCarthy91 class
