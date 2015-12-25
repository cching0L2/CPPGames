import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Container{
    private final Dimension dimension = GameBoard.getDimension();
    
    Container(){
        
        //create new background container
        JFrame background = new JFrame("Snake Game");
        GameBoard gameBoard = new GameBoard();
        Bottom bottom = new Bottom();
        KeyboardControl control = new KeyboardControl();
        
        //set up the game interface
        background.setSize(new Dimension(dimension.width,dimension.height+bottom.getHeight()));
        
        //set background color of game board
        background.getContentPane().setBackground(Color.white);
        
        //make sure the program is terminated when window is closed
        background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //make the window visible
        background.setVisible(true);
        
        //make the window not resizable 
        background.setResizable(false);
        
        //adding the game board to this
        background.add(control);
        background.add(gameBoard);
        background.add(bottom, BorderLayout.SOUTH);
        
        
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Container();
            }
        });
    }
}