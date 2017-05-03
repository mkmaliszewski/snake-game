package snake;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(){
        super("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add component
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
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
