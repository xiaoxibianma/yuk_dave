//
// Tianyi Yang
// CS 55
// 07-02-2018
// Project 3 is a game project which get user's input and against computer's
// random result
//

import java.util.Scanner;

public class Project3 {

    static Scanner scnr = new Scanner(System.in);

    // userChoice method will ask user to enter one of 3 game options and return as a char type
    public static char userChoice() {

        String choise;
        System.out.print("Please Enter your decision: ");
        choise = scnr.nextLine();

        switch (choise.toLowerCase()) {
            case ("rock"):
                return 'r';

            case ("paper"):
                return 'p';

            case ("scissors"):
                return 's';

            // if user's input is invalid, the program will keep ask the user to enter valid option
            default:
                System.out.println("Invalid Input! ");
                return (userChoice());
        }
    }

    // computerChoice() method will generate a random number from 1 to 3 and later transform them
    // to a char type which represent one of 3 game options
    public static char computerChoice() {

        int random = (int) (Math.random() * 3 + 1); //generate a number from 1-3

        if (random == 1) return 'r';
        else if (random == 2) return 'p';
        else if (random == 3) return 's';
        else return 'X';
    }

    // determineWinner() method accept two parameters which are user's option and computer random option
    // and decide the final winner or draw between user and computer
    public static void determineWinner(char user, char computer) {
        int decision = compare(user, computer);

        if (decision == 0) System.out.println("Draw, There is no winner.");
        else if (decision == 1) System.out.println("Congratulations! You won!");
        else if (decision == -1) System.out.println("Unfortunately, You lose the game!");
        else System.out.println("Woops, Something going wrong in Project");
    }

    // compare function doing as a referee who make the rules for the game
    // 2 parameters are user's option and computer's option, if user won, return 1, lose return -1, and
    // draw return 0. If the program return 5, that's mean the random function has the problem.
    public static int compare(char user, char computer) {

        int wrong = 5;

        if ((user - computer) == 0) return 0;
        if (user == 'r') {
            if (computer == 's') return 1;
            else return -1;
        } else if (user == 's') {
            if (computer == 'p') return 1;
            else return -1;
        } else if (user == 'p') {
            if (computer == 'r') return 1;
            else return -1;
        }
        else return wrong;

    }
    // playAgain method will ask user to decide to play one more time or not
    // if the player provide invalid input(not 1 or 0) the program will keep asking
    // user until providing valid input.
    public static boolean playAgain() {
        System.out.println("Enter 1 to play again, O to quite : ");;
        String i = scnr.nextLine();
        try{
            if (Integer.parseInt(i)==0) return false;
            else if (Integer.parseInt(i)==1) return true;
            else {
                throw new NumberFormatException();
               }
           } catch (NumberFormatException reEnter) {
                System.out.println("Only 1 or 0 is valid input! ");
                return playAgain();

        }
    }

    public static void main(String[] args) {

        char userAnswer;
        char computerAnswer;
        boolean playAgain = true;

        System.out.println("Welcome to Game !"); // welcome words when first enter the game
        System.out.println("You have choice enter either \"rock\", \"paper\", and \"scissors\".");

        // while player want to keep playing the game, it will keep asking user's input and against computer.
        // the program will end once player enter 0.
        while(playAgain){
            userAnswer = userChoice();
            computerAnswer = computerChoice();
            determineWinner(userAnswer, computerAnswer);
            playAgain = playAgain();

        }
    }
}





