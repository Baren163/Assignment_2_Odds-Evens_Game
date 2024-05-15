package nz.ac.auckland.se281;

public class EasyBot implements Bot {

  public String generateFingers() {
    GenerateNumber number = new GenerateNumber(new Random());
    return number.formNumber();
  }


}