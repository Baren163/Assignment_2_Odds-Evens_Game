package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardBot implements Bot {

  public String generateFingers(int roundNumber, int numberEvensPlayed, int numberOddsPlayed, Choice botSide) {

    GenerateNumber number = new GenerateNumber(new Random());

    if (roundNumber < 4) {

      return number.formNumber();

    } else {
      
      // if (We lost the previous round) {
        // if (previous strategy was Random) {
          // setStrategy(Top)
        // } else if (previous strategy was Top) {
          // setStrategy(Random)
        // }
        // return number.formNumber();
      // } else if (We won the previous round) {
        // setStrategy (previous strategy)
        // return number.formNumber();
      // }

      number.setStrategy(new Top(numberEvensPlayed, numberOddsPlayed, botSide));
      return number.formNumber();
    }

  }


}