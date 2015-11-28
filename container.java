import java.awt.*;
import javax.swing.*;

public class container{
    private final int SIDE_LENGTH = 700;
    
    container(){
        
        //create new background container
        JFrame background = new JFrame("Snake Game");
        
        //set up the game board
        GameBoard gameBoard = new GameBoard(this);
        
        //set up the game interface
        background.setSize(SIDE_LENGTH, SIDE_LENGTH);
        
        //set background color of game board
        background.getContentPane().setBackground(Color.white);
        
        //make sure the program is terminated when window is closed
        background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //make the window visible
        background.setVisible(true);
        
        //adding the game board to this
        background.getContentPane().add(gameBoard, BorderLayout.CENTER);
        
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new container();
            }
        });
    }
    
    public int getSideLength(){
        return SIDE_LENGTH;
    }
}