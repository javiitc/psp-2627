package conSync;

public class VisitanteSincronizado implements Runnable{

    private final AforoSincronizado aforoSincronizado;
    private final int entradasDisponibles;

    public VisitanteSincronizado(AforoSincronizado aforoSincronizado, int entradasDisponibles) {
        this.aforoSincronizado = aforoSincronizado;
        this.entradasDisponibles = entradasDisponibles;
    }

    public void run(){
        for  (int i = 0; i < entradasDisponibles; i++) {
            aforoSincronizado.venderEntrada();
        }
    }
}
