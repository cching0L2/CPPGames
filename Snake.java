import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Snake {

    static private int INITIAL_X = 400;
    static private int INITIAL_Y = 500;
    private final static int squareSize = 12;
    private final static int INITIAL_LENGTH = 20;

    static private GameBoard gameBoard;
    static private List<Location> snake;

    Snake(GameBoard game_board) {
        gameBoard = game_board;
        snake = new ArrayList<Location>();
        for (int i = 0; i < INITIAL_LENGTH; i++) {
            snake.add(new Location(INITIAL_X - i * squareSize, INITIAL_Y));
        }
    }

    static public Location getHeadLocation() {
        return snake.get(0);
    }

    static public Location getTailLocation() {
        return snake.get(snake.size() - 1);
    }

    static public void grow(Direction dir) {
        snake.add(new Location(getTailLocation(), dir));
        // TODO implement this method
    }

    static public void move(Direction dir) {
        Location prevHead = getHeadLocation();
        Location newLoc = new Location(prevHead, dir);
        snake.add(0, newLoc);
        snake.remove(snake.size() - 1);
    }

    static public List<Location> getSnake() {
        List<Location> toReturn = new LinkedList<Location>();
        for (Location loc : snake) {
            toReturn.add(loc);
        }
        return toReturn;
    }

    static public Boolean hitWall() {
        Dimension boundary = gameBoard.getDimension();
        Location head = getHeadLocation();
        double maxWidth = boundary.getWidth();
        double maxHeight = boundary.getHeight();

        if (head.getXCoor() >= (maxWidth - squareSize) || head.getXCoor() <= squareSize
                || head.getYCoor() >= (maxHeight - squareSize * 3) || head.getYCoor() <= 0)
            return true;

        else
            return false;
    }

    static public Boolean hitSelf() {
        Set<Location> snakeNoDup = new HashSet<Location>();
        for(Location loc : snake){
            if(!snakeNoDup.contains(loc))
            snakeNoDup.add(loc);
        }
        return !(snakeNoDup.size()==snake.size());

    }

    static public int getSnakeSize() {
        return squareSize;
    }

}