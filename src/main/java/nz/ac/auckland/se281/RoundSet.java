package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class RoundSet {
 
  private int roundNumber;
  private int numberOfEvensPlayed;
  private int numberOfOddsPlayed;
  private String playerName;

  private Choice playerChoice;
  private Choice botChoice;

  private Difficulty botDifficulty;

  private String previouStrategy;
  private boolean didBotWin;

  private int numberOfGamesPlayerWon;
  private int numberOfGamesBotWon;

  /**
  * Constructor for the RoundSet class that sets the game up to be played by
  * taking in the players choice, the difficulty level of bot and the players
  * name.

  * @param choice Enum Choice of either EVEN or ODD
  * @param difficulty Enum Difficulty of either EASY, MEDIUM or HARD
  * @param playerName players name
  */
  public RoundSet(Choice choice, Difficulty difficulty, String playerName) {
    this.playerChoice = choice;
    this.botDifficulty = difficulty;
    this.playerName = playerName;
    if (this.playerChoice.equals(Choice.EVEN)) {
      this.botChoice = Choice.ODD;
    } else if (this.playerChoice.equals(Choice.ODD)) {
      this.botChoice = Choice.EVEN;
    }

    this.roundNumber = 0;
    this.numberOfEvensPlayed = 0;
    this.numberOfOddsPlayed = 0;
  }

  /**
  * Plays through a full round of the game even or odd by
  * incrementing the round number to start and then reading in
  * a value of fingers for the player, then the bot and
  * calculating who won.
  */
  public void playRound() {

    this.roundNumber++;

    // START_ROUND("Start Round #%s:")
    MessageCli.START_ROUND.printMessage(String.valueOf(this.roundNumber));

    // ASK_INPUT("Give <fingers> and press enter")
    MessageCli.ASK_INPUT.printMessage();

    boolean validNumberGiven = false;
    String input = null;
    int inputInt = -1;

    while (!validNumberGiven) {

      input = Utils.scanner.nextLine();

      try {
        inputInt = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
        validNumberGiven = false;
      }

      if (!Utils.isInteger(input)) {
        MessageCli.INVALID_INPUT.printMessage();
        validNumberGiven = false;
      }
      
      if (inputInt > 5 | inputInt < 0) {
        MessageCli.INVALID_INPUT.printMessage();
        validNumberGiven = false;
      }

      if (inputInt <= 5 & inputInt >= 0) {
        validNumberGiven = true;
      }
    }


    // PRINT_INFO_HAND("Player %s: fingers: %s")
    MessageCli.PRINT_INFO_HAND.printMessage(this.playerName, input);

    if (this.botDifficulty.equals(Difficulty.HARD)) {

      Bot computer = new HardBot();

      computer.setRoundSet(this);

    }

    Bot computer = BotFactory.createBot(this.botDifficulty);

    computer.setRoundSet(this);

    String botFingers = computer.generateFingers(this.botChoice);

    
    // PRINT_INFO_HAND("Player %s: fingers: %s")
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", botFingers);

    // Find winner of round
    int sum = Integer.valueOf(botFingers) + inputInt;

    String sumString = String.valueOf(sum);
    String winner;
    String winningSide = "";

    if (Utils.isEven(sum) && this.playerChoice.equals(Choice.EVEN) || Utils.isOdd(sum) && this.playerChoice.equals(Choice.ODD)) {
      winner = this.playerName;
      this.numberOfGamesPlayerWon++;
      winningSide = String.valueOf(this.playerChoice);
    } else {
      winner = "HAL-9000";
      this.numberOfGamesBotWon++;
      if (this.playerChoice.equals(Choice.EVEN)) {
        winningSide = "ODD";
      } else if (this.playerChoice.equals(Choice.ODD)) {
        winningSide = "EVEN";
      }
    }

    // PRINT_OUTCOME_ROUND("The sum is : %s, is %s, player %s wins!")
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(sumString, winningSide, winner);


    if (Utils.isEven(inputInt)) {
      this.numberOfEvensPlayed++;
    } else if (Utils.isOdd(inputInt)) {
      this.numberOfOddsPlayed++;
    }

    if (winner.equals("HAL-9000")) {
      this.didBotWin = true;
    } else {
      this.didBotWin = false;
    }
  }

  public void setPreviousStrategy(String strategy) {
    this.previouStrategy = strategy;
  }

  public String getPreviousStrategy() {
    return this.previouStrategy;
  }

  public boolean getDidBotWin() {
    return this.didBotWin;
  }

  public String getPlayerName() {
    return this.playerName;
  }

  public int getRoundNumber() {
    return roundNumber;
  }

  public int getNumberOfEvensPlayed() {
    return numberOfEvensPlayed;
  }

  public int getNumberOfOddsPlayed() {
    return numberOfOddsPlayed;
  }

  public String getNumberOfGamesPlayerWonString() {
    return String.valueOf(this.numberOfGamesPlayerWon);
  }

  public String getNumberOfGamesBotWonString() {
    return String.valueOf(this.numberOfGamesBotWon);
  }

  public int getNumberOfGamesPlayerWon() {
    return this.numberOfGamesPlayerWon;
  }

  public int getNumberOfGamesBotWon() {
    return this.numberOfGamesBotWon;
  }
  
}