package comp1721.cwk1;


import java.io.IOException;

public class ActiveCases {
  // Implement program for full solution here

  public static void main(String[] args) throws IOException {

    try {
      //check if the correct number of command line arguments are given
      if (args.length != 2) {
        System.out.println("\nUsage: ActiveCases <filename> <filename>\n");
        throw new DatasetException("Error: no filenames provided");
      }

      CovidDataset Leeds = new CovidDataset();
      Leeds.readDailyCases(args[0]);
      Leeds.writeActiveCases(args[1]);
      System.out.println(Leeds.size());

    } catch (DatasetException a) {
      System.out.println(a);
    }


  }
}
