public class RectTest {

    public static void main(String[] args){

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(5, 10);

        //print out the values of the rectangles

        System.out.println(r1.toString());
        System.out.printf("Area of r1: ");
        System.out.println(r1.area());
        System.out.print("Perimeter of r1: ");
        System.out.println(r1.perimeter());
        System.out.println();

        System.out.println(r2.toString());
        System.out.print("Area of r2: ");
        System.out.println(r2.area());
        System.out.print("Perimeter of r2: ");
        System.out.println(r2.perimeter());
    }
}
