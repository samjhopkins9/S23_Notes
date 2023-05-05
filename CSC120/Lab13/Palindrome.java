package week15;
import java.util.Scanner;

public class Palindrome {

    static boolean test(String w){

        w = w.toLowerCase();

        if (w.length() == 0 || w.length() == 1){

            return true;

        } // end of if

        else if (w.charAt(0) != w.charAt(w.length()-1)){

            return false;

        } // end of else if

        w = w.substring(1, w.length()-1);
        return test(w);

    } // end of test method

    public static void main(String[] args){

        Scanner uin = new Scanner(System.in);
        System.out.print("Enter candidate: ");

        while (uin.hasNextLine()) {

            String word = uin.nextLine();

            if (test(word)) {

                System.out.println(word + " is a palindrome.");

            } else {

                System.out.println(word + " is not a palindrome.");

            } // end of if-else

            System.out.print("Enter candidate: ");

        } // end of while loop

    } // end of main function

} // end of Palindrome class
