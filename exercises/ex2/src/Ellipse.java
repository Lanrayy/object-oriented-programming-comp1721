import java.util.Scanner;
/**
 * This Program will calculate the value of the Area and Eccentricity of an Ellipse
 * From length values obtained from the user
 */
public class Ellipse {
    public static void main(String[] args){
        // This variable will be used to get input from the user
        Scanner stdin = new Scanner( System.in );

        // Declaring Variables to be used in the program
        double axisA; // This variable stores the value of semi-major axis-a
        double axisB; // This variable stores the value of semi-minor axis-b
        double area;  // This variable stores the value of the area
        double eccentricity; // This variable stores the value of eccentricity

        // Prompt user for semi-major axis a
        // Store values in a variable
        System.out.print("Please enter the length of the semi-major axis-a: ");
        axisA = stdin.nextDouble();


        // Prompt user for semi-minor axis b
        // Store value in a variable
        System.out.print("Please enter the length of the semi-minor axis-b: ");
        axisB = stdin.nextDouble();


        // Use formula to calculate area
        // Store value in a variable
        area = Math.PI * axisA * axisB;

        // Use formula to calculate Eccentricity
        // Store value in a variable
        eccentricity = Math.sqrt(1 - ((axisB * axisB) / (axisA * axisA)));


        // Display the values of area to three decimal places
        System.out.print("Area: ");
        System.out.printf("%.3f \n", area);

        // Display the values of area to three decimal places
        System.out.print("Eccentricity: ");
        System.out.printf("%.3f \n",eccentricity);


    }

}
