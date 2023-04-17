package week13;

public class Rectangle {

    double[] bottom_left = new double[2];
    double[] top_right = new double[2];

    public Rectangle ( double xLow, double yLow, double xHigh, double yHigh ){

        bottom_left[0] = xLow;
        bottom_left[1] = yLow;

        top_right[0] = xHigh;
        top_right[1] = yHigh;


    } // end of constructor


    public Range getXRange(){

        return new Range(bottom_left[0], top_right[0]);

    } // end of getXRange function


    public Range getYRange(){

        return new Range(bottom_left[1], top_right[1]);

    } // end of getYRange function


    public boolean intersect( Rectangle o ){

        if (getXRange().intersect(o.getXRange()) && getYRange().intersect(o.getYRange())){

            return true;

        } // end of if statement

        return false;

    } // end of intersect function


    public boolean isIn( double x, double y ){

        if (getXRange().isIn(x) && getYRange().isIn(y)){

            return true;

        } // end of if statement

        return false;

    } // end of isIn function


    public double distance( double x, double y ){

        if (isIn(x, y)){

            return 0;

        } // end of if statement

        return Math.sqrt(Math.pow(getXRange().distance(x), 2) + Math.pow(getYRange().distance(y), 2));

    } // end of distance function


} // end of Rectangle class
