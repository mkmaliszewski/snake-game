package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements KeyListener{
    private final int gameSize;
    private Snake snake;
    private Food food;
    private Timer timer;
    private int moveX, moveY, score;
    private String move;
    private boolean moveDone;
    
    public GameBoard(){
        score = 0;
        gameSize = 600;
        moveX = 300;
        moveY = 300;
        snake = new Snake(moveX, moveY);
        food = new Food();
        move = "none";
        setTimer();
        
        setPreferredSize(new Dimension(gameSize, gameSize));
        setBackground(Color.BLACK);    
    }
    
    @Override
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
        
        if ((key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) && !moveDone){
            if (move.equals("up") || move.equals("down") || move.equals("none")){
                moveDone = true;
                move = "left";
            }
        }
        if ((key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) && !moveDone){
            if (move.equals("up") || move.equals("down") || move.equals("none")){
                moveDone = true;
                move = "right";
            }
        }
        if ((key == KeyEvent.VK_W || key == KeyEvent.VK_UP) && !moveDone){
            if (move.equals("left") || move.equals("right") || move.equals("none")){
                moveDone = true;
                move = "up";
            }
        }
        if ((key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) && !moveDone){
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
    
    public void setTimer(){
        timer = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(snake.checkIfSnakeIsOnFood(food.getFoodPositionX(),
                        food.getFoodPositionY())){
                    score += 10;
                    snake.addNewSquare(moveX, moveY);
                    snake.addNewSquare(moveX, moveY);
                    snake.addNewSquare(moveX, moveY);
                    snake.addNewSquare(moveX, moveY);
                    do {
                        food.updateFoodPosition();
                    } while (!snake.checkIfValidFoodPositions(food.getFoodPositionX(),
                            food.getFoodPositionY()));
                }
                updateMovingDirection();
                snake.updateSnake(moveX, moveY);
                repaint();
                moveDone = false;
                if (snake.checkIfGameOver(gameSize)){
                    timer.stop();
                    int response = JOptionPane.showConfirmDialog(null,
                            "Your score is: " + score +
                            "\nDo you want to continue?", "New game?",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.NO_OPTION ||
                            response == JOptionPane.CLOSED_OPTION) {
                        System.exit(0);
                    } else if (response == JOptionPane.YES_OPTION) {
                        newGame();
                    }
                }
            }
        });
    }
    
    public void newGame(){
        snake.clearSnake();
        moveX = 300;
        moveY = 300;
        snake.addNewSquare(moveX, moveY);
        score = 0;
        repaint();
    }
}
