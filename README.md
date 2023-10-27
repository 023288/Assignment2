
1. In order to solve this problem, I write the following class to implement this problem:
   1). The Passenger class, which contain the source floor number, the destination floor number,
       the tick when passenger arrival and the tick when passenger conveyance to the final destination.
   2). The Floor class, which contain two queue: one queue contain the passengers who are going up
       and one queue contain the passengers who are going down.
   3). The Elevator class, which contain a heap for the passengers. The priority of the heap is according
       to the move direction of the elevator and the passenger's destination floor number,
	   In order to implement the priority compare mechanism, I write two compare class which implement
	   the java.util.Comparator interface, the LowerFloorCompare class which is used when the
	   elevator is going up, the LowerFloorCompare class will make the elevator unload the passengers
	   whose destination floor number are lowest first (Because when the elevator is going up, the elevator
	   will reach the lower floor first). the HigherFloorCompare class which is used when the
	   elevator is going down, the HigherFloorCompare class will make the elevator unload the passengers
	   whose destination floor number are highest first (Because when the elevator is going down, the elevator
	   will reach the higher floor first).
   4). The SimulationParameter class which contain all the variable whose value can read from the property file.
   5). The SimulationResult class which contain the following values:
       'Average length of time between passenger arrival and conveyance to the final destination',
	   'Longest time between passenger arrival and conveyance to the final destination',
	   'Shortest time between passenger arrival and conveyance to the final destination'.
   6). The Simulation class which will run the simulation. This class contain a floor list and an elevator list.
       For each tick, the Simulation class will generate new passengers for each floor according to the probability
	   value, call each elevator instance's Simulation function to simulation the following things:
	   Elevator unload and elevator load, Elevator travel.

2. The following data structures class will be used in this project:
   1). The Heap class which will implement the elevator's passenger priority queue using a heap.
   2). The List class, the ArrayList class and the LinkedList class which implement the Array List data structure and
       the Linked List data structure.
   3). The Queue class, the ArrayQueue class and the LinkedQueue class which implement the circular Array Queue data structure
       and the Linked Queue data structure.

3. The flowing command will compile my simulation:
   make clean (rm -rf bin)
   make (mkdir bin, javac -d bin src/*.java)
   java -cp bin Simulation PropertiesFile.txt (the PropertiesFile.txt is the property file name.)



