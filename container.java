import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class container{
    private final int SIDE_LENGTH = 500;
    
    container(){
        
        //create new background container
        JFrame background = new JFrame("Snake Game");
        GameBoard gameBoard = new GameBoard(this);
        KeyboardControl control = new KeyboardControl();
        
        //set up the game interface
        background.setSize(SIDE_LENGTH, SIDE_LENGTH);
        
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