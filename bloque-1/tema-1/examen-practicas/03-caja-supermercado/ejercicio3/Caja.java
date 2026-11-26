package ejercicio3;

public class Caja {

    private int articulos = 0;

    public synchronized void agregarArticulo() {
        articulos++;
    }

    public synchronized int getArticulos() {
        return articulos;
    }
}
