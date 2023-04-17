package week8;
import java.util.Scanner;

public class Factor {
    static String factor(int n){

        int m = n;
        int d = 2;
        StringBuilder builder = new StringBuilder();

        while (m > 1){
            while (m % d == 0){
                if (m < n){
                    builder.append("*");
                }
                builder.append(d);
                m /= d;
            } // end of while loop
            d++;
        } // end of while loop

        return builder.toString();

    } // end of factor function

    static String factor2(int n){

        int m = n;
        int d = 2;
        StringBuilder builder = new StringBuilder();

        while (m > 1){
            if (m % d == 0){
                if (m < n){
                    builder.append("*");
                }
                builder.append(d);
                int c = 0;
                while (m % d == 0) {
                    m /= d;
                    c++;
                }
                if (c >= 1){
                    builder.append("^" + c);
                }
            } // end of while loop
            d++;
        } // end of while loop

        return builder.toString();

    } // end of factor2 function

    public static void main(String[] args) {
        Scanner uin = new Scanner(System.in);
        int n = 0;
        System.out.println("To exit, enter 1.");
        while (n != 1){
            System.out.print("Enter a number >= 2: ");
            n = uin.nextInt();
            if (n >= 2){
                System.out.println(factor(n));
                System.out.println(factor2(n));
            }
        }
    }
}
