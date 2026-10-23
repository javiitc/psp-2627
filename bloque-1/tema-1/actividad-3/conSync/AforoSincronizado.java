package conSync;

public class AforoSincronizado {

    private int entradasVendidas = 0;

    public synchronized void venderEntrada (){
        int entradas = entradasVendidas;
        entradasVendidas = entradas + 1;
    }

    public synchronized int getEntradasVendidas(){
        return entradasVendidas;
    }
}
