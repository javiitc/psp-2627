package actividad5;

public class Tramo implements Runnable {
    private final int id;
    private final int desde;
    private final int hasta;
    private final int[] parcial;

    public Tramo(int id, int desde, int hasta) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.parcial = new int[hasta - desde + 1];
    }

    public int getDesde() {
        return desde;
    }

    public int getHasta() {
        return hasta;
    }

    public int[] getParcial() {
        return parcial;
    }

    @Override
    public void run() {
        System.out.println("[hilo-" + id + "] empieza a preparar los pedidos " + desde + " a " + hasta);
        try {
            for (int numero = desde; numero <= hasta; numero++) {
                parcial[numero - desde] = Pedido.preparar(numero);
            }
            System.out.println("[hilo-" + id + "] pedidos " + desde + " a " + hasta + " listos");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[hilo-" + id + "] han interrumpido la preparación");
        }
    }
}
