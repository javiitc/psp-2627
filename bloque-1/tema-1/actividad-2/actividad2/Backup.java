package actividad2;

public class Backup implements Runnable {

    private final String nombreEmpleado;
    private final long milisegundos;

    public Backup(String nombreEmpleado, long milisegundos) {
        this.nombreEmpleado = nombreEmpleado;
        this.milisegundos = milisegundos;
    }

    public void run() {
        System.out.println(nombreEmpleado + " se encargará de realizar copias de seguridad");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Haciendo copia de seguridad de la carpeta " + i + "...");
            try {
                Thread.sleep(milisegundos);
                System.out.println("Copia de seguridad finalizada");
            } catch (InterruptedException e) {
                System.out.println("Copia de seguridad fallida, error 0x807800C5, compruebe el disco");
                throw new RuntimeException(e);
            }
        }

        System.out.println(nombreEmpleado + " ha finalizado su trabajo");
    }
}
