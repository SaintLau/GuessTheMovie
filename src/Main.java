//imports
import java.util.Scanner;
import java.io.File;

/* file and directory names have different formats on different platforms, a simple string is not adequate to name them.
The File class contains several methods for working with the pathname, deleting and renaming files, creating new directories,
listing the contents of a directory, and determining several common attributes of files and directories.
*/

public class Main {

    public static void main(String[] args) throws Exception {
        //Global vars
        int numOfMovies = 0;
        int randomMovie = 0;
        String selectedMovie = "";
        String movies = "";

        //Init Classes
        File movieFile = new File("movies.txt");
        Scanner scanner = new Scanner (movieFile);

        //get number of movies
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            movies += (line + "\n");
            numOfMovies++;
        }
        //Test numOfMovies
        System.out.println("Number of Movies: " + numOfMovies);

        //Get random movie number
        randomMovie = (int) (Math.random() * numOfMovies);

        //Get randomMovie form txt
        System.out.println("Random movie: " + randomMovie);



        //Get a Movie:
        File movieFile2 = new File("movies.txt");
        Scanner scanner2 = new Scanner(movieFile2);

        int i = 0;

        while (i <= randomMovie) {
            selectedMovie = scanner2.nextLine();
            i++;
        }
        //Check if we get a movie:
       // System.out.println(selectedMovie);

        //Game Init
        Game game = new Game();
        game.Start(selectedMovie);
    }
}
