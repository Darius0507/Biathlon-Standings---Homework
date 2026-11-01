package org.example;

import java.util.List;

public class AthletsResults {
  private int athletNumber;
  private String name;
  private String countryCode;
  private String timeResult;
  private String firstShoot;
  private String secondShoot;
  private String thirdShoot;

  public AthletsResults(
      int athletNumber,
      String name,
      String countryCode,
      String timeResult,
      String firstShoot,
      String secondShoot,
      String thirdShoot) {

    this.athletNumber = athletNumber;
    this.name = name;
    this.countryCode = countryCode;
    this.timeResult = timeResult;
    this.firstShoot = firstShoot;
    this.secondShoot = secondShoot;
    this.thirdShoot = thirdShoot;
  }

  public String getThirdShoot() {
    return thirdShoot;
  }

  public void setThirdShoot(String thirdShoot) {
    this.thirdShoot = thirdShoot;
  }

  public String getSecondShoot() {
    return secondShoot;
  }

  public void setSecondShoot(String secondShoot) {
    this.secondShoot = secondShoot;
  }

  public String getFirstShoot() {
    return firstShoot;
  }

  public void setFirstShoot(String firstShoot) {
    this.firstShoot = firstShoot;
  }

  public String getTimeResult() {
    return timeResult;
  }

  public void setTimeResult(String timeResult) {
    this.timeResult = timeResult;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public int getNumber() {
    return athletNumber;
  }

  public void setNumber(int number) {
    this.athletNumber = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "AthletsResults{"
        + "athletNumber="
        + athletNumber
        + ", name='"
        + name
        + '\''
        + ", countryCode='"
        + countryCode
        + '\''
        + ", timeResult='"
        + timeResult
        + '\''
        + ", firstShoot='"
        + firstShoot
        + '\''
        + ", secondShoot='"
        + secondShoot
        + '\''
        + ", thirdShoot='"
        + thirdShoot
        + '\''
        + '}';
  }

  public int getTimeInSeconds() {
    String[] timeSplit = this.timeResult.split(":");
    int minutes = Integer.parseInt(timeSplit[0]);
    int seconds = Integer.parseInt(timeSplit[1]);
    return (minutes * 60) + seconds;
  }

  public int getTotalTime() {
    int missedShots = 0;
    missedShots += countMissedShoots(firstShoot);
    missedShots += countMissedShoots(secondShoot);
    missedShots += countMissedShoots(thirdShoot);

    return getTimeInSeconds() + (missedShots * 10);
  }

  private int countMissedShoots(String shoot) {
    int missedShoot = 0;
    if (shoot != null) {
      for (char s : shoot.toCharArray()) {
        if (s == 'o' || s == 'O') {
          missedShoot++;
        }
      }
    }
    return missedShoot;
  }

  public enum Standing {
    WINNER,
    RUNNER_UP,
    THIRD_PLACE
  }

  public String getStanding(Standing standing) {
    int penaltySeconds = getTotalTime() - getTimeInSeconds();
    int totalSeconds = getTotalTime();
    int minutes = totalSeconds / 60;
    int seconds = totalSeconds % 60;
    String finalTime = String.format("%02d:%02d", minutes, seconds);

    return standing.name()
        + ":"
        + this.name
        + " "
        + this.countryCode
        + ": "
        + finalTime
        + " ("
        + this.timeResult
        + " + "
        + penaltySeconds
        + "s"
        + ")";
  }

  public static void printStanding(List<AthletsResults> athletes) {
    System.out.println("Results: ");
    AthletsResults.Standing[] standings = AthletsResults.Standing.values();
    for (int i = 0; i < standings.length && i < athletes.size(); i++) {
      System.out.println(athletes.get(i).getStanding(standings[i]));
    }
  }
}
