package actividad2;

public class Impresora implements Runnable {
    private final String nombreEmpleado;
    private final long milisegundos;

    public Impresora(String nombreEmpleado,  long milisegundos) {
        this.nombreEmpleado = nombreEmpleado;
        this.milisegundos = milisegundos;
    }

    @Override
    public void run() {
        System.out.println(nombreEmpleado + " se encargará de imprimir todos los documentos");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Imprimiendo el documento " + i + "...");
            try {
                Thread.sleep(milisegundos);
                System.out.println("Documento " + i + " impreso");
            } catch (InterruptedException e) {
                System.out.println("Impresion interrumpida, vuelva a intentarlo ");
                throw new RuntimeException(e);
            }
        }

        System.out.println(nombreEmpleado + " ha finalizado su trabajo");
    }
}
