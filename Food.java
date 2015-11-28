public class Food{
    
    Location location;
    Boolean eaten = false;
    Boolean isPoison = false;
    
    public Food(Location loc){
        this.location = loc;
    }
    
    public void setEaten(Boolean b){
        eaten = b;
    }
    
    public boolean isEaten(){
        return eaten;
    }
    
}