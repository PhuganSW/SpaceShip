import java.awt.*;
import javax.swing.*;
public class Bullet{
  protected Game game;
  private Toolkit tk = Toolkit.getDefaultToolkit();
  private Image bull = tk.getImage("image/laser.png");
  private int x,y;
  private int speedy = 5;
  public Bullet(int x,int y){
    this.x = x+50;
    this.y = y;
  }
  public void update(){
    y -= speedy;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public void draw(Graphics2D g2d){
    g2d.drawImage(bull,x,y,game);
  }

  public Rectangle getBounds(){
    return new Rectangle(x,y,5,25);
  }
}
