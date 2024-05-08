package nz.ac.auckland.se281;

public class RoundSet implements GameForm {
 
  private int roundNumber;
  private int numberOfEvensPlayed;
  private int numberOfOddsPlayed;

  public RoundSet() {
    this.roundNumber = 0;
    this.numberOfEvensPlayed = 0;
    this.numberOfOddsPlayed = 0;
  }

  public void incrementRoundNumber() {
    this.roundNumber ++;
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