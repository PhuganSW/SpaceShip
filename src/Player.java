import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.*;
public class Player{
  protected Game game;
  protected Bullet bullet;
  private int x,y;
  private int speedx = 0;
  private int speedy = 0;
  private int mode;
  private Toolkit tk = Toolkit.getDefaultToolkit();
  private Image fighter = tk.getImage("image/fighter.png");
  private Image fighter1 = tk.getImage("image/fighter_boot.png");
  private Image boom = tk.getImage("image/explosion.png");
  private ArrayList<Enemy> e = EnemyMove.getEnemyBounds();
  private ArrayList<Bullet> b = BullMove.getBullBounds();
  private ArrayList<Meteor> m = MetMove.getMetBounds();
  public static int score = 0;
  public static int life = 3;
  public static int start = 0;
  public static int again = 0;
  public static int fire = 0;
  private int kill = 0;
  public static int sp = 0;
  public Player(int x,int y,int mode){
    this.x = x;
    this.y = y;
    this.mode = mode;
  }
  public void update(){
    x += speedx;
    y += speedy;
    if(x < 0){
      x = 0;
    }
    if(y < 0){
      y = 0;
    }
    if(x > 365){
      x = 365;
    }
    if(y > 510){
      y = 510;
    }
    if(kill == 5){
      kill = 0;
      sp++;
      if(sp > 3){
        sp = 3;
      }
    }
    collision();
    collision1();
    collision2();
  }
  public void draw(Graphics2D g2d){
    if(mode == 0){
      g2d.drawImage(fighter,x,y,game);
    }
    else if(mode == 1){
      g2d.drawImage(fighter1,x,y,game);
    }
    else{
      g2d.drawImage(boom,x,y,game);
    }
  }
  public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();
    if(mode != 2 && key == KeyEvent.VK_RIGHT){
      speedx = 5;
    }
    if(mode != 2 && key == KeyEvent.VK_LEFT){
      speedx = -5;
    }
    if(mode != 2 && key == KeyEvent.VK_UP){
      speedy = -5;
    }
    if(mode != 2 && key == KeyEvent.VK_DOWN){
      speedy = 6;
    }
    if(mode != 2 && sp >= 1 && key == KeyEvent.VK_SHIFT){
      speedy = -15;
      mode = 1;
      sp--;
    }
    if(mode != 2 && mode == 0 && key == KeyEvent.VK_SPACE){
      fire = 1;
      Game.bmove.addBull(new Bullet(getX(),getY()));
    }
    if(key == KeyEvent.VK_ENTER){
      start = 1;
    }
    if(key == KeyEvent.VK_ESCAPE){
      again = 1;
    }
  }
  public void keyReleased(KeyEvent e){
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_RIGHT){
      speedx = 0;
    }
    if(key == KeyEvent.VK_LEFT){
      speedx = 0;
    }
    if(key == KeyEvent.VK_UP){
      speedy = 0;
    }
    if(key == KeyEvent.VK_DOWN){
      speedy = 0;
    }
    if(mode == 0 && key == KeyEvent.VK_SPACE){
      fire = 0;
    }
    if(key == KeyEvent.VK_SHIFT){
      speedy = 0;
      mode = 0;
    }
    if(key == KeyEvent.VK_ESCAPE){
      again = 0;
    }
  }
  public void setMode(int mode){
    this.mode = mode;
  }
  public void setX(int x){
    this.x = x;
  }
  public void setY(int y){
    this.y = y;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public Rectangle getBounds(){
    return new Rectangle(x+36,y+25,28,60);
  }
  public void collision(){
    for(int i = 0; i < e.size(); i++){
      if(mode == 0 && getBounds().intersects(e.get(i).getBounds())){
        e.remove(i);
        life--;
      }
      if(mode == 1 && getBounds().intersects(e.get(i).getBounds())){
        e.remove(i);
        score++;
      }
    }
  }
  public void collision1(){
    ArrayList<Enemy> dalien = new ArrayList<Enemy>();
    ArrayList<Bullet> dbull = new ArrayList<Bullet>();
    for(int i = 0; i < e.size(); i++){
      for(int j = 0; j < b.size(); j++){
        if(b.get(j).getBounds().intersects(e.get(i).getBounds()) && e.get(i).getY() > 50){
          dalien.add(e.get(i));
          dbull.add(b.get(j));
          kill++;
          score += 2;
        }
        else if (b.get(j).getY() < 10) {
          b.remove(j);
        }
      }
    }
    for(int m = 0; m < dalien.size(); m++){
      if(e.contains(dalien.get(m))){
        e.remove(dalien.get(m));
      }
    }
    for(int n = 0; n < dbull.size(); n++){
      if(b.contains(dbull.get(n))){
        b.remove(dbull.get(n));
      }
    }
  }
  public void collision2(){
    for(int i = 0; i < m.size(); i++){
      if(getBounds().intersects(m.get(i).getBounds())){
        m.remove(i);
        mode = 2;
        life = 0;
        speedx = 0;
        speedy = 0;
        score -= 10;
      }
    }
  }
}
