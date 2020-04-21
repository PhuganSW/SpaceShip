import java.awt.*;
import javax.swing.*;
public class Enemy{
  protected Game game;
  private int x,y;
  private int speedy = 3;
  public Enemy(int x,int y){
    this.x = x;
    this.y = y;
  }
  public void draw(Graphics2D g2d){
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image alien = tk.getImage("image/alien.png");
    g2d.drawImage(alien,x,y,game);
  }
  public void update(){
    y += speedy;
    if(Player.score >  30){
      speedy = 5;
    }
    if(Player.score > 65){
      speedy = 8;
    }
  }
  public int getY(){
    return y;
  }
  public Rectangle getBounds(){
    return new Rectangle(x,y,100,100);
  }
}
