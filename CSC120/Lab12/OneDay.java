package week14;

public class OneDay {

    public int y;
    public int m;
    public int d;
    public double v;

    public OneDay(int year, int month, int day, double value){

        y = year;
        m = month;
        d = day;
        v = value;

    } // end of OneDay constructor

    public double getAmount(){

        return v;

    } // end of getAmount method

    public String toString(){

        StringBuilder b = new StringBuilder();
        b.append(v + " on " + y + "-" + m + "-" + d);
        return b.toString();

    } // end of toString method

} // end of OneDay class
