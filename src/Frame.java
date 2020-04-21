import javax.swing.*;
import java.awt.*;
public class Frame{
  public static final int WIDTH = 480;
  public static final int HIGHT = 650;
  public static void main(String[] args) {
    JFrame window = new JFrame("Space Ship");
    window.setSize(WIDTH,HIGHT);
    window.setResizable(false);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.add(new Game());
    window.setVisible(true);
    window.setLocation(480,50);
  }
}
