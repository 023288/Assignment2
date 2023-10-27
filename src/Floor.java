
public class Floor {
    
    private Queue<Passenger> passengerQueueGoingUp;
    private Queue<Passenger> passengerQueueGoingDown;
    
    public Floor(SimulationParameter simulationParameter) {
        if (simulationParameter.getStructures().equals("linked")) {
            passengerQueueGoingUp = new LinkedQueue<Passenger>();
            passengerQueueGoingDown = new LinkedQueue<Passenger>();
        }
        else if (simulationParameter.getStructures().equals("array")) {
            passengerQueueGoingUp = new ArrayQueue<Passenger>();
            passengerQueueGoingDown = new ArrayQueue<Passenger>();            
        }
    }
    
    public void enqueuePassenger(Passenger passenger) {
        if (passenger.getDestinationFloor() > passenger.getSourceFloor()) {
            passengerQueueGoingUp.enqueue(passenger);
        }
        else if (passenger.getDestinationFloor() < passenger.getSourceFloor()) {
            passengerQueueGoingDown.enqueue(passenger);
        }
    }
    
    public Queue<Passenger> getPassengerQueue(boolean isGoingUp) {

        if (isGoingUp) {
            return passengerQueueGoingUp;
        }
        
        return passengerQueueGoingDown;
    }

}
