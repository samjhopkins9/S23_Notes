package week13;

public class Range {

    double low;
    double high;

    public Range( double l, double h ){

        if (l > h){

            low = h;
            high = l;

        } // end of if statement

        else {

            low = l;
            high = h;

        } // end of else



    } // end of Range constructor


    public double getLow(){

        return low;

    } // end of getLow function


    public double getHigh(){

        return high;

    } // end of getHigh function


    public boolean intersect( Range o ){

        if (low > o.getHigh() || high < o.getLow()){

            return false;

        } // end of if statement

        return true;

    } // end of intersect function


    public boolean isIn( double p ){

        if ((p >= low) && (p <= high)){

            return true;

        } // end of if statement

        return false;

    } // end of isIn function


    public double distance( double p ) {

        if ((p >= low) && (p <= high)){

            return 0;

        } // end of if statement

        else if (p > high){

            return p - high;

        } // end of else-if

        return low - p;

    } // end of distance function

} // end of Range class
