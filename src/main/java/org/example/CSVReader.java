package org.example;

import javax.print.DocFlavor;
import javax.security.auth.login.AccountExpiredException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

  public List<AthletsResults> readCSV(String fileName) throws IOException {
    List<String> csvLines = Files.readAllLines(Paths.get(fileName));
    csvLines.remove(0);
    List<AthletsResults> athlets = new ArrayList<>();

    for (String line : csvLines) {
      AthletsResults athletsResults = parseCsvLine(line);
      athlets.add(athletsResults);
    }
    return athlets;
  }

  private AthletsResults parseCsvLine(String line) {
    String[] split = line.split(",");
    int athletNumber = Integer.parseInt(split[0]);
    String name = split[1];
    String countryCode = split[2];
    String timeResult = split[3];
    String firstShoot = split[4];
    String secondShoot = split[5];
    String thirdShoot = split[6];

    return new AthletsResults(
        athletNumber, name, countryCode, timeResult, firstShoot, secondShoot, thirdShoot);
  }
}
