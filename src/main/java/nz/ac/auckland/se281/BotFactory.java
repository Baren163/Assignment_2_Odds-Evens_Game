package nz.ac.auckland.se281;

public class BotFactory {
  
  public static Bot createBot(String type) {

    boolean redo = true;
    
    while (redo == true) {

      redo = false;

      switch (type) {
      case "EASY":
      return new EasyBot();

      case "MEDIUM":
      return new MedBot();

      case "HARD":
      return new HardBot();

      default:
      MessageCli.INVALID_DIFFICULTY.printMessage();
      redo = true;
      }
    }
		
		return null;
	}

}
