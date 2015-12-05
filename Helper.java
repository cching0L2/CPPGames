import java.util.Random;

public class Helper{
    /**
     * where all the helper methods live
     */
    
    static Location getRandomLocation (GameBoard gb){
        int boardWidth = gb.getWidth();
        int boardHeight = gb.getHeight();
        
        Random randomGenerator = new Random();
        int randX = randomGenerator.nextInt(boardWidth);
        int randY = randomGenerator.nextInt(boardHeight);
        
        Location random = new Location(randX, randY);
        return random;
    }
}