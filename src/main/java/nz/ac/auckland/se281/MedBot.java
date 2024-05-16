package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MedBot implements Bot {

  public String generateFingers(int roundNumber, int numberEvensPlayed, int numberOddsPlayed, Choice botSide) {

    GenerateNumber number = new GenerateNumber(new Random());

    if (roundNumber < 4) {
      return number.formNumber();
    } else {
      number.setStrategy(new Top(numberEvensPlayed, numberOddsPlayed, botSide));
      return number.formNumber();
    }


  }

}
