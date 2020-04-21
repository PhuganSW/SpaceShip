import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class KeyIn extends KeyAdapter{
  Player play;
  public KeyIn(Player play){
    this.play = play;
  }
  @Override
  public void keyPressed(KeyEvent e){
    play.keyPressed(e);
  }
  @Override
  public void keyReleased(KeyEvent e){
    play.keyReleased(e);
  }
}
