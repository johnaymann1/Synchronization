import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of WI-FI connections
        System.out.println("What is the number of WI-FI Connections?");
        // Read the user input for the maximum number of WI-FI connections
        int maxConnections = scanner.nextInt();

        // Prompt the user to enter the number of devices clients want to connect
        System.out.println("What is the number of devices Clients want to connect?");
        // Read the user input for the total number of devices
        int totalDevices = scanner.nextInt();

        // Create a Router object with the specified maximum number of connections
        Router router = new Router(maxConnections);
        // Create a list to store the threads representing device connections
        List<Thread> deviceThreads = new ArrayList<>();

        // Loop to input details for each device and create corresponding threads
        for (int i = 0; i < totalDevices; i++) {
            System.out.println("Enter details for Device " + (i + 1) + ":");
            // Prompt the user to enter the name of the device
            System.out.print("Name: ");
            // Read the user input for the name of the device
            String name = scanner.next();

            // Prompt the user to enter the type of the device
            System.out.print("Type: ");
            // Read the user input for the type of the device
            String type = scanner.next();

            // Create a Device object with the entered details and the router reference
            Device device = new Device(name, type, router);
            // Create a thread for the device and add it to the list
            Thread deviceThread = new Thread(device);
            deviceThreads.add(deviceThread);
        }

        // Start each device thread to simulate device connections
        for (Thread thread : deviceThreads) {
            thread.start();
        }

        // Close the scanner to release resources
        scanner.close();
    }
}
