package actividad6;

import java.io.IOException;

public class Main {
    private static final int ENCARGOS = 8;

    public static void main(String[] args) throws IOException, InterruptedException {
        long[] resultados = new long[ENCARGOS];

        System.out.println("[jefe] canal: " + Canal.ARCHIVO);

        for (int numero = 1; numero <= ENCARGOS; numero++) {
            Canal.enviar(Mensaje.ejecuta(numero));
            System.out.println("[jefe] ejecuta el encargo " + numero);

            Mensaje respuesta = esperarCompleta(numero);
            resultados[numero - 1] = respuesta.resultado;
            System.out.println("[jefe] guardo el resultado del encargo " + numero + " -> " + respuesta.resultado);

            System.out.println("[jefe] esperando a que el trabajador acabe");
            Thread.sleep(Canal.ANTES_DE_CONTESTAR_MS);
        }

        Canal.enviar(Mensaje.fin());

        long suma = 0;
        System.out.println("---");
        System.out.println("[jefe] resultados:");
        for (int i = 0; i < resultados.length; i++) {
            System.out.println("  encargo " + (i + 1) + " -> " + resultados[i]);
            suma += resultados[i];
        }
        System.out.println("[jefe] resultado total = " + suma);
    }

    private static Mensaje esperarCompleta(int numero) throws IOException, InterruptedException {
        while (true) {
            Mensaje mensaje = Canal.recibir();
            if (mensaje != null && mensaje.esCompleta() && mensaje.tarea == numero) {
                return mensaje;
            }
            Thread.sleep(Canal.PAUSA_MS);
        }
    }
}
