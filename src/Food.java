public class Food{
    
    private static Location location;
    private static Boolean eaten = false;
    private static final Location initialLoc = new Location(GameBoard.SQUARE_SIZE*5, GameBoard.SQUARE_SIZE*5);
    
    public Food(Location loc){
        location = loc;
    }
    
    public static void initialize(){
        location = initialLoc;
    }
    
    public static void setEaten(Boolean b){
        eaten = b;
    }
    
    public static void eaten(){
        eaten = true;
    }
    
    public static boolean isEaten(){
        return eaten;
    }
    
    public static Location getLocation(){
        return location;
    }
    
    public static void generate(){
        location = Helper.getRandomLocation(GameBoard.getDimension());
    }
    
}