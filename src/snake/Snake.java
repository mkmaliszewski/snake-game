package snake;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class Snake {
    private final LinkedList<Square> snake;
    private final int squareSize;
    
    public Snake(int firstX, int firstY){
        snake = new LinkedList<>();
        squareSize = 30;
        addNewSquare(firstX, firstY);
    }
    
    public void paintSquare(Graphics2D g2d){        
        for (Square square : snake){
            g2d.fillRect(square.getSquarePositionX(), square.getSquarePositionY(),
                    squareSize, squareSize);
        }
    }
    
    public void addNewSquare(int positionX, int positionY){
        snake.add(new Square(positionX, positionY));
    }
    
    public void updateSnake(int newHeadX, int newHeadY){
        int positionX, positionY;
        for (int i = snake.size() - 1; i > 0; i--){
            positionX = snake.get(i - 1).getSquarePositionX();
            positionY = snake.get(i - 1).getSquarePositionY();
            
            snake.get(i).setSquarePositionX(positionX);
            snake.get(i).setSquarePositionY(positionY);
        }
        
        snake.get(0).setSquarePositionX(newHeadX);
        snake.get(0).setSquarePositionY(newHeadY);
    }
    
    public boolean checkIfSnakeIsOnFood(int foodX, int foodY){
        return snake.get(0).getSquarePositionX() == foodX && 
                snake.get(0).getSquarePositionY() == foodY;
    }
    
    public boolean checkIfValidFoodPositions(int foodX, int foodY){
        for (Square square : snake){
            if (square.getSquarePositionX() == foodX &&
                    square.getSquarePositionY() == foodY){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkIfGameOver(int gameSize){
        int headX = snake.get(0).getSquarePositionX();
        int headY = snake.get(0).getSquarePositionY();
        
        for (int i = 1; i < snake.size(); i++){
            if (snake.get(i).getSquarePositionX() == headX &&
                    snake.get(i).getSquarePositionY() == headY){
                return true;
            }
        }
        
        return headX < 0 || headX > gameSize - squareSize ||
                headY < 0 || headY > gameSize - squareSize;
    }
}
