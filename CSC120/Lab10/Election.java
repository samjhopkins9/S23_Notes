package week12;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Election {

    public static int find(String[] names, String name){

        for (int i=0; i<names.length; i++){

            if (names[i].toLowerCase().equals(name.toLowerCase())){

                return i;

            } // end of if statement

        } // end of for loop

        return -1;

    } // end of find function

    public static String[] addName(String[] names, String name){

        String[] names1 = new String[names.length + 1];

        for (int i=0; i<names.length; i++){

            names1[i] = names[i];

        } // end of for loop

        names1[names.length] = name;
        return names1;

    } // end of addName function

    public static int[] addNewCount(int[] counts){

        int[] counts1 = new int[counts.length + 1];

        for (int i=0; i<counts.length; i++){

            counts1[i] = counts[i];

        } // end of for loop

        counts1[counts.length] = 1;
        return counts1;

    } // end of addNewCount function

    public static void findWinner(String[] names, int[] counts){

        int c = counts[0];
        String winner = names[0];

        for (int i=0; i<counts.length; i++){

            System.out.println(names[i] + " received " + counts[i] + " votes.");

            if (counts[i] > c){

                winner = names[i];

            } // end of if statement

        } // end of for loop

        System.out.println("The winner is " + winner + "!");

    } // end of findWinner function

    public static void main(String[] args) throws IOException {

        String[] names = {};
        int[] counts = {};

        System.out.print("Use a file? ");
        Scanner in = new Scanner(System.in);

        Scanner in1;

        if (in.next().toLowerCase().charAt(0) == 'y'){

            // in1 = new Scanner(new File("/Users/samjhopkins9/IdeaProjects/CSC_120/src/week12/Votes.txt"));
            in1 = new Scanner(FileChooser120New.choose());

        } else {

            in1 = new Scanner(System.in);
            System.out.printf("###########################################%n# Enter the votes, one vote per line.     #%n########################################### %n");

        } // end of if-else

        while (in1.hasNext()){

            String name = in1.nextLine();

            if (name.equals("")){

                break;

            } // end of if statement

            if (find(names, name) != -1){

                counts[find(names, name)]++;

            } // end of if statement

            else {

                names = addName(names, name);
                counts = addNewCount(counts);

            } // end of if-else

        } // end of while loop

        findWinner(names, counts);

    } // end of main function

} // end of Election class
