
public class SimulationParameter {
    
    
    private String structures;
    private int floors;
    private double passengers;
    private int elevators;
    private int elevatorCapacity;
    private int duration;
    
    
    public SimulationParameter()
    {
        structures = "linked";
        floors = 32;
        passengers = 0.03;
        elevators = 1;
        elevatorCapacity = 10;
        duration = 500;
    }
    
    public void setStructures(String s)
    {
        structures = s;
    }
    
    public String getStructures()
    {
        return structures;
    }
    
    public void setFloors(int f)
    {
        floors = f;
    }
    
    public int getFloors()
    {
        return floors;
    }
    
    public void setPassengers(double p)
    {
        passengers = p;
    }
    
    public double getPassengers()
    {
        return passengers;
    }
    
    public void setElevators(int e)
    {
        elevators = e;
    }
    
    public int getElevators()
    {
        return elevators;
    }
    
    public void setElevatorCapacity(int c)
    {
        elevatorCapacity = c;
    }
    
    public int getElevatorCapacity()
    {
        return elevatorCapacity;
    }
    
    public void setDuration(int d)
    {
        duration = d;
    }
    
    public int getDuration()
    {
        return duration;
    }

}
