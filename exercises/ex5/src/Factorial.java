/**
 * This program computes n!
 * The value of n will be supplied in the command line from the user
 */

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int n;  // Variable that stores the first argument
        int fac; // This variable will store the factorial

        // If an argument is supplied a the command line
        if(args.length > 0)
        {
            try
            {
                // Convert the string to an integer
                n = Integer.parseInt(args[0]);
                fac = 1;

                // Calculate the factorial
                for(int i = 0; n > 0; i++)
                {
                    fac *= n;
                    n--;
                }

                // print output
                System.out.printf(args[0] +"! = "+ fac + "\n");

            }
            catch (NumberFormatException e)
            {

                //  If the  first argument is not a number,
                //  System.err.println("Argument " + args[0] + " must be an integer.");
                System.exit(1);
            }
        }
        // if no argument is supplied at command line, print an error message
        else if(args.length == 0)
        {
            // Print out the error message
            System.out.println("Error: no value supplied for n");
        }
    }
}

