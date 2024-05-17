package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Top implements Strategy {

  private int numberEvensPlayed;
  private int numberOddsPlayed;
  private Choice botSide;

  public Top(int numberEvensPlayed, int numberOddsPlayed, Choice botSide) {
    this.numberEvensPlayed = numberEvensPlayed;
    this.numberOddsPlayed = numberOddsPlayed;
    this.botSide = botSide;
  }
  
  /**
   * Generates a random even number between 0 and 5 if the
   * number of evens played is greater than the number of
   * odds playes and generates a random odd number between
   * 0 and 5 otherwise unless the evens and odds are equal
   * in which case it will generate a random number between
   * 0 and 5
   */
  @Override
  public String generate() {

    if (numberOddsPlayed > numberEvensPlayed) {
      if (botSide.equals(Choice.ODD)) {
        int botValueInt = Utils.getRandomEvenNumber();
        String botValue = String.valueOf(botValueInt);
  
        return botValue;
      } else if (botSide.equals(Choice.EVEN)) {
        int botValueInt = Utils.getRandomOddNumber();
        String botValue = String.valueOf(botValueInt);
  
        return botValue;
      }
    } else if (numberEvensPlayed > numberOddsPlayed) {
      if (botSide.equals(Choice.ODD)) {
        int botValueInt = Utils.getRandomOddNumber();
        String botValue = String.valueOf(botValueInt);
  
        return botValue;
      } else if (botSide.equals(Choice.EVEN)) {
        int botValueInt = Utils.getRandomEvenNumber();
        String botValue = String.valueOf(botValueInt);
  
        return botValue;
      }
    } else if (numberEvensPlayed == numberOddsPlayed) {
      int botValueInt = Utils.getRandomNumberRange(0, 5);
      String botValue = String.valueOf(botValueInt);
  
      return botValue;
    }

    return "Error in Top.java";
  }
   


}


