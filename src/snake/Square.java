package snake;

public class Square {
    private int positionX = 300;
    private int positionY = 300;
    
    public Square(){
        
    }
    
    public Square(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    public int getSquarePositionX(){
        return positionX;
    }
    
    public int getSquarePositionY(){
        return positionY;
    }
    
    public void setSquarePositionX(int x){
        positionX = x;
    }
    
    public void setSquarePositionY(int y){
        positionY = y;
    }
}
