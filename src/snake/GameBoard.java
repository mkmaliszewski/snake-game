package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel{
    private final int gameSize;
    private Snake snake;
    private Food food;
    private Timer timer;
    
    public GameBoard(){
        gameSize = 600;
        snake = new Snake();
        food = new Food();
        
        setPreferredSize(new Dimension(gameSize, gameSize));
        setBackground(Color.BLACK);
        
        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                food.updateFoodPosition();
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
    
    
}
