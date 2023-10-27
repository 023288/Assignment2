

import java.util.Comparator;


public class LowerFloorCompare implements Comparator<Passenger> {

    @Override
    public int compare(Passenger p1, Passenger p2) {
        
        return p1.getDestinationFloor() - p2.getDestinationFloor();
    }

}
