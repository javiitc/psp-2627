package actividad2;

public class Correo implements Runnable {
    private final String nombreEmpleado;
    private final long milisegundos;

    public Correo(String nombreEmpleado, long milisegundos) {
        this.nombreEmpleado = nombreEmpleado;
        this.milisegundos = milisegundos;
    }

    public void run() {
        System.out.println(nombreEmpleado + " se encargará de responder todos los correos pendientes");
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + nombreEmpleado + "]"+ " Respondiendo correo " + i + "...");
            try {
                Thread.sleep(milisegundos);
                System.out.println("Mensaje enviado");
            } catch (InterruptedException e) {
                System.out.println("No se ha podido enviar el mensaje, vuelva a intentarlo más tarde");
                throw new RuntimeException(e);
            }
        }

        System.out.println(nombreEmpleado + " ha finalizado su trabajo");
    }
}
