import java.util.*;
import java.awt.*;
import javax.swing.*;
public class EnemyMove{
  static ArrayList<Enemy> e = new ArrayList<Enemy>();
  Enemy temp,alien;
  private int delay = 50;
  private int dist = 50;
  private Random rand = new Random();
  private int unit = 5;
  private int y = 0;
  private int Y;
  public EnemyMove(){
    /*addEnemy(new Enemy(rand,0));
    addEnemy(new Enemy(rand+170,0));*/
  }
  public void draw(Graphics2D g2d){
    for(int i = 0; i < e.size(); i++){
      temp = e.get(i);
      temp.draw(g2d);
    }
  }
  public void update(){
    for(int i = 0; i < e.size(); i++){
      temp = e.get(i);
      temp.update();
    }
    if(Player.score > 50){
      unit = 6;
    }
    if(Player.start == 1){
      for(int i = 0; i < rand.nextInt(unit); i++){
        if(delay%dist == 0){
          alien = new Enemy(rand.nextInt(350),0);
          addEnemy(alien);
        }
        if(Player.life <= 0){
          break;
        }
        delay += 1;
      }
    }
  }
  public void addEnemy(Enemy enemy){
    e.add(enemy);
  }
  public void remove(Enemy enemy){
    e.remove(enemy);
    alien = new Enemy(rand.nextInt(350),0);
    addEnemy(alien);
  }
  public static ArrayList<Enemy> getEnemyBounds(){
    return e;
  }
}
