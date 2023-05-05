import java.util.Scanner;
import java.util.ArrayList;

public class Wordle {
    
    // function checks if character is contained in string
    public static boolean contains(char c, String s){
        
        // loops through string; if a character is equal to inputted, then returns true
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == c){
                return true;
            }
            
        } // end of for loop
        
        return false;
        
    } // end of contains function
    
    
    // function checks if character is contained hit, miss or neither; first checks if string contains character, then checks if it is at specified index
    public static char hit(char c, String s, int i){
        
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
    
    public static void word_color(String word, String seq){
        
        System.out.print(word + ": ");
        for (int i=0; i<seq.length(); i++){
            
            char c = word.charAt(i);
            if (seq.charAt(i) == 'H'){
                
                System.out.printf(ColorSelect.encode(0x000000, 0x22, Character.toString(c)));
                
            } // end of if
            
            else if (seq.charAt(i) == 'm'){
                
                System.out.printf(ColorSelect.encode(0x000000, 0xC0, Character.toString(c)));
                
            } // end of else-if
            
            else {
                
                System.out.printf(ColorSelect.encode(0x000000, 0x01, Character.toString(c)));
                
            } // end of if
            System.out.print(" ");
                        
        } // end of for loop
        System.out.println();
        
    } // end of word_color function
    
    
    // function prompts user for a guess and prints all prior guesses; is called recursively until 6 rounds are played or the user guesses the secret
    public static void prompt(int round, String secret, GameData gg){
        
        System.out.print("Round " + round + ". Enter guess: ");
        Scanner in = new Scanner(System.in);
        String guess = in.next();
        
        if (guess.length() == 5){
            
            StringBuilder seq = new StringBuilder();
            for (int i=0; i<5; i++){
                
                char h = hit(guess.charAt(i), secret, i);
                seq.append(h);
                gg.move(guess.charAt(i), h);
                
            } // end of for loop
            
            gg.guesses.add(guess);
            gg.seqs.add(seq.toString());
            
        } // end of if
        
        else {
            
            System.out.println("Invalid guess.");
            prompt(round, secret, gg);
            return;
            
        } // end of else
        
        for (int i=0; i<gg.guesses.size(); i++){
            
            // System.out.println(gg.guesses.get(i) + ": " + gg.seqs.get(i));
            word_color(gg.guesses.get(i).toUpperCase(), gg.seqs.get(i));
            
        } // end of for loop
        
        if (guess.toLowerCase().equals(secret.toLowerCase())){
            
            System.out.println("Congratulations. You have found the secret!");
            return;
            
        } // end of if
        
        else {
            
            if (round == 6){
                
                System.out.printf("secret was " + secret.toUpperCase() + "%n");
                return;
                
            } // end of if
            
            // gg.print();
            gg.print_alph();
            prompt(round+1, secret, gg);
            
        } // end of else
        
    } // end of prompt function
    
    
    // function prompts a user to enter a secret, then runs the prompt function to play the game using the given secret
    public static void game(){
        
        Scanner in = new Scanner(System.in);
        
        // commented out portion offers user input for secret
        /*
        System.out.print("Enter secret: ");
        String secret = in.next();
        
        if (secret.length() != 5){
            System.out.println("Invalid secret. Enter a word with exactly five letters");
            game();
            return;
        }
         */
        
        Dictionary dict = new Dictionary();
        int index = (int)(Math.floor(Math.random() * dict.SHORT_LIST.length));
        String secret = dict.SHORT_LIST[index];
        // System.out.println(secret);
        
        GameData gg = new GameData();
        
        prompt(1, secret, gg);
        
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

