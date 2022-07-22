import java.util.Scanner;

public class wordle {
    
    // Word has to be preset lmao
    // five letter words only
    
    public static String hiddenWord = "green";
    public static String entryLengthCheck;
    public static String currentEntry;
    public static int triesused;
    public static int guessednum;
    
    public static void insertNewWord(String Word){
        
        hiddenWord = Word;
        
    }
    public static void greet(){
        System.out.println("Welcome to Wordle");
        System.out.println("Try Your best To Guess a Five Letter Word");
        System.out.println("You only have 6 tries ");
        System.out.println("Once you have entered a valid guess");
        System.out.println("You might see a letter, an asterisk, or even a plus sign");
        System.out.println("If You get a letter, that letter is in the hidden word and currently in the right spot");
        System.out.println("If you get a plus sign, that letter is in the word, but currently in the wrong spot");
        System.out.println("And If you get an asterick, that letter is not in the word at all \nEnjoy!\n\n\n");
        triesused = 6;
        hiddenWord = hiddenWord.toUpperCase();
        askForGuess();
    }
    
    //MainDriver
    public static void askForGuess(){
        guessednum = 0;
       if(triesused >0){ 
        System.out.println("\n\nYou have "+ triesused + " tries left");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nGuess a five letter word");

        String Entry = myObj.nextLine();  // Read user input
        Entry = Entry.toUpperCase();
        entryLengthCheck = Entry;
        System.out.println("Answer Submitted: " + Entry);
        checkEntryLength();
           
       }else {
           System.out.println("\n\nYou have ran out of tries\n\nRestartingGame...\n\n");
           greet();
       }
        
    }
    
    public static void checkEntryLength(){
        
        if(entryLengthCheck.length() != 5){
            System.out.println("Your guess has to be five letters long. Please try again ");
            askForGuess();
        }
            else
            currentEntry = entryLengthCheck;
            System.out.println("5 letter word inserted.\nResult: \n");
            triesused -= 1;
            checkIndex();
            
    }
    
    public static void checkIndex(){
        
        for (int x = 0; x<5; x++){
            char playerLetter = currentEntry.charAt(x);
            char actualLetter = hiddenWord.charAt(x);
            if(playerLetter == actualLetter){
                System.out.print(actualLetter);
                guessednum += 1;
                if (guessednum == 5){
                    
                System.out.println("\nCongrats! You have won the game \nThe game will now restart\n\n\n\n\n");
                greet();
               
                }
            } else if(hiddenWord.indexOf(playerLetter) != -1){
                System.out.print("+");
                
            }else if (hiddenWord.indexOf(playerLetter) == -1){
                
                System.out.print("*");

            }
            
        }
        askForGuess();
    
    }
    
    
    public static void main(String args[]) {
      greet();
    }
}