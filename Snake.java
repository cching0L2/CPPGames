import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Snake{
    
    static private int INITIAL_X = 0;
    static private int INITIAL_Y = 0;
    private final static int squareSize = 10;

    //private GameBoard gameBoard;
    static private List<Location> snake;
    
    Snake(GameBoard gameBoard){
        //this.gameBoard = gameBoard;
        snake = new ArrayList<Location>();
        snake.add(new Location(INITIAL_X, INITIAL_Y));
    }
    
    static public Location getHeadLocation(){
        return snake.get(0);
    }
    
    static public Location getTailLocation(){
        return snake.get(snake.size()-1);
    }
  
    static public void grow(Direction dir){
        snake.add(new Location(getTailLocation(), dir));
        //TODO implement this method 
    }
    
    static public void move(Direction dir){
        Location prevHead = getHeadLocation();
        snake.remove(0);
        snake.add(0, new Location(prevHead, dir));
    }
    
    static public List<Location> getSnake(){
        List<Location> toReturn = new LinkedList<Location>();
        for(Location loc : snake){
            toReturn.add(loc);
        }
        return toReturn;
    }
    
    static public int getSnakeSize(){
        return squareSize;
    }
    
}