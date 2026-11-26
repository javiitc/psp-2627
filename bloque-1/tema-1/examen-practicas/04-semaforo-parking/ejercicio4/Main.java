package ejercicio4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaforo semaforo = new Semaforo();

        System.out.println("Los coches estan detenidos en el semaforo en rojo");

        Thread coche1 = new Thread(new Coche(semaforo, "Mercedes"));
        Thread coche2 = new  Thread(new Coche(semaforo, "Porsche"));
        Thread coche3 = new  Thread(new Coche(semaforo, "Bentley"));
        Thread operario = new Thread(new Operario(semaforo, true));

        coche1.start();
        coche2.start();
        coche3.start();
        operario.start();

        coche1.join();
        coche2.join();
        coche3.join();
        operario.join();


    }
}
