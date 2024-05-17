package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyBot implements Bot {

  private RoundSet currentSet;

  public String generateFingers(Choice botSide) {
    if (currentSet.getRoundNumber() >= 0) {
    GenerateNumber number = new GenerateNumber(new Random());
    return number.formNumber();
    }
    return "";
  }

  public void setRoundSet(RoundSet currentSet) {
    this.currentSet = currentSet;
  }

  

}