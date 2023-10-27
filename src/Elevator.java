
public class Elevator {
    
    private Heap<Passenger> passengerList;
    private int elevatorCapacity;
    private boolean isGoingUp;    
    private int floors;    
    private int currentFloor;    
    
    
    public Elevator(SimulationParameter simulationParameter) {
        
        passengerList = new Heap<Passenger>(new LowerFloorCompare());
        elevatorCapacity = simulationParameter.getElevatorCapacity();
        isGoingUp = true;
        floors = simulationParameter.getFloors();
        currentFloor = 1;
    }
    
    public void Simulation(SimulationResult simulationResult,
            List<Floor> floorList,
            int currentTick) {
        
        Passenger passenger = null;
        Queue<Passenger> passengerQueue = null;

        for(int loop = 0; loop < 5; loop++) {

            elevatorTravel();
            
            if ((!passengerList.empty()) && 
                (currentFloor == passengerList.peek().getDestinationFloor()))
            {
                break;
            }
            passengerQueue = floorList.get(currentFloor - 1).getPassengerQueue(isGoingUp);
            if (passengerList.size() < elevatorCapacity && (!passengerQueue.empty()))
            {
                break;
            }
        }
        
        while ((!passengerList.empty()) &&
            (currentFloor == passengerList.peek().getDestinationFloor())) {

            passenger = passengerList.remove();
            passenger.setConveyanceTick(currentTick);
            simulationResult.PassengerConveyance(passenger);
        }
        
        passengerQueue = floorList.get(currentFloor - 1).getPassengerQueue(isGoingUp);
        while (passengerList.size() < elevatorCapacity && (!passengerQueue.empty())) {
            passenger = passengerQueue.dequeue();
            passengerList.insert(passenger);
        }

    }
    
    public void elevatorTravel() {

        if (isGoingUp) {
            currentFloor = currentFloor + 1;
            if (floors ==  currentFloor) {
                passengerList.setComparator(new HigherFloorCompare());
                isGoingUp = false;
            }
        }
        else {
            currentFloor = currentFloor - 1;
            if (1 == currentFloor) {
                passengerList.setComparator(new LowerFloorCompare());
                isGoingUp = true;
            }
        }
    }
}


