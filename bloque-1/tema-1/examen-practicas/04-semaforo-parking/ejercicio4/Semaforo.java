package ejercicio4;

public class Semaforo {

    private boolean enVerde = false;

    public synchronized void esperarVerde(String coche) {
        while (!enVerde) {
            try {
                System.out.println(coche + " esperando el semaforo en verde");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(coche + " pasa el semaforo en verde");
    }

    public synchronized void notifyVerde() {
        enVerde = true;
        System.out.println("El operario ha puesto en verde el semaforo");
        notify();
    }

    public synchronized void notifyAllVerde() {
        enVerde = true;
        System.out.println("El operario ha puesto en verde el semaforo para todos");
        notifyAll();
    }
}
