import java.util.*;
import java.awt.*;
import javax.swing.*;
public class BullMove{
  static ArrayList<Bullet> b = new ArrayList<Bullet>();
  Bullet temp;
  Player player;
  public BullMove(){
    //addBull(new Bullet(player.getX(),player.getY()));
  }
  public void draw(Graphics2D g2d){
    for(int i = 0; i < b.size(); i++){
      temp = b.get(i);
      temp.draw(g2d);
    }
  }
  public void update(){
    for(int i = 0; i < b.size(); i++){
      temp = b.get(i);
      temp.update();
    }
  }
  public void addBull(Bullet bullet){
    b.add(bullet);
  }
  public void remove(Bullet bullet){
    b.remove(bullet);
  }
  public static ArrayList<Bullet> getBullBounds(){
    return b;
  }
}
