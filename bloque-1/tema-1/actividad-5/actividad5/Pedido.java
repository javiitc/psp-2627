package actividad5;

public class Pedido {
    public static final int TOTAL = 800;
    public static final int HILOS = 8;
    public static final int POR_HILO = TOTAL / HILOS;
    public static final long DURACION_MS = 25;

    public static int preparar(int numero) throws InterruptedException {
        Thread.sleep(DURACION_MS);
        return 1;
    }

    public static int suma(int[] resultados) {
        int total = 0;
        for (int resultado : resultados) {
            total += resultado;
        }
        return total;
    }
}
