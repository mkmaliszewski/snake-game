package snake;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(){
        super("Snake");
        
        GameBoard gameBoard = new GameBoard();
        gameBoard.addKeyListener(gameBoard);
        gameBoard.setFocusable(true);
        add(gameBoard);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Frame();
            }
        });  
    }
}
