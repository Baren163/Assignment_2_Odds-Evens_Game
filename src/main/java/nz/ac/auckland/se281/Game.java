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

  }

  public void play() {

    if (currentSet == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }



    currentSet.playRound();

   
  }


/**
 * Shows the current stats of the game and then calculates the winner
 * based on who won the most rounds and is a tie if won the same number.
 * Then deletes the current game.
 */
  public void endGame() {

    this.showStats();

    // PRINT_END_GAME("Player %s won the game!")
    if (currentSet.getNumberOfGamesPlayerWon() > currentSet.getNumberOfGamesBotWon()) {
      MessageCli.PRINT_END_GAME.printMessage(currentSet.getPlayerName());
    } else if (currentSet.getNumberOfGamesPlayerWon() < currentSet.getNumberOfGamesBotWon()) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else if (currentSet.getNumberOfGamesPlayerWon() == currentSet.getNumberOfGamesBotWon()) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    currentSet = null;
  }

  /**
   * Shows how many rounds each player of the current game
   * has won and lost
   */
  public void showStats() {

    if (currentSet == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // PRINT_PLAYER_WINS("%s won %s rounds and lost %s rounds")
    MessageCli.PRINT_PLAYER_WINS.printMessage(currentSet.getPlayerName(), currentSet.getNumberOfGamesPlayerWonString(), currentSet.getNumberOfGamesBotWonString());
    MessageCli.PRINT_PLAYER_WINS.printMessage("HAL-9000", currentSet.getNumberOfGamesBotWonString(), currentSet.getNumberOfGamesPlayerWonString());
  }

}