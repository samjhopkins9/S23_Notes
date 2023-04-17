package week11;
import java.util.Scanner;

public class Birthday {

    public static int[] oneTrial(int nPeople){

        int[] theCounts = new int[365];

        for (int i=0; i<nPeople; i++){

            int n = (int)(Math.floor( Math.random()*364 ) );
            theCounts[n]++;

        }

        return theCounts;

    } // end of oneTrial function

    public static boolean hasAHit(int[] counts){

        for (int i=0; i<counts.length; i++){

            if (counts[i] >= 2){
                return true;
            } // end of if statement

        } // end of for loop

        return false;

    } // end of hasAHit function

    public static void experiment1(int nPeople, int nReps){

        double hitRate = 0;

        for (int i=0; i<nReps; i++){

            int[] counts = oneTrial(nPeople);
            boolean hit = hasAHit(counts);

            if (hit){
                hitRate += 1;
            } // end of if statement

        } // end of for loop

        hitRate /= nReps;
        System.out.printf("Probability Of Hits: %.3f%n", hitRate);

    } // end of experiment1 function

    public static void summarize(int[] theCounts){

        int largest = 0;

        for (int i=0; i<theCounts.length; i++){

            if (theCounts[i] > largest){
                largest = theCounts[i];
            }

        } // end of for loop

        int[] values = new int[largest + 1];

        for (int i=0; i<theCounts.length; i++){

            values[theCounts[i]]++;

        }

        for (int i=0; i<values.length; i++){

            System.out.printf( "%d Hits: %d%n", i, values[i] );

        }


    } // end of summarize function

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Experiment #1");

        System.out.print("Enter no. of people: ");
        int nPeople = in.nextInt();

        System.out.print("Enter no. of reps: ");
        int nReps = in.nextInt();

        System.out.println("Experiment 1");
        experiment1(nPeople, nReps);

        System.out.println("Experiment #2");

        System.out.print("Enter no. of people again: ");
        nPeople = in.nextInt();

        System.out.println("Experiment 2");
        summarize(oneTrial(nPeople));

    } // end of main function

} // end of Birthday class
