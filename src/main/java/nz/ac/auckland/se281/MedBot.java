package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MedBot implements Bot {

  private RoundSet currentSet;

  public String generateFingers(Choice botSide) {

    GenerateNumber number = new GenerateNumber(new Random());

    if (currentSet.getRoundNumber() < 4) {
      return number.formNumber();
    } else {
      number.setStrategy(new Top(currentSet.getNumberOfEvensPlayed(), currentSet.getNumberOfOddsPlayed(), botSide));
      return number.formNumber();
    }


  }

  public void setRoundSet(RoundSet currentSet) {
    this.currentSet = currentSet;
  }

}