package actividad4.notifyAll;

public class Portero implements Runnable {
    private Recreo recreo;
    private boolean timbreNotifyAll;

    public Portero(Recreo recreo, boolean timbreNotifyAll) {
        this.recreo = recreo;
        this.timbreNotifyAll = timbreNotifyAll;
    }

    public void run () {
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    if (timbreNotifyAll) {
        recreo.tocarTimbreNotifyAll();
    } else {
        recreo.tocarTimbreNotify();
    }
    }
}
