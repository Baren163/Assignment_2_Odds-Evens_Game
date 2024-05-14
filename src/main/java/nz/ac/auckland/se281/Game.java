package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  

  RoundSet currentSet;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);


    currentSet = new RoundSet(choice, difficulty, options[0]);

    currentSet.setPlayerName(options[0]);
  }

  public void play() {

    if (currentSet == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    currentSet.incrementRoundNumber();

    // START_ROUND("Start Round #%s:")
    MessageCli.START_ROUND.printMessage(String.valueOf(currentSet.getRoundNumber()));

    currentSet.playRound();

   
  }

  public void endGame() {





    currentSet = null;
  }

  public void showStats() {}
}

