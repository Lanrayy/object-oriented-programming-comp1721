import java.util.Scanner;
import java.lang.Character;

//This program asks user for a password
//The checks the password, whether it is valid or invalid
//Then display a suitable message telling the user whether it is valid or not
//For a password to be valid it should contain:
//At least 10 characters
//At least two lowercase letters
//At least two uppercase letters
//At least two digits


public class PasswordCheck {

    public static void main(String[] args) {
        System.out.println("The program is working");

        //Prompt User to input password to be checked
        System.out.println("Please input a password: ");
        Scanner stdin = new Scanner(System.in);
        String password = stdin.nextLine();

        //Check the password
        //And display the correct messages
        if(checkCharacters(password)&&
        checkLowerCase(password)&&
        checkUpperCase(password)&&
        checkDigit(password)){
            System.out.println("Your password is valid");
        } else{
            System.out.println("Your password is invalid");
        }

    }

    //ERROR CHECKING METHODS

    //this method checks that the password is greater than 10 characters
    private static boolean checkCharacters(String a) {
        return a.length() >= 10;
    }
    //this method checks that the password has at least two lower case character
    private static boolean checkLowerCase(String b) {
        int count = 0;
        // Convert each character of the sting
        //Check if it is lowercase and increment a counter
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);

            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        //if the count is grater than or equal to 2 then return true
        if (count >= 2) {
            return true;
        } else {
            return false;
        }
    }

    //this method checks that the password has at least two Upper case characters
    private static boolean checkUpperCase(String b) {
        int count = 0;
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);

            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count >= 2;
    }

    //this method checks that there are at least two digits
    private  static boolean checkDigit(String b){
        int count = 0;

        for (int i = 0; i <b.length(); i++){
            char c = b.charAt(i);

            if(Character.isDigit(c)){
                count++;
            }
        }

        return count >= 2;
    }
}
