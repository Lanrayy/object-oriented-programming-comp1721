import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataset {
    //the field of the class
    private ArrayList<Double> data = new ArrayList<>();

    //Constructor
    public Dataset(String fileName) throws IOException {
        //create a path object to the file
        //System.out.println("Getting path...");
        Path path = Paths.get(fileName);

        // declaring a new scanner called input and reading from file using the path
        //System.out.println("Creating scanner...");
        Scanner input = new Scanner(path);

        // read every double from the file whilst there is a double
        while (input.hasNextDouble()) {
            //System.out.println(line);
            //store the data into the ArrayList
            data.add(input.nextDouble());
        }
        input.close();
    }

    //other methods
    //this method returns the number

    //this method returns the number of items in the list
    public int size(){
        int s = data.size();
        return s;
    }

    public double meanValue(){
        //the variables use in this method
        double sum;
        double value;
        double average;
        sum = 0.0;

        //throw an exception if there are no stored values
        if(data.size() == 0){
            throw new ArithmeticException("No Data Available");
        }

        for(int i = 0; i < data.size(); i++){
            value = data.get(i);
            sum += value;
        }
        average = sum / data.size();
        return average;
    }

}
