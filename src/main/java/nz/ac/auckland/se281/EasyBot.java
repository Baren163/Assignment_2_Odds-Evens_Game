package nz.ac.auckland.se281;

public class EasyBot implements Bot {

  public String generateFingers() {

    int botValueInt = Utils.getRandomNumberRange(1, 5);
    String botValue = String.valueOf(botValueInt);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", botValue);

    return botValue;
  }


  
}
