package actividad4.notifyAll;

public class Alumno implements Runnable {
    private String nombre;
    private Recreo  recreo;

    public Alumno(String nombre, Recreo recreo) {
        this.nombre = nombre;
        this.recreo = recreo;
    }
    @Override
    public void run () {
    recreo.esperarTimbre(nombre);
    }
}
