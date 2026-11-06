package actividad5;

public class MainParalelo {
    public static void main(String[] args) throws InterruptedException {
        int[] resultados = new int[Pedido.TOTAL];
        Tramo[] tramos = new Tramo[Pedido.HILOS];
        Thread[] hilos = new Thread[Pedido.HILOS];

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < Pedido.HILOS; i++) {
            int desde = i * Pedido.POR_HILO + 1;
            int hasta = desde + Pedido.POR_HILO - 1;
            tramos[i] = new Tramo(i + 1, desde, hasta);
            hilos[i] = new Thread(tramos[i], "hilo-" + (i + 1));
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            hilo.join();
        }

        for (Tramo tramo : tramos) {
            int[] parcial = tramo.getParcial();
            for (int i = 0; i < parcial.length; i++) {
                resultados[tramo.getDesde() - 1 + i] = parcial[i];
            }
            System.out.println("[main] guardados los pedidos " + tramo.getDesde() + " a " + tramo.getHasta());
        }

        long tiempo = System.currentTimeMillis() - inicio;

        System.out.println("---");
        System.out.println("[main] pedidos en total = " + Pedido.suma(resultados));
        System.out.println("[main] tiempo = " + tiempo + " ms");
    }
}
