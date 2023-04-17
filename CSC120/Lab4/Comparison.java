package week5;

import java.util.Scanner;

public class Comparison {
    static class Person {
        String name;
        double height;
        double weight;
        double bmi;

        public Person(int n){
            Scanner uin = new Scanner(System.in);
            System.out.println("Name, Height, Weight for Person " + n + ": ");
            name = uin.next();
            height = uin.nextDouble();
            weight = uin.nextDouble();
            bmi = 703.0*weight/(height*height);
        } // end of Person constructor

    } // end of Person class

    public static void report(String x, double a){
        System.out.printf( "%s for %.2f%n", x, a );
    } // end of report method

    public static void find1st(
            String x1, double a1,
            String x2, double a2 ) {
        double min = Math.min(a1, a2);
        if (min == a1){
            report(x1, a1);
            report(x2, a2);
        }
        else if (min == a2){
            report(x2, a2);
            report(x1, a1);
        }
    } // end of find1st method

    public static void find1st(
            String x1, double a1,
            String x2, double a2,
            String x3, double a3 ) {
        double min = Math.min(Math.min(a1, a2), a3);
        if (min == a1) {
            report(x1, a1);
            find1st(x2, a2, x3, a3);
        }
        else if (min == a2){
            report(x2, a2);
            find1st(x1, a1, x3, a3);
        }
        else if (min == a3){
            report(x3, a3);
            find1st(x1, a1, x2, a2);
        }
    } // end of find1st method

    public static void find1st(
            String x1, double a1,
            String x2, double a2,
            String x3, double a3,
            String x4, double a4 ) {
        double min = Math.min(Math.min(a1, a2), Math.min(a3, a4));
        if (min == a1){
            report(x1, a1);
            find1st(x2, a2, x3, a3, x4, a4);
        }
        else if (min == a2){
            report(x2, a2);
            find1st(x1, a1, x3, a3, x4, a4);
        }
        else if (min == a3){
            report(x3, a3);
            find1st(x1, a1, x2, a2, x4, a4);
        }
        else if (min == a4){
            report(x4, a4);
            find1st(x1, a1, x2, a2, x3, a3);
        }
    } // end of find1st method

    public static void main(String[] args) {
        Person[] people = new Person[4];
        for (int i=0; i<4; i++){
            people[i] = new Person(i+1);
        }
        System.out.println("---- Ranking by Height");
        find1st(people[0].name, people[0].height, people[1].name, people[1].height, people[2].name, people[2].height, people[3].name, people[3].height);
        System.out.println("---- Ranking by Weight");
        find1st(people[0].name, people[0].weight, people[1].name, people[1].weight, people[2].name, people[2].weight, people[3].name, people[3].weight);
        System.out.println("---- Ranking by BMI");
        find1st(people[0].name, people[0].bmi, people[1].name, people[1].bmi, people[2].name, people[2].bmi, people[3].name, people[3].bmi);
    } // end of main method

} // end of Comparison class
