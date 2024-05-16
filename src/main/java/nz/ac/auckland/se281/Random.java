package nz.ac.auckland.se281;

public class Random implements Strategy {

  @Override
  public String generate() {
    int botValueInt = Utils.getRandomNumberRange(0, 5);
    String botValue = String.valueOf(botValueInt);

    return botValue;
  }
  
}