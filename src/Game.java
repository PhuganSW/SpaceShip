import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
public class Game extends JPanel implements ActionListener{
  Timer loop;
  Player player;
  EnemyMove emove;
  MetMove metmove;
  public static BullMove bmove = new BullMove();
  private Toolkit tk = Toolkit.getDefaultToolkit();
  public Game(){
    loop = new Timer(10,this);
    player = new Player(190,500,0);
    emove = new EnemyMove();
    metmove = new MetMove();
    addKeyListener(new KeyIn(player));
    setFocusable(true);
  }
  @Override
  public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
    Image back = tk.getImage("image/back.jpg");
    if(Player.start == 0){
      g2d.drawImage(back,0,0,this);
      g2d.setColor(Color.white);
      g2d.setFont(new Font("Tahoma",Font.BOLD,10));
      g2d.drawString("Score: ",5,12);
      g2d.setColor(Color.white);
      g2d.setFont(new Font("Tahoma",Font.BOLD,10));
      g2d.drawString("Life: ",5,24);
      g2d.setFont(new Font("Tahoma",Font.BOLD,20));
      g2d.drawString("Press Enter to Play. ",135,50);
      repaint();
    }
    else{
      loop.start();
      g2d.drawImage(back,0,0,this);
      bmove.draw(g2d);
      player.draw(g2d);
      emove.draw(g2d);
      metmove.draw(g2d);
      g2d.setColor(Color.white);
      g2d.setFont(new Font("Tahoma",Font.BOLD,10));
      g2d.drawString("Score: " + Player.score,5,12);
      g2d.setColor(Color.white);
      g2d.setFont(new Font("Tahoma",Font.BOLD,10));
      g2d.drawString("Life: " + Player.life,5,24);
      g2d.setColor(Color.white);
      g2d.setFont(new Font("Tahoma",Font.BOLD,10));
      g2d.drawString("SP ATK.: " + Player.sp,5,36);
      if(Player.life <= 0){
        player.setMode(2);
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Tahoma",Font.BOLD,30));
        g2d.drawString(">GAME OVER<",135,200);
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Tahoma",Font.BOLD,30));
        g2d.drawString("Your Score: " + Player.score,135,250);
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Tahoma",Font.BOLD,20));
        g2d.drawString("Press Esc to Play Again.",135,300);
        if(Player.again == 1){
          Player.start = 0;
          Player.score = 0;
          Player.life = 3;
          Player.sp = 0;
          player.setX(190);
          player.setY(500);
          player.setMode(0);
          repaint();
        }
      }
    }
    repaint();
  }
  @Override
  public void actionPerformed(ActionEvent e){
    player.update();
    bmove.update();
    emove.update();
    metmove.update();
    repaint();
  }
}
