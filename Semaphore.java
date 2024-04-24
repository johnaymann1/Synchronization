public class Semaphore {
    // Variable to track the number of permits available
    private int permits;
    // Flag indicating whether the semaphore follows a fair policy
    private boolean fair;

    // Constructor to initialize the semaphore with the specified number of permits
    // and fairness setting
    public Semaphore(int permits, boolean fair) {
        // Set the initial number of permits
        this.permits = permits;
        // Set the fairness setting
        this.fair = fair;
    }

    // Method for acquiring a permit
    public synchronized void acquire() throws InterruptedException {
        // While there are no permits available, wait until notified
        while (permits == 0) {
            wait();
        }
        // Acquire a permit by decrementing the count
        permits--;
    }

    // Method for releasing a permit
    public synchronized void release() {
        // Release a permit by incrementing the count
        permits++;
        // Notify all waiting threads that a permit is available
        notifyAll();
    }
}
