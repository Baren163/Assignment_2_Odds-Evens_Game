package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyBot implements Bot {

  private RoundSet currentSet;

  /**
   * Generates a random number using the random strategy.

   * @param botSide either EVEN or ODD
   * @return string representaion of random number
   */
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