package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyBot implements Bot {

  public String generateFingers(int roundNumber, int numberEvensPlayed, int numberOddsPlayed, Choice botSide) {
    GenerateNumber number = new GenerateNumber(new Random());
    return number.formNumber();
  }


}