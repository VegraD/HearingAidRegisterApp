package hearingAid;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    Scanner scn;

    public InputHandler() {
        scn = new Scanner(System.in);
    }

    public int getIntFromUser(int min, int max) {
        boolean validInt = false;
        int intFromUser = 0;

        while(!validInt) {
            try {
            intFromUser = scn.nextInt();
                if (validateInt(intFromUser, min, max)) {
                    validInt = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter an integer!");
                scn.next();
            }
        }
        return intFromUser;

    }

    public String getStringFromUser() {
        String stringFromUser = scn.next();
        scn.nextLine();
        if(validateString(stringFromUser)) {
            return stringFromUser;
        } else {
            System.err.println("Please enter a valid String!");
            return null;
        }
    }

    public String getIdStringFromUser() {
        boolean validString = false;
        String stringFromUser = "";
        while(!validString) {
            stringFromUser = scn.next();
            if (validateIdString(stringFromUser)) {
                validString = true;
                return stringFromUser;
            } else {
                System.err.println("Please enter a valid String of four digits!");
            }
        }
        return stringFromUser;
    }



    public boolean validateInt(int intFromUser, int min, int max) {
        boolean validInt = false;
            if (intFromUser >= min && intFromUser <= max) {
                validInt = true;
            } else {
                System.err.println("Please enter a valid integer between " + min + " and " + max);
            }
        return validInt;
    }

    public boolean validateString(String stringFromUser) {
        int length = stringFromUser.length();
        if(length == 0) {
            return false;
        }
        return true;
    }

    public boolean validateIdString(String stringFromUser) {
        int length = stringFromUser.length();
        if(length == 4) {
            return true;
        }
        return false;
    }
}
