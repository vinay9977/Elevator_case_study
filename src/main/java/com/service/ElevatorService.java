package main.java.com.service;

import main.java.com.controller.ElevatorController;

public class ElevatorService {
	public static void main(String[] args) {
        // Create an ElevatorController instance with 5 floors
        ElevatorController controller = new ElevatorController(5);

        // Simulate passenger requests
        controller.requestElevator(2, 4); // Passenger requests elevator from floor 2 to 4
        controller.requestElevator(1, 5); // Passenger requests elevator from floor 1 to 5
        controller.requestElevator(4, 1); // Passenger requests elevator from floor 4 to 1

        // Process passenger requests and simulate elevator movement
        controller.processRequests();
    }
}
