package actividad2;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    private static long randomDuration(int minSeconds, int maxSeconds) {
        int seconds = minSeconds + random.nextInt(maxSeconds - minSeconds + 1);
        return seconds * 1000L;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread imprimir = new Thread(new Impresora("Javi", 5000) {});
        Thread correos = new Thread(new Correo("Alvaro", randomDuration(3, 6)) {});
        Thread backup = new Thread(new Backup("Lem", randomDuration(5, 8)) {});

        System.out.println("Hoy en la oficina hay varias tareas pendientes a realizar");

        imprimir.start();
        correos.start();
        backup.start();

        imprimir.join();
        correos.join();
        backup.join();

        System.out.println("Es la hora de salida, hasta mañana!");

    }
}
