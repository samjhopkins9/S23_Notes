import java.util.Scanner;
import java.util.ArrayList;

public class Wordle {
    
    // function checks if character is contained in string
    static boolean contains(char c, String s){
        
        // loops through string; if a character is equal to inputted, then returns true
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == c){
                return true;
            }
            
        } // end of for loop
        
        return false;
        
    } // end of contains function
    
    
    // function checks if character is contained hit, miss or neither; first checks if string contains character, then checks if it is at specified index
    static char hit(char c, String s, int i){
        
        // converts both to lowercase so the comparison of inputs is not case-sensitive
        c = Character.toLowerCase(c);
        s = s.toLowerCase();
        
        // if string contains character, then hit or miss
        if (contains(c, s)){
            
            // if character is at index, then hit
            if (s.charAt(i) == c){
                return 'H';
            }
            
            return 'm';
        }
        
        return '_';
        
    } // end of hit function
    
    
    // function prompts user for a guess and prints all prior guesses; is called recursively until 6 rounds are played or the user guesses the secret
    static void prompt(int round, String secret, ArrayList<String> guesses, ArrayList<String> seqs){
        
        System.out.print("Round " + round + ". Enter guess: ");
        Scanner in = new Scanner(System.in);
        String guess = in.next();
        
        if (guess.length() == 5){
            StringBuilder seq = new StringBuilder();
            for (int i=0; i<5; i++){
                seq.append(hit(guess.charAt(i), secret, i));
            } // end of for loop
            
            guesses.add(guess);
            seqs.add(seq.toString());
        }
        
        else {
            System.out.println("Invalid guess.");
            prompt(round, secret, guesses, seqs);
            return;
        }
        
        for (int i=0; i<guesses.size(); i++){
            System.out.println(guesses.get(i).toUpperCase() + ": " + seqs.get(i));
        } // end of for loop
        
        if (guess.toLowerCase().equals(secret.toLowerCase())){
            System.out.println("Congratulations. You have found the secret!");
            return;
        }
        
        else {
            
            if (round == 6){
                System.out.printf("secret was " + secret.toUpperCase() + "%n");
                return;
            }
            
            prompt(round+1, secret, guesses, seqs);
        }
        
    } // end of prompt function
    
    
    // function prompts a user to enter a secret, then runs the prompt function to play the game using the given secret
    static void game(){
        
        System.out.print("Enter secret: ");
        Scanner in = new Scanner(System.in);
        String secret = in.next();
        
        if (secret.length() != 5){
            System.out.println("Invalid secret. Enter a word with exactly five letters");
            game();
            return;
        }
        
        ArrayList<String> guesses = new ArrayList<String>();
        ArrayList<String> seqs = new ArrayList<String>();
        
        prompt(1, secret, guesses, seqs);
        
        System.out.println("Would you like to play again? Enter 1 for yes, 2 for no");
        
        String c = in.next();
        if (c.equals("1")){
            game();
        }
        
    } // end of game function
    
    
    public static void main(String[] args){
        
        game();
        
    } // end of main function
    
} // end of Wordle class
