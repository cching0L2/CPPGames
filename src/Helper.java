import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

public class Helper{
    /**
     * where all the helper methods live
     */
    
    static Location getRandomLocation (Dimension gameBoardDimension){
        Location random;
        
        Random randomGenerator = new Random();
        int randX = randomGenerator.nextInt(GameBoard.NUM_GRID) * GameBoard.SQUARE_SIZE;
        int randY = randomGenerator.nextInt(GameBoard.NUM_GRID - 10) * GameBoard.SQUARE_SIZE;
        
        do{
            random = new Location(randX, randY);
        }while(Snake.getSnake().contains(random) | Food.getLocation().equals(random));
        
        return random;
    }
    
    static Color getRandomColor (Color[] options){
        Random randomGenerator = new Random();
        int rand = randomGenerator.nextInt(options.length);
        return options[rand];
    }
}