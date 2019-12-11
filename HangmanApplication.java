package PetProjects.Hangman;

import java.io.IOException;
import java.util.Scanner;

public class HangmanApplication {

    public static void main(String[] args) throws IOException {
        // How do we play the game
        Scanner scr = new Scanner(System.in);
        System.out.println("Welcome to the Hangman game!" +
                "I will pick a word and you will try to guess it character by character" +
                "If you will fail 6 times, then I win");
        System.out.println();
        System.out.println("I have picked my word \n" +
                "Below is a picture, and below that is you current guess" +
                "which starts off with nothing \n" +
                "Every time you guess incorrectly \n" +
                "I add body parts to the picture \n" +
                "When there's a full person \n" +
                "you lose");
        boolean doYouWantToPlay = true;
        while(doYouWantToPlay) {
            // Setting up the game
            System.out.println();
            System.out.println("Let's play!");
            Hangman game = new Hangman();
            System.out.println();
            do {
                // Draw
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
               // The hint 
                // System.out.println(game.mysteryWord);

                // Get the guess
                // possibly a method to be called
                System.out.println("Enter your letter to guess a word");
                char guess = (scr.next().toLowerCase()).charAt(0);
                System.out.println();

                // Check if character is guessed already
                while(game.isGuessedAlready(guess)) {
                    System.out.println("Sorry, already guessed! \n" +
                            "Try again!");
                    guess = (scr.next().toLowerCase()).charAt(0);
                }
                // Playing the guess
                if(game.playGuess(guess)) {
                    System.out.println("Good Guess!");
                } else {
                    System.out.println("Close, but try again!");
                }



                System.out.println();
            }
            while(!game.gameOver()); // keep playing while the game is not over


            //keep playing
            System.out.println();
            System.out.println("Do you want to play another game?" +
                    "Enter 'Y' if you do");
            Character response = (scr.next().toUpperCase().charAt(0));
            doYouWantToPlay = (response == 'Y');
        }


    }

}
