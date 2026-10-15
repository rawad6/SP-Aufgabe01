import java.util.concurrent.Semaphore;
public class Main {
    public static void main(String[] args) {
        Hilfszahl zahl = new Hilfszahl();
        Semaphore semaphor = new Semaphore(1);
        MeinThread t1 = new MeinThread(
                "Thread 1", zahl, semaphor
        );
        MeinThread t2 = new MeinThread(
                "Thread 2", zahl, semaphor
        );
        MeinThread t3 = new MeinThread(
                "Thread 3", zahl, semaphor
        );
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println(
                "Endergebnis: " + zahl.getWert()
        );
    }
}