import java.util.Scanner;
/**
 * This program will prompt the user for a temperature in fahrenheit
 * It will then convert that value to Celsius
 * Then Display the temperature in celsius back to the user
 */
public class Temperature
{

    public static void main(String[] args)
    {
        // Declaring a variable called "stdin" of type Scanner
        // This variable will be used to get input from the user
        Scanner stdin = new Scanner( System.in );


        // Declaring the variables used in the program
        double fahrenheitTemp; // This variable will hold the value for temperature
        double celsiusTemp; // This variable will hold the value for Celsius

        // Prompt the user for temperature in fahrenheit
        // Store the temperature in a variable
        System.out.print("Enter fahrenheit temperature: ");
        fahrenheitTemp = stdin.nextDouble();


        // Convert the temperature in Celsius
        // Store the Celsius Values in a variable
        celsiusTemp = (((fahrenheitTemp - 32) * 5) / 9);

        // Print out the result for the user
        System.out.print("Equivalent Celsius temperature: ");
        System.out.println(celsiusTemp);
    } // End of Main Class
} // End of Temperature Class
