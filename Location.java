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
        switch(direction){
        case UP:
            new Location(currentLoc.getXCoor(), currentLoc.getYCoor()-1);  
            break;
            
        case DOWN:
            new Location(currentLoc.getXCoor(), currentLoc.getYCoor()+1);  
            break;
        
        case LEFT:
            new Location(currentLoc.getXCoor()-1, currentLoc.getYCoor());  
            break;
        
        case RIGHT:
            new Location(currentLoc.getXCoor()+1, currentLoc.getYCoor());  
            break;           
        }
    }
    
    public int getXCoor(){
        return xCoordinate;
    }
    
    public int getYCoor(){
        return yCoordinate;
    }
    
    public boolean equal(Object other){
        if(!(other instanceof Location))
            return false;
        else{
            Location loc = (Location)other;
            return loc.getXCoor()==this.getXCoor()&&loc.getYCoor()==this.getYCoor();
        }
    }
    
    @Override
    public String toString(){
        return "("+xCoordinate+","+yCoordinate+")";
    }
    
}