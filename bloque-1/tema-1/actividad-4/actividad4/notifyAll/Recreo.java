package actividad4.notifyAll;

public class Recreo {
    private boolean timbreSonando = false;

    public synchronized void esperarTimbre(String nombreAlumno) {
        while (!timbreSonando) {
            try {
                System.out.println(nombreAlumno + " está esperando que suene el timbre...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(nombreAlumno + " sale al recreo");
    }

    public synchronized void tocarTimbreNotifyAll() {
        timbreSonando = true;
        System.out.println("El portero ha tocado el timbre del recreo!");
        notifyAll();
    }

    public synchronized void tocarTimbreNotify () {
        timbreSonando = true;
        System.out.println("El portero ha tocado el timbre del recreo!");
        notify();
    }

}
