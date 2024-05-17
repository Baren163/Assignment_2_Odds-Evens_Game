package nz.ac.auckland.se281;

public class GenerateNumber {

  private Strategy strategy;

  public GenerateNumber(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public String formNumber() {
    return strategy.generate();
  }

  
}