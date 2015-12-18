import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

class Bottom extends JPanel{

    private static final long serialVersionUID = 1075247788964985380L;
    private static final Color bgColor = new Color(194, 194, 194);
    private static final int HEIGHT = 50;
    
    public Bottom(){
        setBackground(bgColor);
        this.setPreferredSize(new Dimension(GameBoard.NUM_GRID*GameBoard.SQUARE_SIZE, HEIGHT));
    }
    
    public int getHeight(){
        return HEIGHT;
    }
}