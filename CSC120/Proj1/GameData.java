import java.util.*;
import java.awt.Color;

public class GameData {
    
    char[] alphabet = new char[26];
    
    ArrayList<String> guesses = new ArrayList<String>();
    ArrayList<String> seqs = new ArrayList<String>();
    
    ArrayList<Character> must_use = new ArrayList<Character>();
    ArrayList<Character> may_use = new ArrayList<Character>();
    ArrayList<Character> not_use = new ArrayList<Character>();
    
    public GameData(){
        
        char[] alph = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        alphabet = alph;
        for (int i=0; i<alph.length; i++){
            may_use.add(alphabet[i]);
            
        } // end of for loop
        
    } // end of GameData constructor
    
    public void move(char ch, char h){
        
        char c = Character.toUpperCase(ch);
        
        for (int i=0; i<may_use.size(); i++){
            
            if (may_use.get(i) == c){
                
                may_use.remove(i);
                if (h == 'm' || h == 'H'){
                    
                    must_use.add(c);
                     
                } else {
                    
                    not_use.add(c);
                    
                } // end of if-else
                
                break;
                
            } // end of if
            
        } // end of for loop
        
    } // end of move function
    
    public void print(){
        
        System.out.println("------------------");
        System.out.print("    MUST USE: ");
        for (int i=0; i<must_use.size(); i++){
            
            System.out.print(must_use.get(i) + " ");
            
        } // end of for loop
        System.out.println();
        
        System.out.print("     MAY USE: ");
        for (int i=0; i<may_use.size(); i++){
            
            System.out.print(may_use.get(i) + " ");
            
        } // end of for loop
        System.out.println();
        
        System.out.print("MUST NOT USE: ");
        for (int i=0; i<not_use.size(); i++){
            
            System.out.print(not_use.get(i) + " ");
            
        } // end of for loop
        System.out.println();
        System.out.println();
        
    } // end of print function
    
    public void color_letter(char c){
        
        for (int i=0; i<must_use.size(); i++){
            
            if (c == must_use.get(i)){
                
                System.out.print(ColorSelect.encode(0x00, 0x22, must_use.get(i) + " ") + " ");
                return;
                
            } // end of if
            
        } // end of for loop
        
        for (int i=0; i<may_use.size(); i++){
            
            if (c == may_use.get(i)){
                
                System.out.print(ColorSelect.encode(0x00, 0xC0, may_use.get(i) + " ") + " ");
                return;

            } // end of if
            
        } // end of for loop
        
        for (int i=0; i<not_use.size(); i++){
            
            if (c == not_use.get(i)){
                
                System.out.print(ColorSelect.encode(0x00, 0x01, not_use.get(i) + " ") + " ");
                return;
                
            } // end of if
            
        } // end of for loop
        
    } // end of color_letter function
    
    public void print_alph(){
        
        System.out.println("----------------");
        
        for (int i=0; i<alphabet.length; i++){
            
            color_letter(alphabet[i]);
            
            if (i%9 == 8){
                
                System.out.println();
                
            } // end of if
            
        } // end of for loop
        
        System.out.println();
        System.out.println();
        
    } // end of print_alph function
    
} // end of GameData class
