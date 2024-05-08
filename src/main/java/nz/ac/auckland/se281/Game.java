package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  RoundSet currentSet;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    currentSet = new RoundSet();
  }

  public void play() {

    currentSet.incrementRoundNumber();

    MessageCli.START_ROUND.printMessage(String.valueOf(currentSet.getRoundNumber()));
    MessageCli.ASK_INPUT.printMessage();

    String input = Utils.scanner.nextLine();

    if (!Utils.isInteger(input)) {
      MessageCli.INVALID_INPUT.printMessage();
    }

  }

  public void endGame() {





    currentSet = null;
  }

  public void showStats() {}
}

