import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel {

    private static final long serialVersionUID = -7691695474867529284L;

    private Container container;

    public static final int SQUARE_SIZE = 12;
    public static final int NUM_GRID = 50;
    private static final int GAME_BOARD_SIZE = NUM_GRID * SQUARE_SIZE;

    private final Color bgColor = new Color(177, 211, 222);
    private final Color SNAKE_COLOR = new Color(235, 145, 0);
    private final Color[] FOOD_COLOR = { Color.red, Color.green, Color.black, Color.pink, Color.MAGENTA };
    private Color current_food_color = Helper.getRandomColor(FOOD_COLOR);

    private final int DELAY = 50;
    private final Direction INITIAL_DIRECTION = Direction.RIGHT;
    private final Timer timer;

    private boolean isRunning = true;
    private int score = Snake.getInitialLength();

    public GameBoard(Container container) {
        this.container = container;
        setBackground(bgColor);
        setPreferredSize(new Dimension(GAME_BOARD_SIZE, GAME_BOARD_SIZE));
        Snake.initialize(this);
        Food.initialize();

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                step();
            }
        });
        timer.start();
    }

    private void step() {
        if (Snake.hitWall() | Snake.hitSelf()) {
            setBackground(Color.gray);
            Snake.setDead(true);
        } else {
            container.updateScore();
            if (KeyboardControl.getPrevDir() == null) {
                Snake.move(INITIAL_DIRECTION);
                KeyboardControl.setPrevDir(INITIAL_DIRECTION);
                KeyboardControl.setDirection(INITIAL_DIRECTION);
            } else {
                if (KeyboardControl.getPrevDir() == KeyboardControl.getDirection()) {
                    Snake.move(KeyboardControl.getPrevDir());
                } else {
                    Snake.move(KeyboardControl.getDirection());
                    KeyboardControl.setPrevDir(KeyboardControl.getDirection());
                }
            }
        }
        if (Snake.eat()) {
            Snake.grow();
            incrementScore();
        }
        repaint();
    }

    public static Dimension getDimension() {
        return new Dimension(GAME_BOARD_SIZE, GAME_BOARD_SIZE);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(SNAKE_COLOR);
        List<Location> snakeBody = Snake.getSnake();

        if (!Snake.isDead()) {
            // draw out the body of the snake
            for (Location loc : snakeBody) {
                Location snakeSectionLoc = loc;
                graphics.fillRect(snakeSectionLoc.getXCoor(), snakeSectionLoc.getYCoor(), SQUARE_SIZE, SQUARE_SIZE);
            }

            if (Snake.eat()) {
                current_food_color = Helper.getRandomColor(FOOD_COLOR);
                Food.generate();
            }
            graphics.setColor(current_food_color);
            
            Location foodLocation = Food.getLocation();
            graphics.fillRect(foodLocation.getXCoor(), foodLocation.getYCoor(), SQUARE_SIZE, SQUARE_SIZE);

        } else {
            // print game over information
            // add JLabel for this
            graphics.setColor(Color.white);
            Font font = new Font("Arial Black", Font.PLAIN, 30);
            setFont(font);
            graphics.drawString("GAME OVER", (int) (GAME_BOARD_SIZE / 4.5), GAME_BOARD_SIZE / 2);
        }
    }

    public void start() {
        timer.restart();
    }

    public void stop() {
        timer.stop();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(Boolean running) {
        isRunning = running;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }
}