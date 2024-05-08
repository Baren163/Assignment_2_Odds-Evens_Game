package nz.ac.auckland.se281;

public class RoundSet implements GameForm {
 
  private int roundNumber;
  private int numberOfEvensPlayed;
  private int numberOfOddsPlayed;
  private String playerName;

  public RoundSet() {
    this.roundNumber = 0;
    this.numberOfEvensPlayed = 0;
    this.numberOfOddsPlayed = 0;
  }

  public void incrementRoundNumber() {
    this.roundNumber ++;
  }

  public void setPlayerName(String name) {
    this.playerName = name;
  }

  public String getPlayername() {
    return this.playerName;
  }

  public int getRoundNumber() {
    return this.roundNumber;
  }

  public int getNumberOfEvensPlayes() {
    return this.numberOfEvensPlayed;
  }

  public int getNumberOfOddsPlayes() {
    return this.numberOfOddsPlayed;
  }


}