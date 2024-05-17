package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardBot implements Bot {

  private RoundSet currentSet;

  /**
   * Generates a certain number of fingers based off the round number
   * and if the previous round was won by the bot or not.
   * 
   * @param botSide Enum type Choice either EVEN or ODD
   * @return string representation of the number of fingers to be shown
   */
  public String generateFingers(Choice botSide) {

    GenerateNumber number = new GenerateNumber(new Random());

    if (currentSet.getRoundNumber() < 4) {

      number.setStrategy(new Random());
      currentSet.setPreviousStrategy("Random");
      return number.formNumber();

    } else {
      
      if (!currentSet.getDidBotWin()) {
        if (currentSet.getPreviousStrategy().equals("Random")) {
          number.setStrategy(new Top(currentSet.getNumberOfEvensPlayed(), currentSet.getNumberOfOddsPlayed(), botSide));
          currentSet.setPreviousStrategy("Top");
        } else if (currentSet.getPreviousStrategy().equals("Top")) {
          number.setStrategy(new Random());
          currentSet.setPreviousStrategy("Random");
        }
        return number.formNumber();
      } else if (currentSet.getDidBotWin()) {
          if (currentSet.getPreviousStrategy().equals("Random")) {
            number.setStrategy(new Random());
          } else if (currentSet.getPreviousStrategy().equals("Top")) {
            number.setStrategy(new Top(currentSet.getNumberOfEvensPlayed(), currentSet.getNumberOfOddsPlayed(), botSide));
            return number.formNumber();
          }
      }

      number.setStrategy(new Top(currentSet.getNumberOfEvensPlayed(), currentSet.getNumberOfOddsPlayed(), botSide));
      currentSet.setPreviousStrategy("Top");
      return number.formNumber();
    }

  }

  public void setRoundSet(RoundSet currentSet) {
    this.currentSet = currentSet;
  }



}