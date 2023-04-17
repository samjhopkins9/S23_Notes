package week14;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Historical {

    OneDay[][][] days;

    public Historical() {

        File f = new File("/Users/samjhopkins9/IdeaProjects/CSC_120/src/week14/precipitation-data.txt");
        Scanner fin;
        try {

             fin = new Scanner(f);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            return;

        } // end of try-catch

        days = new OneDay[83][12][31];
        for (int i=0; i<83; i++){

            for (int j=0; j<12; j++){

                int year = fin.nextInt();
                int month = fin.nextInt();

                for (int l=0; l<31; l++){

                    days[i][j][l] = new OneDay(year, month, l+1, fin.nextDouble());

                } // end of for loop;

            } // end of for loop

        } // end of for loop

        fin.close();

    } // end of Historical constructor

    public void explore(int yLow, int yHigh, int mLow, int mHigh, int dLow, int dHigh){

        int count = 0;
        double sum = 0;

        OneDay theMax = null;
        OneDay theMin = null;

        for (int i=yLow-Const.FIRST_YEAR; i <=yHigh - Const.FIRST_YEAR; i++){

            for (int j=mLow-1; j<mHigh; j++){

                for (int k=dLow-1; k<dHigh; k++){

                    if (days[i][j][k].v != Const.NODATA){

                        if (theMax == null){

                            theMax = days[i][j][k];
                            theMin = days[i][j][k];

                        } // end of if

                        else {

                            if (days[i][j][k].v > theMax.v){

                                theMax = days[i][j][k];

                            } // end of if

                            else if (days[i][j][k].v < theMin.v){

                                theMin = days[i][j][k];

                            } // end of if

                        } // end of if

                        count++;
                        sum += days[i][j][k].v;

                    } // end of if

                } // end of for loop

            } // end of for loop

        } // end of for loop

        System.out.println("Count " + count);
        System.out.printf("Average %.3f%n", sum/count);
        System.out.println("Maximum " + theMax.toString());
        System.out.println("Minimum " + theMin.toString());

    } // end of explore function

} // end fo Historical class
