import java.awt.*;
import javax.swing.*;
public class Meteor{
  protected Game game;
  private int x,y;
  private int speedy = 5;
  private Toolkit tk = Toolkit.getDefaultToolkit();
  private Image met = tk.getImage("image/Meteor.png");
  public Meteor(int x,int y){
    this.x = x;
    this.y = y;
  }
  public void draw(Graphics2D g){
    g.drawImage(met,x,y,game);
  }
  public void update(){
    y += speedy;
  }
  public int getY(){
    return y;
  }
  public Rectangle getBounds(){
    return new Rectangle(x+25,y,95,150);
  }
}
