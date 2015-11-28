import java.util.LinkedList;
import java.util.Queue;

class Snake{
    
    private int INITIAL_X = 0;
    private int INITIAL_Y = 0;
    private final int squareSize = 10;
    
    private int XCoor;
    private int YCoor;
    
    private GameBoard gameBoard;
    private Queue<Location> snake;
    
    Snake(GameBoard gameBoard){
        this.gameBoard = gameBoard;
        snake = new LinkedList<Location>();
        snake.add(new Location(INITIAL_X, INITIAL_Y));
    }
    
    public Location getHeadLocation(){
        return snake.peek();
    }
  
    public void grow(){
        //TODO implement this method 
    }
    
    public Queue<Location> getSnake(){
        Queue<Location> toReturn = new LinkedList<Location>();
        for(Location loc : snake){
            toReturn.add(loc);
        }
        return toReturn;
    }
    
    public int getSnakeSize(){
        return squareSize;
    }
    
}