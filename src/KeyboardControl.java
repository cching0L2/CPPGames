import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

class KeyboardControl extends JPanel {

    private static final long serialVersionUID = 4122465017629656635L;
    static private Direction prevDir = null;
    static private Direction direction = null;
    static private Boolean pause = false;
    private GameBoard gameBoard;

    KeyboardControl(GameBoard gb) {
        KeyListener listener = new getKeyInput();
        addKeyListener(listener);
        setFocusable(true);
        gameBoard = gb;
    }

    static public void setPrevDir(Direction previous_direction) {
        prevDir = previous_direction;
    }

    static public Direction getPrevDir() {
        return prevDir;
    }

    static public void setDirection(Direction dir) {
        direction = dir;
    }

    static public Direction getDirection() {
        return direction;
    }

    static public Boolean pause() {
        return pause;
    }

    public class getKeyInput implements KeyListener {
        private final int LEFT_KEY = 37;
        private final int UP_KEY = 38;
        private final int RIGHT_KEY = 39;
        private final int DOWN_KEY = 40;

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (gameBoard.isRunning()) {
                if (keyCode == 32) {
                    pause = true;
                } else
                    pause = false;

                switch (keyCode) {
                case (LEFT_KEY):
                    direction = Direction.LEFT;
                    break;
                case (RIGHT_KEY):
                    direction = Direction.RIGHT;
                    break;
                case (UP_KEY):
                    direction = Direction.UP;
                    break;
                case (DOWN_KEY):
                    direction = Direction.DOWN;
                    break;
                }
            }

            // this method of controlling the snake has better performance
            // ->more responsive
            // but implementing this allows both the timer
            // and the keyboard control to control the direction
            // of the snake

            // if(!Snake.hitWall() && !Snake.hitSelf() && !(prevDir==direction))
            // Snake.move(direction);
            // prevDir = direction;
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}