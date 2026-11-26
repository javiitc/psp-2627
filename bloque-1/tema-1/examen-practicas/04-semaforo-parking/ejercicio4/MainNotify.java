package ejercicio4;

public class MainNotify {

    public static void main(String[] args) throws InterruptedException {
        Semaforo semaforo = new Semaforo();

        System.out.println("Los coches estan detenidos en el semaforo en rojo");

        Thread coche1 = new Thread(new Coche(semaforo, "Mercedes"));
        Thread coche2 = new  Thread(new Coche(semaforo, "Porsche"));
        Thread coche3 = new  Thread(new Coche(semaforo, "Bentley"));
        Thread operario = new Thread(new Operario(semaforo, false));

        coche1.start();
        coche2.start();
        coche3.start();
        operario.start();

        Thread.sleep(5000); //esto es lo que duerme el Main, siempre tiene que ser mayor al operario
        semaforo.notifyAllVerde();

        coche1.join();
        coche2.join();
        coche3.join();
        operario.join();


    }
}
