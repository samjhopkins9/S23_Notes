package week6;
import java.util.Scanner;

public class Name {
    public static String myTrim(String x){
        x = x.trim();
        boolean afterSpace = true;
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<x.length(); i++){
            char ch = x.charAt(i);
            if (ch == ' '){
                if (afterSpace == false){
                    builder.append(ch);
                }
                afterSpace = true;
            }

            else if (ch == ','){
                builder.append(ch);
                builder.append(' ');
                afterSpace = true;
            }

            else {
                builder.append(ch);
                afterSpace = false;
            }

        } // end of for loop
        return builder.toString();
    } // end of myTrim method

    public static void name(){
        String firstName, middleName, lastName;
        String prefixName, suffixName, nickName;

        Scanner uin = new Scanner(System.in);
        System.out.print("Enter the name to analyze: ");
        String input = uin.nextLine();

        String full = input;

        int a = full.indexOf("\"");
        if (a < 0) {
            nickName = "";
        }
        else {
            int b = a+1;
            while (full.charAt(b) != '\"'){
                b++;
            }
            nickName = full.substring(a, b+1);
            full = full.substring(0, a) + " " + full.substring(b+1, full.length()-1);
        }

        full = myTrim(full);
        a = full.indexOf(',');
        if (a < 0){
            suffixName = "";
        }
        else {
            suffixName = full.substring(a+1);
            full = full.substring(0, a);
        }

        if (full.startsWith("Dr.") || full.startsWith("Mr.") || full.startsWith("Ms.")){
            prefixName = full.substring(0, 3);
            full = full.substring(4);
        }
        else if (full.startsWith("Mrs.") || full.startsWith("Rev.")){
            prefixName = full.substring(0, 4);
            full = full.substring(5);
        }
        else {
            prefixName = "";
        }

        a = full.indexOf(' ');
        firstName = full.substring(0, a);
        full = full.substring(a+1);

        a = full.lastIndexOf(' ');
        if (a < 0){
            lastName = full;
            middleName = "";
        }
        else {
            middleName = full.substring(0, a);
            lastName = full.substring(a+1);
        }

        System.out.println("input = <" + input + ">");
        System.out.println("firstName = <" + firstName + ">");
        System.out.println("middleName = <" + middleName + ">");
        System.out.println("lastName = <" + lastName + ">");
        System.out.println("prefix = <" + prefixName + ">");
        System.out.println("suffix = <" + suffixName+ ">");
        System.out.println("nickName = <" + nickName+ ">");
        System.out.println();
    } // end of name function

    public static void main(String[] args) {
        name();
        name();
    } // end of main function

} // end of Name class
