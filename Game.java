import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Game extends JPanel implements KeyListener, ActionListener {
    private int x=300;
    private Timer time;
    private int speed=20;
    private int ex=10;
    private int ey=10;
    private Random liczba=new Random();
    private int wrogX1=liczba.nextInt(6)*100;
    private int wrogX2=liczba.nextInt(6)*100;
    private int points=0;

    public Game(){
        time=new Timer(10,this); //10 ms
        time.start();
        System.out.println(wrogX1);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
    }

    public void paint(Graphics g){
        //tło
        g.setColor(Color.black);
        g.fillRect(0,0,700,600);
        //gracz
        g.setColor(Color.red);
        g.fillRect(x,475,75,75);
        //wrog
        g.setColor(Color.pink);
        g.fillRect(wrogX1,ey,100,100);
        g.fillRect(wrogX2,ey,100,100);
        //punkty
        g.setColor(Color.green);
        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("Punkty: "+points,570,20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        ey+=5;
        //kolizje
        if(ey==580){
            points++;
            ey=10;
            wrogX1=liczba.nextInt(6)*100;
            wrogX2=liczba.nextInt(6)*100;
        }
        Rectangle gracz=new Rectangle(x,476,75,75);
        Rectangle wrog1=new Rectangle(wrogX1,ey,100,100);
        Rectangle wrog2=new Rectangle(wrogX2,ey,100,100);
        if(gracz.intersects(wrog1) || gracz.intersects(wrog2))
        {
            time.stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_A){
            if(x==0)
            {
                x=0;
            }
            else {
                x-=speed;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_D) {
            if (x == 600) {
                x = 600;
            } else {
                x += speed;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            reset();
        }
    }

    private void reset() {
        ey=10;
        wrogX1=liczba.nextInt(6)*100;
        wrogX2=liczba.nextInt(6)*100;
        x=300;
        time.start();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
