import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Snake {

    static private int INITIAL_X = GameBoard.SQUARE_SIZE*20;
    static private int INITIAL_Y = GameBoard.SQUARE_SIZE*15;
    private final static int squareSize = GameBoard.SQUARE_SIZE;
    private final static int INITIAL_LENGTH = 10;

    static private List<Location> snake;
    static private Location lastTailPos = null;
    static private Boolean isDead = false;

    Snake() {
    }
    
    static public void initialize(GameBoard game_board){
        snake = new ArrayList<Location>();
        for (int i = 0; i < INITIAL_LENGTH; i++) {
            snake.add(new Location(INITIAL_X - i * squareSize, INITIAL_Y));
        }
    }
    static public int getInitialLength(){
        return INITIAL_LENGTH;
    }

    static public Location getHeadLocation() {
        return snake.get(0);
    }

    static public Location getTailLocation() {
        return snake.get(snake.size() - 1);
    }

    static public boolean eat() { 
        if(Food.getLocation().getXCoor()==getHeadLocation().getXCoor() && 
                Food.getLocation().getYCoor()==getHeadLocation().getYCoor()){
            Food.eaten();
            
            return true;
        }
        return false;
    }

    static public void grow() {
        snake.add(lastTailPos);
    }

    static public void move(Direction dir) {
        Location prevHead = getHeadLocation();
        Location newLoc = new Location(prevHead, dir);
        snake.add(0, newLoc);
        lastTailPos = snake.get(snake.size()-1);
        snake.remove(lastTailPos);
    }

    static public List<Location> getSnake() {
        List<Location> toReturn = new LinkedList<Location>();
        for (Location loc : snake) {
            toReturn.add(loc);
        }
        return toReturn;
    }

    static public Boolean hitWall() {
        Dimension boundary = GameBoard.getDimension();
        Location head = getHeadLocation();
        double maxWidth = boundary.getWidth();
        double maxHeight = boundary.getHeight();

        if (head.getXCoor() >= maxWidth || head.getXCoor() < 0 || head.getYCoor() >= (maxHeight - squareSize)
                || head.getYCoor() <= -squareSize)
            return true;

        else
            return false;
    }

    static public Boolean hitSelf() {
        Set<Location> snakeNoDup = new HashSet<Location>();
        for (Location loc : snake) {
            if (!snakeNoDup.contains(loc))
                snakeNoDup.add(loc);
        }
        return !(snakeNoDup.size() == snake.size());

    }
    
    static public void setDead(Boolean dead){
        isDead = dead;
    }
    
    static public Boolean isDead(){
        return isDead;
    }
    
    static public void clear(){
        snake.clear();
    }

}