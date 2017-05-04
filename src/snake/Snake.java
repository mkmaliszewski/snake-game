package snake;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Square> snake;
    private final int squareSize;
    
    public Snake(){
        snake = new LinkedList<>();
        squareSize = 30;
        snake.add(new Square());
    }
    
    public void paintSquare(Graphics2D g2d){        
        for (int i = 0; i < snake.size(); i++){
            g2d.fillRect(snake.get(i).getSquarePositionX(), snake.get(i).getSquarePositionY(), squareSize, squareSize);
        }
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
}
