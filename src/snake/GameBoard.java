package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements KeyListener{
    private final int gameSize;
    private Snake snake;
    private Food food;
    private Timer timer;
    private int moveX, moveY;
    
    public GameBoard(){
        gameSize = 600;
        moveX = 300;
        moveY = 300;
        snake = new Snake();
        food = new Food();
        
        setPreferredSize(new Dimension(gameSize, gameSize));
        setBackground(Color.BLACK);
        
        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                food.updateFoodPosition();
                snake.updateSnake(moveX, moveY);
                repaint();
            }
        });
        timer.start();
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        snake.paintSquare(g2d);
        g2d.setColor(Color.RED);
        food.paintFood(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_A){
            moveX -= 30;
        }
        if (key == KeyEvent.VK_D){
            moveX += 30;
        }
        if (key == KeyEvent.VK_W){
            moveY -= 30;
        }
        if (key == KeyEvent.VK_S){
            moveY += 30;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
}
