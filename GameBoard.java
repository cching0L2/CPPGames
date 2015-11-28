import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Queue;

import javax.swing.JPanel;

class GameBoard extends JPanel {

    private static final long serialVersionUID = -7691695474867529284L;

    private int GAME_BOARD_SIZE;
    private final Color bgColor = new Color(177, 211, 222);
    private final Color snakeColor = new Color(235, 145, 0);

    public GameBoard(container c) {
        GAME_BOARD_SIZE = c.getSideLength();
        setBackground(bgColor);
        setPreferredSize(new Dimension(GAME_BOARD_SIZE, GAME_BOARD_SIZE));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Snake snake = new Snake(this);
        graphics.setColor(snakeColor);
        Queue<Location> snakeBody = snake.getSnake();

        //draw out the body of the snake
        for (Location loc : snakeBody) {
            Location snakeSectionLoc = loc;
            graphics.fillRect(snakeSectionLoc.getXCoor(), snakeSectionLoc.getYCoor(), snake.getSnakeSize(),
                    snake.getSnakeSize());
            System.out.println(loc); //testing
        }
    }
}