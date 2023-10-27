

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;


public class Simulation {
    
    private List<Floor> floorList;
    private List<Elevator> elevatorList;
    private Random random;
    
    public Simulation()
    {
        floorList = null;
        elevatorList = null;
        random = new Random();
    }
    
    public void RunSimulation(SimulationParameter simulationParameter)
    {
        int currentTick = 0;
        Elevator elevator = null;
        SimulationResult simulationResult = new SimulationResult();
        
        if (simulationParameter.getStructures().equals("linked")) {
            floorList = new LinkedList<Floor>();
            elevatorList = new LinkedList<Elevator>();
        }
        else if (simulationParameter.getStructures().equals("array")) {
            floorList = new ArrayList<Floor>();
            elevatorList = new ArrayList<Elevator>();
        }
        
        for(int loop = 0; loop < simulationParameter.getFloors(); loop++) {
            floorList.add(new Floor(simulationParameter));
        }
        for(int loop = 0; loop < simulationParameter.getElevators(); loop++) {
            elevatorList.add(new Elevator(simulationParameter));
        }
        
        while (currentTick < simulationParameter.getDuration()) {
            
            generateNewPassengers(simulationParameter, currentTick);
            for(int loop = 0; loop < elevatorList.size(); loop++) {
                elevator = elevatorList.get(loop);
                elevator.Simulation(simulationResult, floorList, currentTick);
            }
            
            currentTick = currentTick + 1;            
        }
        
        System.out.println("Average Time Length: " + simulationResult.getAverageTimeLength());
        System.out.println("Longest Time Length: " + simulationResult.getLongestTimeLength());
        System.out.println("Shortest Time Length: " + simulationResult.getShortestTimeLength());
        
    }
    
    private void generateNewPassengers(SimulationParameter simulationParameter, int currentTick) {
        
        int destinationFloor = 0;
        Passenger passenger = null;
        Floor floor = null;
        
        for (int curFloor = 1; curFloor <= simulationParameter.getFloors(); curFloor++) {
            if (random.nextDouble() > simulationParameter.getPassengers()) {
                continue;
            }
            do {
                destinationFloor = (Math.abs(random.nextInt()) % simulationParameter.getFloors()) + 1;
            } while (destinationFloor == curFloor);

            passenger = new Passenger(curFloor, destinationFloor, currentTick);
            floor = floorList.get(curFloor - 1);
            floor.enqueuePassenger(passenger);
            
        }
        
    }
    
    
    private static SimulationParameter ReadPropertyFile(String[] args)
    {
        SimulationParameter simulationParameter = new SimulationParameter();

        if (args.length > 0) {
            
            try {

                Properties properties = new Properties();
                File file = new File(args[0]);
                FileInputStream fileInputStream = new FileInputStream(file);
                properties.load(fileInputStream);
                
                String structures = properties.getProperty("structures");
                if (null != structures) {
                    simulationParameter.setStructures(structures);
                }
                
                String floors = properties.getProperty("floors");
                if (null != floors) {
                    simulationParameter.setFloors(Integer.parseInt(floors));
                }
                
                String passengers = properties.getProperty("passengers");
                if (null != passengers) {
                    simulationParameter.setPassengers(Double.parseDouble(passengers));
                }
                
                String elevators = properties.getProperty("elevators");
                if (null != elevators) {
                    simulationParameter.setElevators(Integer.parseInt(elevators));
                }
                
                String elevatorCapacity = properties.getProperty("elevatorCapacity");
                if (null != elevatorCapacity) {
                    simulationParameter.setElevatorCapacity(Integer.parseInt(elevatorCapacity));
                }
                
                String duration = properties.getProperty("duration");
                if (null != duration) {
                    simulationParameter.setDuration(Integer.parseInt(duration));
                }
                                
            } catch (Exception e) {

            }
            
            
            
        }

        
        return simulationParameter;
    }
    
    public static void main(String[] args) {
        
        SimulationParameter simulationParameter = ReadPropertyFile(args);
        Simulation simulation = new Simulation();
        
        simulation.RunSimulation(simulationParameter);

    }
    
    
    

}
