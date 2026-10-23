package actividad3.sinSync;

public class Visitante implements Runnable{
    private final Aforo aforo;
    private final int entradasDisponibles;

    public Visitante(Aforo aforo,  int entradasDisponibles) {
        this.aforo = aforo;
        this.entradasDisponibles = entradasDisponibles;
    }

    public void run(){
        for  (int i = 0; i < entradasDisponibles; i++) {
            aforo.venderEntrada();
        }
    }
}
