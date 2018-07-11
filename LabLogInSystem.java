// Tianyi Yang
// CS 55 (1744)
// Project 4
// The LabLogInSystem play as a system administration, will ask user's input and to perform
// several functions such as search, login, logoff.


import java.util.Scanner;

public class LabLogInSystem {

    // class variable which can be used in each function
    // labNumber and stationNumber are class variable which stored lab number
    // and station number when search a specific number function is called
    static Scanner scnr = new Scanner(System.in);
    static int labNumber, stationNumber;


    //userOption method help main function to print MENU and return user's input
    // if user's input not between 0 to 3, the program will keep asking user until user
    // type valid input
    public static int userOption() {
        int userOption;

        System.out.println("MAIN MENU");
        System.out.println("0) Quit" + '\n' +
                "1) Simulate login" + '\n' +
                "2) Simulate logoff" + '\n' +
                "3) Search");

        userOption = scnr.nextInt();

        while (!(userOption <= 3 || userOption >= 0)) {
            System.out.println("Please Enter Number 0 to 3: ");
            userOption();
        }
        return userOption;
    }

    // log in method take array as parameter and change the elements inside the function as
    // user type valid information, teh login method will help user to record their login information
    public static void login(String[][] array) {
        int lab,station,length,ID;

        System.out.println("Enter the 5 digit ID number of the user logging in: ");
        ID = scnr.nextInt();

        System.out.println("Enter the lab number the user is logging in from (1 - 4): ");
        lab = scnr.nextInt() - 1;
        length = array[lab].length;

        System.out.println("Enter the lab number the user is logging in from(1 - " + length + "):");
        station = scnr.nextInt() - 1;

        if (array[lab][station].equals("Empty")) {
            array[lab][station] = String.valueOf(ID);
            System.out.println("User " + ID + " login in! ");
            System.out.println(" ");
        } else {
            System.out.println("This is not avaliable right now.");
            System.out.println(" ");
        }
    }

    // isHere function help login and delete function to check if the station is available for
    // a new user return true if the station is free and stored the user and station information for future use.
    public static boolean isHere(String[][] array, int user){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j].equals(String.valueOf(user))) {
                    labNumber = i + 1;
                    stationNumber = j + 1;
                    return true;
                }
            }
        }
        return false;
    }

    // delete function support logoff function to delete the user's information in array.
    // parameters are array we have and the user ID number we want to delete
    public static void delete(String[][] array, int user){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j].equals(String.valueOf(user))) array[i][j] = "Empty";
            }
        }
    }

    // logoff function take parameter array, and will ask user's ID during the function and
    // help user to logoff
    public static void logoff(String[][] array) {
        int ID;

        System.out.println("Enter the 5 digit ID number of the user to find: ");
        ID = scnr.nextInt();

        if (isHere(array, ID)) {
            delete(array, ID);
            System.out.println("User " + ID + " is logged off.");
            System.out.println(" ");
        } else {
            System.out.println("Can not find user " + ID);
            System.out.println(" ");
        }
    }

    // search function can help administrator to track if there is a specific ID in lab now
    // the function will ask administrator input a ID that want to be tracked, if there is not
    // a station associate with this ID, program will return "None".
    public static void search(String[][] array){
        int ID;

        System.out.println("Please Enter ID you want to check: ");
        ID = scnr.nextInt();

        if(isHere(array, ID)) {
            System.out.println("User " + ID + " is in ");
            System.out.println("Lab: " + labNumber);
            System.out.println("Station: " + stationNumber);
            System.out.println(" ");
        }
        else System.out.println("None");
    }

    // print function is execute once someone login or logoff and help to track
    // current situation of seat available
    public static void print(String[][] array) {
        System.out.println("LAB STATUS");
        System.out.println("Lab # Computer Stations");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < array[i].length - 1; j++) {
                System.out.print(j + 1 + ": " + array[i][j] + " ");
            }
            System.out.println(array[i].length + " : " + array[i][array[i].length - 1]);
        }
        System.out.println(" ");
    }


    public static void main(String[] args) {

        int userChoice = userOption();

        // initialize 2-D array, and put all elements as "Empty" First
        String[][] labs = {
                {"Empty", "Empty", "Empty", "Empty", "Empty"},
                {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty"},
                {"Empty", "Empty", "Empty", "Empty"},
                {"Empty", "Empty", "Empty"}
        };

        while (userChoice != 0) {

            switch (userChoice) {     // switch statement will get user's option from Menu
                                      // and make decision which function are going to be executed next step
                case (0):
                    break;
                case (1):
                    login(labs);
                    break;
                case (2):
                    logoff(labs);
                    break;
                case (3):
                    search(labs);
                    break;
            }
            print(labs);         // once a menu option is executed, the program will show current situation
            userChoice = userOption();
        }
    }
}
