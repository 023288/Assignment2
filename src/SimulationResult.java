
public class SimulationResult {
    
    int totalTimeLength;
    int longestTimeLength;
    int shortestTimeLength;    
    int passengerCount;
    
    public SimulationResult() {
        totalTimeLength = 0;
        longestTimeLength = -1;
        shortestTimeLength = -1;
        passengerCount = 0;
    }    
    
    public void PassengerConveyance(Passenger passenger)
    {
        int timeLength = 0;
        
        timeLength = passenger.getTimeLength();
        totalTimeLength = totalTimeLength + timeLength;
        passengerCount = passengerCount + 1;
        if (-1 == shortestTimeLength) {
            shortestTimeLength = timeLength;
        }
        else if (timeLength < shortestTimeLength) {
            shortestTimeLength = timeLength;
        }
        if (-1 == longestTimeLength) {
            longestTimeLength = timeLength;
        }
        else if (timeLength > longestTimeLength) {
            longestTimeLength = timeLength;            
        }
    }
    
    public double getAverageTimeLength() {
        return totalTimeLength / ((double)passengerCount);
    }
    
    public int getLongestTimeLength() {
        return longestTimeLength;
    }

    public int getShortestTimeLength() {
        return shortestTimeLength;
    }
    
}
