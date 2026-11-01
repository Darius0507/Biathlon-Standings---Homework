package org.example;

import java.io.IOException;
import java.util.List;

import static org.example.AthletsResults.printStanding;

public class Main {
  static void main() throws IOException {

    CSVReader csvReader = new CSVReader();
    List<AthletsResults> athletsResults = csvReader.readCSV("src/main/resources/Players.csv");
    System.out.println(athletsResults);

    AthletsComparator athletsComparator = new AthletsComparator();
    athletsResults.sort(athletsComparator);
    printStanding(athletsResults);
  }
}
