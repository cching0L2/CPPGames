import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;

import javax.swing.JPanel;

class GameBoard extends JPanel {

    private static final long serialVersionUID = -7691695474867529284L;

    private int GAME_BOARD_SIZE;
    private final Color bgColor = new Color(177, 211, 222);
    private final Color snakeColor = new Color(235, 145, 0);
    private final int DELAY = 50;
    private Snake snake;
    private final Timer timer;

    public GameBoard(container c) {
        GAME_BOARD_SIZE = c.getSideLength();
        setBackground(bgColor);
        setPreferredSize(new Dimension(GAME_BOARD_SIZE, GAME_BOARD_SIZE));
        snake = new Snake(this);
        
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(KeyboardControl.getPrevDir()==null)
                    Snake.move(Direction.RIGHT);
                else
                    Snake.move(KeyboardControl.getPrevDir());
                repaint();
            }
        });
        
        timer.start();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(snakeColor);
        List<Location> snakeBody = Snake.getSnake();

        //draw out the body of the snake
        for (Location loc : snakeBody) {
            Location snakeSectionLoc = loc;
            graphics.fillRect(snakeSectionLoc.getXCoor(), snakeSectionLoc.getYCoor(), Snake.getSnakeSize(),
                    Snake.getSnakeSize());
            System.out.println(loc); //testing
        }
    }
}