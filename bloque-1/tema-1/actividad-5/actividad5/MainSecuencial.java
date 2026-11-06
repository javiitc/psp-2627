package actividad5;

public class MainSecuencial {
    public static void main(String[] args) throws InterruptedException {
        int[] resultados = new int[Pedido.TOTAL];

        long inicio = System.currentTimeMillis();

        for (int numero = 1; numero <= Pedido.TOTAL; numero++) {
            resultados[numero - 1] = Pedido.preparar(numero);
            if (numero % 100 == 0) {
                System.out.println("[main] guardado el pedido " + numero + " / " + Pedido.TOTAL);
            }
        }

        long tiempo = System.currentTimeMillis() - inicio;

        System.out.println("---");
        System.out.println("[main] pedidos en total = " + Pedido.suma(resultados));
        System.out.println("[main] tiempo = " + tiempo + " ms");
    }
}
