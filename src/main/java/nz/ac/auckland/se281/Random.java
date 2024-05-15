package nz.ac.auckland.se281;

public class Random implements Strategy {

  @Override
  public String generate() {
    int botValueInt = Utils.getRandomNumberRange(0, 5);
    String botValue = String.valueOf(botValueInt);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", botValue);

    return botValue;
  }
  
}