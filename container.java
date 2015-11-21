import java.awt.*;
import javax.swing.*;

public class container{
    private final Color bgColor = new Color(177, 211, 222);
    private final int SIDE_LENGTH = 700;
    
    container(){
        
        //create new gameBoard container
        JFrame gameBoard = new JFrame("Snake Game");
        
        //set up the game interface
        gameBoard.setSize(SIDE_LENGTH, SIDE_LENGTH);
        
        //set background color of game board
        //gameBoard.setBackground(Color.CYAN);
        gameBoard.getContentPane().setBackground(bgColor);
        
        //make sure the program is terminated when window is closed
        gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //make the window visible
        gameBoard.setVisible(true);
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new container();
            }
        });
    }
}