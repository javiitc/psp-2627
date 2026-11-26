package ejercicio3;

public class Cajera implements Runnable {
    private Caja caja;
    private int articulosDisponibles;

    public Cajera(Caja caja, int articulosDisponibles) {
        this.caja = caja;
        this.articulosDisponibles = articulosDisponibles;
    }

    @Override
    public void run() {
        for (int i = 0; i < articulosDisponibles; i++) {
            caja.agregarArticulo();
        }
    }
}
