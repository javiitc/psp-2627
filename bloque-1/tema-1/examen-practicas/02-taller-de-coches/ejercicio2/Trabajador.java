package ejercicio2;

public abstract class Trabajador implements Runnable {

    private String nombreEmpleado;
    private long milisegundos;

    public Trabajador(String nombreEmpleado, long milisegundos) {
        this.nombreEmpleado = nombreEmpleado;
        this.milisegundos = milisegundos;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("[" + nombreEmpleado + "]" + " empieza con su tarea " + (i +1));
            try  {
                Thread.sleep(milisegundos);
                System.out.println("[" + nombreEmpleado + "]" + " ha acabado su tarea " + (i+1));
            } catch (InterruptedException e) {
                System.out.println("[" + nombreEmpleado + "]" +" Tarea interrumpida");
            }
        }

        System.out.println("[" + nombreEmpleado + "]" + " ha terminado");
    }
}
