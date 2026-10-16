package actividad3.sinSync;

public class Aforo {

    int entradasVendidas = 0;

    public void venderEntrada (){
        int entradas = entradasVendidas;
        entradasVendidas = entradas + 1;
    }

    public int getEntradasVendidas(){
        return entradasVendidas;
    }
}
