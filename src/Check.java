//imports
import java.util.regex.Pattern;

public class Check {
    void check(String guess) {

    if(!Pattern.matches("[a-zA-Z]+", guess))
        System.out.println("Enter a alphabetic character.");
    }
}
