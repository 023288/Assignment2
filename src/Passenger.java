
public class Passenger {
    
    
    private int sourceFloor;
    private int destinationFloor;
    private int arrivalTick;
    private int conveyanceTick;
    
    
    public Passenger()
    {
        sourceFloor = 0;
        destinationFloor = 0;
        arrivalTick = 0;
        conveyanceTick = 0;
    }
    
    public Passenger(int s, int d, int a)
    {
        sourceFloor = s;
        destinationFloor = d;
        arrivalTick = a;
        conveyanceTick = 0;
    }
    
    public int getTimeLength()
    {
        return conveyanceTick - arrivalTick;
    }
    
    public void setSourceFloor(int s)
    {
        sourceFloor = s;
    }
    
    public int getSourceFloor()
    {
        return sourceFloor;
    }
    
    public void setDestinationFloor(int d)
    {
        destinationFloor = d;
    }
    
    public int getDestinationFloor()
    {
        return destinationFloor;
    }
    
    public void setArrivalTick(int a)
    {
        arrivalTick = a;
    }
    
    public int getArrivalTick()
    {
        return arrivalTick;
    }
    
    public void setConveyanceTick(int c)
    {
        conveyanceTick = c;
    }
    
    public int getConveyanceTick()
    {
        return conveyanceTick;
    }
}
