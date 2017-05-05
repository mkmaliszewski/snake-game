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
    private String move;
    private boolean moveDone;
    
    public GameBoard(){
        gameSize = 600;
        moveX = 300;
        moveY = 300;
        snake = new Snake();
        food = new Food();
        move = "none";
        setPreferredSize(new Dimension(gameSize, gameSize));
        setBackground(Color.BLACK);
        
        timer = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(snake.checkIfSnakeIsOnFood(food.getFoodPositionX(), food.getFoodPositionY())){
                    snake.addNewSquare(moveX, moveY);
                    snake.addNewSquare(moveX, moveY);
                    snake.addNewSquare(moveX, moveY);
                    do {
                        food.updateFoodPosition();
                    } while (!snake.checkIfValidFoodPositions(food.getFoodPositionX(), food.getFoodPositionY()));
                }
                updateMovingDirection();
                snake.updateSnake(moveX, moveY);
                repaint();
                moveDone = false;
            }
        });        
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
        if (!timer.isRunning()){
            timer.start();
        }
        
        if (key == KeyEvent.VK_A && !moveDone){
            if (move.equals("up") || move.equals("down") || move.equals("none")){
                moveDone = true;
                move = "left";
            }
        }
        if (key == KeyEvent.VK_D && !moveDone){
            if (move.equals("up") || move.equals("down") || move.equals("none")){
                moveDone = true;
                move = "right";
            }
        }
        if (key == KeyEvent.VK_W && !moveDone){
            if (move.equals("left") || move.equals("right") || move.equals("none")){
                moveDone = true;
                move = "up";
            }
        }
        if (key == KeyEvent.VK_S && !moveDone){
            if (move.equals("left") || move.equals("right") || move.equals("none")){
                moveDone = true;
                move = "down";
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void updateMovingDirection(){
        switch (move){
            case "left":    moveX -= 30;
                            break;
            case "right":   moveX += 30;
                            break;
            case "up":      moveY -= 30;
                            break;
            case "down":    moveY += 30;
                            break;
        }
    }
}
