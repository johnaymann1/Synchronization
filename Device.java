public class Device implements Runnable {

    // Static variable to keep track of the total number of devices
    private static int deviceCount = 1;

    // Instance variables for each device
    private int id;
    private String name;
    private String type;
    private Router router;

    // Constructor to initialize a device with a unique ID, name, type, and a
    // reference to the router
    public Device(String name, String type, Router router) {
        // Increment the device count to assign a unique ID
        this.id = deviceCount++;
        // Set the name and type of the device
        this.name = name;
        this.type = type;
        // Set the reference to the router
        this.router = router;
    }

    // The main method that gets executed when the device thread is started
    @Override
    public void run() {
        try {
            // Print a message indicating that the device has arrived
            System.out.println("- " + this + " arrived");
            // Occupy a connection for the device and get the associated connection object
            Connection connection = router.occupyConnection(this);
            // Perform online activity (simulate by sleeping for a random duration)
            performOnlineActivity();
            // Print a message indicating that the device has logged out
            System.out.println("- " + this + " Logged out");
            // Release the connection for the device
            router.releaseConnection(connection);
        } catch (InterruptedException e) {
            // Print the stack trace in case of an exception (e.g., if the thread is
            // interrupted)
            e.printStackTrace();
        }
    }

    // Private method to simulate online activity (sleep for a random duration)
    private void performOnlineActivity() throws InterruptedException {
        // Sleep for a random duration between 0 and 500 milliseconds
        Thread.sleep((long) (Math.random() * 500));
        // Print a message indicating that the device is performing online activity
        System.out.println("- " + this + " performs online activity");
    }

    // Override the toString method to provide a custom string representation of the
    // device
    @Override
    public String toString() {
        return "(" + name + ")";
    }
}
