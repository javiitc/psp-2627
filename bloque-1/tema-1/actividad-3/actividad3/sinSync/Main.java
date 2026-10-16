package actividad3.sinSync;

public class Main {

    private static final int ENTRADAS_DISPONIBLES = 1000;
    public static void main(String[] args) throws InterruptedException {
        Aforo aforo = new Aforo();

        System.out.println("Cada visitante tiene 1000 entradas para vender. El limite de aforo es 4000");

        Thread visitante1 = new Thread(new Visitante(aforo, ENTRADAS_DISPONIBLES));
        Thread visitante2 = new Thread(new Visitante(aforo, ENTRADAS_DISPONIBLES));
        Thread visitante3 = new Thread(new Visitante(aforo, ENTRADAS_DISPONIBLES));
        Thread visitante4 = new Thread(new Visitante(aforo, ENTRADAS_DISPONIBLES));

        System.out.println("Se espera vender las 4000 entradas totales");

        visitante1.start();
        visitante2.start();
        visitante3.start();
        visitante4.start();

        visitante1.join();
        visitante2.join();
        visitante3.join();
        visitante4.join();

        System.out.println("Entradas vendidas: " + aforo.getEntradasVendidas());

    }
}
