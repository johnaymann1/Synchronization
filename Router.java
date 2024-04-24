import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Router {
    // Semaphore to control access to the connections
    private Semaphore semaphore;
    // List to store the connections
    private List<Connection> connections;

    // Constructor to initialize the Router with a specified number of maximum
    // connections
    public Router(int maxConnections) {
        // Initialize the semaphore with the maximum number of connections and fairness
        // set to true
        semaphore = new Semaphore(maxConnections, true);
        // Initialize the connections list and create Connection objects with unique IDs
        connections = new ArrayList<>(maxConnections);
        for (int i = 0; i < maxConnections; i++) {
            connections.add(new Connection(i + 1));
        }
    }

    // Method to occupy a connection for a given device
    public Connection occupyConnection(Device device) throws InterruptedException {
        // Acquire a permit from the semaphore, blocking if necessary until one is
        // available
        semaphore.acquire();
        // Find an available connection in the list
        Connection connection = findAvailableConnection();
        // Set the device for the occupied connection
        connection.setDevice(device);
        // Print a message indicating that the connection is occupied by a specific
        // device
        System.out.println("- " + connection + " : " + device + " occupied");
        // Return the occupied connection
        return connection;
    }

    // Method to release a connection
    public void releaseConnection(Connection connection) {
        // Set the device for the released connection to null
        connection.setDevice(null);
        // Release a permit to the semaphore, potentially releasing a blocking acquirer
        semaphore.release();
    }

    // Private helper method to find the first available connection in the list
    private Connection findAvailableConnection() {
        for (Connection connection : connections) {
            if (connection.getDevice() == null) {
                return connection;
            }
        }
        // Return null if no available connection is found (should not happen in this
        // simulation)
        return null;
    }
}
