package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface Bot {
  
  public String generateFingers(Choice botSide);

  public void setRoundSet(RoundSet currentSet);

}
