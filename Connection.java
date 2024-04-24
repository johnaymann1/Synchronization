public class Connection {
    // Instance variables for each connection
    private int id;
    private Device device;

    // Constructor to initialize a connection with a unique ID
    public Connection(int id) {
        // Set the ID for the connection
        this.id = id;
    }

    // Getter method to retrieve the ID of the connection
    public int getId() {
        return id;
    }

    // Getter method to retrieve the device associated with the connection
    public Device getDevice() {
        return device;
    }

    // Setter method to set the device associated with the connection
    public void setDevice(Device device) {
        this.device = device;
    }

    // Override the toString method to provide a custom string representation of the
    // connection
    @Override
    public String toString() {
        return "Connection " + id;
    }
}
