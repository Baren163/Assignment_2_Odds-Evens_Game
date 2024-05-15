package nz.ac.auckland.se281;

public class EasyBot implements Bot {

  public String generateFingers(int roundNumber) {
    GenerateNumber number = new GenerateNumber(new Random());
    return number.formNumber();
  }


}