public class Rectangle {
    //Define the class fields
    private double width; // width of the rectangle
    private double height; // height of the rectangle

    //Define the constructors
    public Rectangle(){ //Default constructor
        width = 1.0;
        height = 1.0;
    }

    public Rectangle(double w, double h){ //Overload - two parameters
        if(w <= 0){
            throw new IllegalArgumentException("Error: Invalid width (must be > 0)");
        };

        if(h<= 0){
            throw new IllegalArgumentException("Error: Invalid height(must be > 0)");
        }
        width = w;
        height = h;
        }


    //Define the getter methods
    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    //Define setters
    public void setWidth(double w){ // method that sets width to given parameter value
        width = w;
    }

    public void setHeight(double h){
        height = h;
    }


    //Other methods
    //the area method
    public double area(){
        return width * height;
    }

    //perimeter method
    public double perimeter(){
        return width + width + height + height;
    }

    //to string method
    //this method will override the default string behaviour of the class
    @Override
    public String toString() {
        // changes default behaviour to e.g. Rectangle: 1.033 x 5.033
        return String.format("Rectangle: %.3f x %.3f",width, height);
    }
}
