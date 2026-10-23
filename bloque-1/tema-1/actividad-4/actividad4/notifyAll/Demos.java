package actividad4.notifyAll;

public class Demos {

    public static void pruebaNotify() throws InterruptedException{
        System.out.println("Esperando para salir al recreo....");

        Recreo recreo = new Recreo();

        Thread claudia = new Thread(new Alumno("Claudia", recreo));
        Thread alvaro = new Thread(new Alumno("Alvaro", recreo));
        Thread nora = new Thread(new Alumno("Nora", recreo));
        Thread portero = new Thread(new Portero(recreo, false));

        claudia.start();
        alvaro.start();
        nora.start();
        portero.start();

        Thread.sleep(3000);
        Thread.sleep(5000); //esta pausa es para que se vea la diferencia de cómo sale primero Claudia y luego el resto
        recreo.tocarTimbreNotifyAll(); //para que los demás alumnos salgan y no se queden esperando infinitamente

        claudia.join();
        alvaro.join();
        nora.join();
        portero.join();

        System.out.println("Todos los alumnos han salido al recreo");
    }

    public static void pruebaNotifyAll() throws InterruptedException {
        System.out.println("Esperando para salir al recreo....");

        Recreo recreo = new Recreo();

        Thread claudia = new Thread(new Alumno("Claudia", recreo));
        Thread alvaro = new Thread(new Alumno("Alvaro", recreo));
        Thread nora = new Thread(new Alumno("Nora", recreo));
        Thread portero = new Thread(new Portero(recreo, true));

        claudia.start();
        alvaro.start();
        nora.start();
        portero.start();

        claudia.join();
        alvaro.join();
        nora.join();
        portero.join();

        System.out.println("Todos los alumnos han salido al recreo");
    }
}
