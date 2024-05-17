package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {
  
  /**
   * A part of the Factory design pattern, creates a
   * bot with a certain difficulty level
   * 
   * 
   * @param type difficulty of bot to create
   * @return a bot with given difficulty
   */
  public static Bot createBot(Difficulty type) {

    boolean redo = true;

    while (redo == true) {

      redo = false;

      switch (type) {
        case EASY:
            return new EasyBot();
    
        case MEDIUM:
            return new MedBot();
    
        case HARD:
            return new HardBot();
    
        default:
            MessageCli.INVALID_DIFFICULTY.printMessage();
            redo = true;
    }
    }
		
		return null;
	}

}
