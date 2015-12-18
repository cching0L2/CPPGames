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

    public static final int SQUARE_SIZE = 12;
    public static final int NUM_GRID = 40;
    private static final int GAME_BOARD_SIZE = NUM_GRID * SQUARE_SIZE;
    
    private final Color bgColor = new Color(177, 211, 222);
    private final Color SNAKE_COLOR = new Color(235, 145, 0);
    private final Color FOOD_COLOR = Color.red;
    
    private final int DELAY = 70;
    private final Direction INITIAL_DIRECTION = Direction.RIGHT;
    private final Timer timer;

    public GameBoard() {
        setBackground(bgColor);
        setPreferredSize(new Dimension(GAME_BOARD_SIZE, GAME_BOARD_SIZE));
        Snake.initialize(this);
        Food.initialize();

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Snake.hitWall() | Snake.hitSelf()) {
                    timer.stop();
                } else {
                    if (KeyboardControl.getPrevDir() == null) {
                        Snake.move(INITIAL_DIRECTION); // moves to the right at
                                                       // the beginning
                        KeyboardControl.setPrevDir(INITIAL_DIRECTION);
                        KeyboardControl.setDirection(INITIAL_DIRECTION);
                    } else {
                        // if no new key is pressed, continue moving in previous
                        // direction
                        if (KeyboardControl.getPrevDir() == KeyboardControl.getDirection()) {
                            Snake.move(KeyboardControl.getPrevDir());
                        } else {
                            Snake.move(KeyboardControl.getDirection());
                            KeyboardControl.setPrevDir(KeyboardControl.getDirection());
                        }
                    }
                }
                if(Snake.eat()){
                    Snake.grow();
                }
                repaint();
            }
        });
        timer.start();
    }

    public static Dimension getDimension() {
        return new Dimension(GAME_BOARD_SIZE, GAME_BOARD_SIZE);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(SNAKE_COLOR);
        List<Location> snakeBody = Snake.getSnake();

        // draw out the body of the snake
        for (Location loc : snakeBody) {
            Location snakeSectionLoc = loc;
            graphics.fillRect(snakeSectionLoc.getXCoor(), snakeSectionLoc.getYCoor(), SQUARE_SIZE, SQUARE_SIZE);
        }

        graphics.setColor(FOOD_COLOR);

        if (Snake.eat()) {
            Food.generate(this);
        }
        Location foodLocation = Food.getLocation();
        graphics.fillRect(foodLocation.getXCoor(), foodLocation.getYCoor(), SQUARE_SIZE, SQUARE_SIZE);
    }
}