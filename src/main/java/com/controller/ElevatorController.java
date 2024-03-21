package main.java.com.controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import main.java.com.Elevator;
import main.java.com.Elevator.Direction;
import main.java.com.Floor;
import main.java.com.Button;




public class ElevatorController {

	private Elevator elevator;             // The elevator instance being controlled
    private List<Floor> floors;            // List of floors in the building
    private Queue<Button> passengerQueue; // Queue of passenger requests

    // Constructor to initialize the elevator controller with the number of floors
    public ElevatorController(int numFloors) {
        elevator = new Elevator();                  // Create a new elevator instance
        floors = new ArrayList<>();                // Initialize the list of floors
        passengerQueue = new LinkedList<>();       // Initialize the passenger request queue

        // Create instances of floors and add them to the list
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new Floor(i));
        }
    }

    // Request an elevator from a source floor to a destination floor
    public void requestElevator(int sourceFloor, int destinationFloor) {
        Floor source = floors.get(sourceFloor - 1);           // Get the source floor object
        Floor destination = floors.get(destinationFloor - 1); // Get the destination floor object
        Button button = new Button(destinationFloor); // Create a new passenger with the destination floor
        passengerQueue.offer(button);                       // Add the passenger to the request queue

        // Determine elevator direction if it's not moving
        if (elevator.getDirection() == Direction.NONE) {
            if (sourceFloor > elevator.getCurrentFloor()) {
                elevator.direction = Direction.UP;   // Set direction to UP if source is above
            } else {
                elevator.direction = Direction.DOWN; // Set direction to DOWN if source is below
            }
        }
    }

    // Process passenger requests and move the elevator
    public void processRequests() {
        while (!passengerQueue.isEmpty()) {
        	Button passenger = passengerQueue.poll(); // Get the next passenger request
            int destinationFloor = passenger.getDestinationFloor(); // Get the destination floor

            // Move the elevator to the requested floor
            if (destinationFloor > elevator.getCurrentFloor()) {
                elevator.moveToFloor(destinationFloor);
            } else if (destinationFloor < elevator.getCurrentFloor()) {
                elevator.moveToFloor(destinationFloor);
            }
        }
    }
}


