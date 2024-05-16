package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardBot implements Bot {
  public String generateFingers(int roundNumber, int numberEvensPlayed, int numberOddsPlayed, Choice botSide) {

    // Needs to check

    int botValueInt = Utils.getRandomNumberRange(1, 5);
    String botValue = String.valueOf(botValueInt);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", botValue);

    return botValue;
  }

}
