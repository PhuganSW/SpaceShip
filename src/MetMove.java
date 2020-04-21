import java.util.*;
import java.awt.*;
import javax.swing.*;
public class MetMove{
  static ArrayList<Meteor> m = new ArrayList<Meteor>();
  Meteor temp,met;
  private int delay = 250;
  private int dist = 250;
  private Random rand = new Random();
  private int y;
  public MetMove(){
  }
  public void draw(Graphics2D g){
    for(int i = 0; i < m.size(); i++){
      temp = m.get(i);
      temp.draw(g);
    }
  }
  public void update(){
    for(int i = 0; i < m.size(); i++){
      temp = m.get(i);
      temp.update();
    }
    if(Player.start == 1){
      for(int i = 0; i < rand.nextInt(3); i++){
        if(delay%dist == 0){
          met = new Meteor(rand.nextInt(320),0);
          addMet(met);
        }
        if(Player.life <= 0){
          break;
        }
        delay += 1;
      }
    }
  }
  public void addMet(Meteor met){
    m.add(met);
  }
  public void remove(Meteor met){
    m.remove(met);
  }
  public static ArrayList<Meteor> getMetBounds(){
    return m;
  }
}
