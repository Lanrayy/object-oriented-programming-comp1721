/**
 * This program creates a temperature conversion table from fahrenheit to celcius
 * It will print the Fahrenheit temperature in the first column
 * And Celsius Temperatures in the second column
 */

public class TempTable {
    public static void main(String[] args)
    {
        // Declare variables that will be used in the program
        double celsiusTemp = 0;
        double fahrTemp = 20;

        // Print out the head of the table
        System.out.printf("+---------+---------+\n");
        System.out.print("|     \u00b0F  |     \u00b0C  |\n");
        System.out.printf("+---------+---------+\n");

        // Use a while loops to generate the temperature
        // And print out each row of the table in the while loop
        while(fahrTemp <= 100)
        {
            celsiusTemp = (((fahrTemp - 32) * 5) / 9);
            System.out.printf("|%7.1f  |%7.1f  |\n", fahrTemp ,celsiusTemp);
            fahrTemp +=5;
        }

        // Print out the end of the table
        System.out.printf("+---------+---------+\n");



    }
}
