package nz.ac.auckland.se281;

public class MedBot implements Bot {
  public String generateFingers(int roundNumber) {

    GenerateNumber number = new GenerateNumber(new Random());

    if (roundNumber < 4) {
      return number.formNumber();
    } else {
      number.setStrategy(new Top());
      return number.formNumber();
    }


  }

}
