import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class RectTest {

    public static void main(String[] args){
        try{
            //create an object of the rectangle class
            Rectangle r1 = new Rectangle();
            Rectangle r2 = new Rectangle(4, 10);

            //get input from the user
            Scanner input = new Scanner(System.in);

            System.out.print("Please enter the width: ");
            Double width = input.nextDouble();

            System.out.print("Please enter the height: ");
            Double height = input.nextDouble();

            Rectangle r3 = new Rectangle(width,height);

            //print out the values of the rectangle1
            System.out.println("Rectangle 1");
            System.out.println(r1.toString());
            System.out.printf("Area of r1: ");
            System.out.println(r1.area());
            System.out.print("Perimeter of r1: ");
            System.out.println(r1.perimeter());
            System.out.println();

            //print out the values of the rectangle2
            System.out.println("Rectangle 2");
            System.out.println(r2.toString());
            System.out.print("Area of r2: ");
            System.out.println(r2.area());
            System.out.print("Perimeter of r2: ");
            System.out.println(r2.perimeter());

            //print out the values of the rectangle3
            System.out.println("Rectangle 3");
            System.out.println(r3.toString());
            System.out.print("Area of r3: ");
            System.out.println(r3.area());
            System.out.print("Perimeter of r3: ");
            System.out.println(r3.perimeter());
        }
        catch(IllegalArgumentException error){ //name the exception object that was thrown

            //error.getMessage() allows us to only see the message without the stack trace
            System.out.println(error.getMessage()); // prints out the error message
        }
        catch(InputMismatchException b){
            System.out.println("Error: numbers required for width and height!");
        }

    }
}
