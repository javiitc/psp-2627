package ejercicio3;

import java.io.IOException;

public class Main {

    private static final int PRODUCTOS_DISPONIBLES = 2000;

    public static void main(String[] args) throws InterruptedException{
        Caja caja = new Caja();

        Thread cajera1 = new Thread(new Cajera(caja, PRODUCTOS_DISPONIBLES));
        Thread cajera2 = new Thread(new Cajera(caja, PRODUCTOS_DISPONIBLES));
        Thread cajera3 = new Thread(new Cajera(caja, PRODUCTOS_DISPONIBLES));
        Thread cajera4 = new Thread(new Cajera(caja, PRODUCTOS_DISPONIBLES));

        System.out.println("Hoy en la tienda hay 8000 productos que tienen que ser vendidos");

        cajera1.start();
        cajera2.start();
        cajera3.start();
        cajera4.start();

        cajera1.join();
        cajera2.join();
        cajera3.join();
        cajera4.join();

        System.out.println("Productos vendidos: " + caja.getArticulos());
    }
}
