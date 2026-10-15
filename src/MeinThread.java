public class MeinThread extends Thread {

    private Hilfszahl zahl;

    public MeinThread(String name, Hilfszahl zahl) {
        super(name);
        this.zahl = zahl;
    }

    @Override
    public void run() {
        int alterWert = zahl.getWert();

        System.out.println(
                getName() + " before: " + alterWert
        );

        int neuerWert = alterWert + 1;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        zahl.setWert(neuerWert);

        System.out.println(
                getName() + " after: " + neuerWert
        );
    }
}