package actividad6;

import java.io.IOException;

public class Trabajador {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("[trabajador] espero encargos en " + Canal.ARCHIVO);

        while (true) {
            Mensaje mensaje = Canal.recibir();

            if (mensaje != null && mensaje.esFin()) {
                System.out.println("[trabajador] No hay más encargos. Cierro el taller.");
                return;
            }

            if (mensaje != null && mensaje.esEjecuta()) {
                int numero = mensaje.tarea;

                System.out.println("[trabajador] trabajando en el encargo " + numero);

                Canal.enviar(Mensaje.trabajando(numero));
                long resultado = ejecutar(numero);
                Canal.enviar(Mensaje.completa(numero, resultado));

                System.out.println("[trabajador] acabé el encargo " + numero + ", resultado=" + resultado);
            }
            Thread.sleep(Canal.PAUSA_MS);
        }
    }

    private static long ejecutar(int numero) throws InterruptedException {
        Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);
        return numero * 3;
    }
}
