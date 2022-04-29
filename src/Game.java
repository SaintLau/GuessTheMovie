//imports
import java.util.Scanner;
import java.util.regex.Pattern;

/*
java.util.regex.Pattern -> Classes for matching character sequences against patterns specified by regular expressions.
An instance of the Pattern class represents a regular expression that is specified in string form in a syntax similar to that used by Perl.
Instances of the Matcher class are used to match character sequences against a given pattern. Input is provided to matchers via the
CharSequence interface in order to support matching against characters from a wide variety of input sources.
Unless otherwise noted, passing a null argument to a method in any class or interface in this package will cause a NullPointerException to be thrown.
 */

//main Game class
public class Game {
    //vars only for this class
    private int numGuess = 0;
    private int numLoop = 0;
    private boolean hadGuessedThatLetter = false;

    //Method to start the game
    public void Start(String selectedMovie){
        String hidden = new String(new char[selectedMovie.length()]).replace('\0', '_'); //replace the char in the movie name where is a '_'
        String guessLetter = "";
        String movieToGuess = selectedMovie;

        //Start game
        System.out.println("Are you able to guess this movie title?");

        //Titles without spaces or colons or other
        char[] noNeedChar = {':', ' ', '.', ','};

        movieToGuess = movieToGuess.replace(':', '_');
        movieToGuess = movieToGuess.replace(' ', '_');
        movieToGuess = movieToGuess.replace('.', '_');
        movieToGuess = movieToGuess.replace(',', '_');

        Scanner scanner = new Scanner(System.in);

        //Start game loop
        for(int i = 20; i > 0; i--) { //20 -> number of guesses to find the word
            System.out.println("You have " + i + " guess(es) left. Choose again: ");
            System.out.println("Type a letter inside the box. Only one letter will count. If you write more than one, the first is what counts");
            System.out.println("You guessed " + guessLetter + " so far");
            System.out.println("Your total of " + numGuess + " guesses.");
            System.out.println("Current word " + hidden);

            //System.out.println(selectedMovie);
            //System.out.println("Fix movie " + movieToGuess);

            String guess = scanner.nextLine();
            char currentGuess = guess.charAt(0);

            if(Pattern.matches("[a-zA-Z]+", guess)){
                //if already guess once, check its not same letter/char
                for(int x = 1; x <= numLoop; x++){
                    if(currentGuess == guessLetter.charAt(x - 1)) {
                        System.out.println("You already guessed this one " + currentGuess);
                        i++;
                        numGuess++;
                        hadGuessedThatLetter = true;
                        break;
                    } else {
                        hadGuessedThatLetter = false;
                    }
                }
            } //end of char loop

            /*
            letter was already guessed, check where it is and where in the word
             */

            if(!hadGuessedThatLetter) {
                for(int y = 0; y <= selectedMovie.length() - 1; y++) {
                    char current = selectedMovie.charAt(y);

                    //to lowercase
                    currentGuess = Character.toLowerCase(currentGuess);
                    if(current == currentGuess){
                        System.out.println("You found a letter!");
                        char[] hiddenChar = hidden.toCharArray();
                        hiddenChar[y] = current;
                        hidden = String.valueOf(hiddenChar);
                    }
                    //to uppercase
                    currentGuess = Character.toUpperCase(currentGuess);
                    if(current == currentGuess){
                        System.out.println("You found a letter!");
                        char[] hiddenChar = hidden.toCharArray();
                        hiddenChar[y] = current;
                        hidden = String.valueOf(hiddenChar);
                    }
                }
                guessLetter = guessLetter + currentGuess + ", ";
                numGuess++;
                numLoop++;
            }

            if(movieToGuess.equals(hidden)){
                System.out.println("YOU WIN!");
                System.out.println("The movie was " + selectedMovie);
                break;
            } else {
                System.out.println("Enter a new letter");
                i++;
            }

            if(!movieToGuess.equals(hidden)){
                System.out.println("You lose...better luck next time");
            }
        } //end of game loop
    }
}
