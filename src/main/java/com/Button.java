package main.java.com;

public class Button {
	private int destinationFloor; // The floor to which the passenger wants to go

    // Constructor to create a passenger with a specific destination floor
    public Button(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    // Get the destination floor of the passenger
    public int getDestinationFloor() {
        return destinationFloor;
    }
}
