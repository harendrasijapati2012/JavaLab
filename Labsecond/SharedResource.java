class SharedResource {
    private int counter = 0;

    // Synchronized Method
    public synchronized void incrementCounter() {
        counter++;
    }

    // Synchronized Block
    public void incrementCounterWithBlock() {
        synchronized (this) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }
}

class SyncTask extends Thread {
    private SharedResource resource;

    public SyncTask(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            resource.incrementCounter(); // Using synchronized method
            resource.incrementCounterWithBlock(); // Using synchronized block
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        SyncTask thread1 = new SyncTask(resource);
        SyncTask thread2 = new SyncTask(resource);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Counter Value: " + resource.getCounter());
    }
}
