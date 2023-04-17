package week12;
import java.util.*;
import java.io.*;
public class FileChooser120New {

    static final int MAXLEN = 20;
    static final String WHITES = "                    ";
    static final String DOTS = "...";
    static final int DOTLEN = 3;
    static final String GAP = "  ";

    /**
     * @return	w adjusted to have MAXLEN as its length
     * @param	w	input parameter
     */
    public static String shrinkName( String w ) {
        int len, point, q;
        String pre, post;
        len = w.length();

        // if the length is <= MAXLEN, append whitespace
        if ( len <= MAXLEN ) {
            return w + WHITES.substring( 0, MAXLEN - len );
        }

        // if w ends with a '/', drop suffix leading it
        if ( !w.endsWith( "/" ) ) {
            return w.substring( 0, MAXLEN - DOTS.length() - 1 )
                    + DOTS + "/";
        }

        // find the last position of '.'
        point = w.lastIndexOf( "." );
        // if no '.', use the length-MAXLEN prefix
        if ( point <= 0 ) {
            return w.substring( 0, MAXLEN );
        }

        // otherwise, drop the suffix leadning to the period
        post = w.substring( point );
        q = 20 - ( len - point ) - DOTS.length();
        pre = w.substring( 0, q );
        return pre + DOTS + post;
    }

    /**
     * print a file list with an index to each file
     * The element-0 is the parent directory
     * @param	list	a file array
     */
    private static void printNames( File[] list ) {
        int i;
        File f;
        String s;
        for ( i = 0; i < list.length; i ++ ) {
            f = list[ i ];
            s = f.getName();
            if ( f.isDirectory() ) {
                s = s + "/";
            }
            s = shrinkName( s );
            System.out.printf( "%2d:%-17s", i, s );
            if ( i % 3 == 2 || i == list.length - 1 ) {
                System.out.println();
            }
            else {
                System.out.print( GAP );
            }
        }
    }
    /**
     * The method for choosing a file
     */
    public static File choose() throws IOException {
        Scanner in = new Scanner( System.in ); // the scanner
        File current, base; // the file to return, the base folder

        // there are two possible starting points
        System.out.println( "File Selector for CSC120" );
        System.out.println( "1. Start from the home folder" );
        System.out.println( "2. Start from the class folder" );
        System.out.print( "Enter your choice: " );
        if ( in.next().startsWith( "1" ) ) {
            current = new File( System.getProperty( "user.home" ) );
        }
        else {
            current = new File( System.getProperty( "user.dir" ) );
        }
        base = current;

        String w;
        int choice;
        File[] list;
        boolean confirmed;

        confirmed = false;
        do {
            System.out.println( "******* Your current choice: "
                    + current.getCanonicalPath() + " ********" );
            System.out.println();

            // present the files in the base directory
            list = base.listFiles();
            printNames( list );
            System.out.print(
                    "Enter c to confirm, p for parent, or index: " );

            // if the input is an integer
            if ( in.hasNextInt() ) {
                choice = in.nextInt();
                /* if the input is integer indicating one of the files
                 * change current to the specified file
                 * and if it is the file, change the base
                 */
                if ( choice >= 0 && choice < list.length ) {
                    current = list[ choice ];
                    if ( current.isDirectory() ) {
                        base = current;
                    }
                }
                else {
                    System.out.println( "Invalid input." );
                }
            }

            // if the input is not an integer
            else {
                w = in.next();
                /*
                 * if it is "p"
                 * change the current to the parent
                 * change the base to the parent of the new current
                 */
                if ( w.startsWith( "p" ) ) {
                    current = current.getParentFile();
                    base = current.getParentFile();
                }
                // if it is "c", confirm
                else if ( w.startsWith( "c" ) ) {
                    confirmed = true;
                }
                else {
                    System.out.println( "Invalid input." );
                }
            }
        } while ( !confirmed );
        return current;
    }
    /**
     * The main method is for testing the choose method
     */
    public static void main( String[] args ) throws IOException {
        File f = choose();
        System.out.println( "You have chosen " + f.getCanonicalPath() );
        if ( f.isDirectory() ) System.out.println( "It is a folder." );
        if ( f.canRead() ) System.out.println( "It is readable." );
        if ( f.canWrite() ) System.out.println( "It is writeable." );
        if ( f.canExecute() ) System.out.println( "It is executable." );
        long size = f.length();
        System.out.printf( "Its size is %d bytes.%n", size );
    }
}
