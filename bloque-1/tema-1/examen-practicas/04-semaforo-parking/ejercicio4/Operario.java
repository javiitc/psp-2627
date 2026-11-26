package ejercicio4;

public class Operario implements Runnable {

    private Semaforo semaforo;
    private boolean notifyAll;

    public Operario(Semaforo semaforo, boolean notifyAll) {
        this.semaforo = semaforo;
        this.notifyAll = notifyAll;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (notifyAll) {
            semaforo.notifyAllVerde();
        } else {
            semaforo.notifyVerde();
        }
    }
}
