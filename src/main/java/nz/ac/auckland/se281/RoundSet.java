package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class RoundSet implements GameForm {
 
  private int roundNumber;
  private int numberOfEvensPlayed;
  private int numberOfOddsPlayed;
  private String playerName;

  private Choice playerChoice;
  private Choice botChoice;

  private Difficulty botDifficulty;

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
      } if (inputInt > 5 | inputInt < 0) {
        MessageCli.INVALID_INPUT.printMessage();
        validNumberGiven = false;
      }

      if (inputInt <= 5 & inputInt >= 0) {
        validNumberGiven = true;
      }
    }
    // If you have made it here then you have a valid human finger amount as a string in variable input
    //and as an int in inputInt

    // PRINT_INFO_HAND("Player %s: fingers: %s")
    MessageCli.PRINT_INFO_HAND.printMessage(this.playerName, input);

    Bot computer = BotFactory.createBot(this.botDifficulty);

    String botFingers = computer.generateFingers(this.roundNumber, this.numberOfEvensPlayed, this.numberOfOddsPlayed, this.botChoice);

    // PRINT_INFO_HAND("Player %s: fingers: %s")
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", botFingers);

    // Find winner of round
   int sum = Integer.valueOf(botFingers) + inputInt;

   String sumString = String.valueOf(sum);
   String winner;
   String winningSide = "ODD";

    if (Utils.isEven(sum) && this.playerChoice.equals(Choice.EVEN) || Utils.isOdd(sum) && this.playerChoice.equals(Choice.ODD)) {
      winner = this.playerName;
      winningSide = String.valueOf(this.playerChoice);
    } else {
      winner = "HAL-9000";
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
  }

}