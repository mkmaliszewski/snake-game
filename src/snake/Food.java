package snake;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

public class Food {
    private final int foodSize;
    private int positionX = 240;
    private int positionY = 240;
    
    public Food(){
        foodSize = 30;
    }
    
    public int getFoodPositionX(){
        return positionX;
    }
    
    public int getFoodPositionY(){
        return positionY;
    }
    
    public void paintFood(Graphics2D g2d){
        g2d.fillOval(positionX, positionY, foodSize, foodSize);
    }
    
    public void updateFoodPosition(){
        Random generator = new Random();
        positionX = generator.nextInt(20) * 30;
        positionY = generator.nextInt(20) * 30;
    }
}
