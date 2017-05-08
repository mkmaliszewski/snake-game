package snake;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Square> snake;
    private final int squareSize;
    
    public Snake(){
        snake = new LinkedList<>();
        squareSize = 30;
        addNewSquare(300, 300);
    }
    
    public void paintSquare(Graphics2D g2d){        
        for (int i = 0; i < snake.size(); i++){
            g2d.fillRect(snake.get(i).getSquarePositionX(), snake.get(i).getSquarePositionY(), squareSize, squareSize);
        }
    }
    
    public void addNewSquare(int posX, int posY){
        snake.add(new Square(posX, posY));
    }
    
    public void updateSnake(int x, int y){
        int positionX, positionY;
        for (int i = snake.size() - 1; i > 0; i--){
            positionX = snake.get(i - 1).getSquarePositionX();
            positionY = snake.get(i - 1).getSquarePositionY();
            
            snake.get(i).setSquarePositionX(positionX);
            snake.get(i).setSquarePositionY(positionY);
        }
        
        snake.get(0).setSquarePositionX(x);
        snake.get(0).setSquarePositionY(y);
    }
    
    public boolean checkIfSnakeIsOnFood(int foodX, int foodY){
        if (snake.get(0).getSquarePositionX() == foodX && 
                snake.get(0).getSquarePositionY() == foodY){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean checkIfValidFoodPositions(int foodX, int foodY){
        for (Square square : snake){
            if (square.getSquarePositionX() == foodX && square.getSquarePositionY() == foodY){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkIfGameOver(){
        int headX = snake.get(0).getSquarePositionX();
        int headY = snake.get(0).getSquarePositionY();
        
        for (int i = 1; i < snake.size(); i++){
            if (snake.get(i).getSquarePositionX() == headX &&
                    snake.get(i).getSquarePositionY() == headY){
                return true;
            }
        }
        
        if (headX < 0 || headX > 600 || headY < 0 || headY > 600){
            return true;
        }
        
        return false;
    }
}
