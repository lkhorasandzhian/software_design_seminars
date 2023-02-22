package collaboration;

public record Producer(String name) implements Runnable {
    private static int counter = 0;

    public void giveData() throws InterruptedException {
        synchronized (Buffer.container) {
            if (Buffer.container.size() == Buffer.CAPACITY) {
                System.out.println(name + " is waiting before giving data");
                Buffer.container.wait();
            }
            Buffer.container.add(++counter);
            System.out.printf("%s gives %d" + System.lineSeparator(), name, counter);
            Buffer.container.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                giveData();
            } catch (InterruptedException exception) {
                System.out.println("Producer exception: " + exception.getMessage());
            }
        }
    }
}
