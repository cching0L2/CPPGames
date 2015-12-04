class Location{
    /**
     * ADT for location.
     *      a location is represented by location on the x-axis and the location on the y-axis
     */
    private int xCoordinate;
    private int yCoordinate;
    
    Location(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    
    Location(Location currentLoc, Direction direction){
        int snakeSize = Snake.getSnakeSize();
        
        switch(direction){
        case UP:
            yCoordinate=currentLoc.getYCoor()-snakeSize;
            xCoordinate=currentLoc.getXCoor();
            break;
            
        case DOWN:
            yCoordinate=currentLoc.getYCoor()+snakeSize;
            xCoordinate=currentLoc.getXCoor();
            break;
        
        case LEFT:
            xCoordinate=currentLoc.getXCoor()-snakeSize; 
            yCoordinate=currentLoc.getYCoor();
            break;
        
        case RIGHT:
            xCoordinate=currentLoc.getXCoor()+snakeSize; 
            yCoordinate=currentLoc.getYCoor();
            break;           
        }
    }
    
    public int getXCoor(){
        return xCoordinate;
    }
    
    public int getYCoor(){
        return yCoordinate;
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Location))
            return false;
        else{
            Location loc = (Location)other;
            return loc.getXCoor()==this.getXCoor()&&loc.getYCoor()==this.getYCoor();
        }
    }
    
    @Override 
    public int hashCode(){
        return this.getXCoor()*this.getYCoor();
    }
    
    
    @Override
    public String toString(){
        return "("+xCoordinate+","+yCoordinate+")";
    }
    
}