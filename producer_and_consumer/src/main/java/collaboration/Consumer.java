package collaboration;

import java.util.List;

public record Consumer(String name, List<Integer> numbers) implements Runnable {
    public void takeData() throws InterruptedException {
        synchronized (Buffer.container) {
            if (Buffer.container.isEmpty()) {
                System.out.println(name + " is waiting before taking data");
                Buffer.container.wait();
            }
            numbers.add(Buffer.container.remove());
            System.out.printf("%s takes %d" + System.lineSeparator(), name, numbers.get(numbers.size() - 1));
            Buffer.container.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                takeData();
            } catch (InterruptedException exception) {
                System.out.println("Consumer exception: " + exception.getMessage());
            }
        }
    }
}
