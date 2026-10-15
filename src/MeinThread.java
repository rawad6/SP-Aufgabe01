import java.util.concurrent.Semaphore;
public class MeinThread extends Thread {
    private Hilfszahl zahl;
    private Semaphore semaphor;
    public MeinThread(String name,
                      Hilfszahl zahl,
                      Semaphore semaphor) {
        super(name);
        this.zahl = zahl;
        this.semaphor = semaphor;
    }
    @Override
    public void run() {
        boolean erhalten = false;
        try {
            semaphor.acquire();
            erhalten = true;
            int alterWert = zahl.getWert();
            System.out.println(
                    getName() + " vorher: " + alterWert
            );
            int neuerWert = alterWert + 1;
            Thread.sleep(100);
            zahl.setWert(neuerWert);
            System.out.println(
                    getName() + " nachher: " + neuerWert
            );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (erhalten) {
                semaphor.release();
            }
        }
    }
}