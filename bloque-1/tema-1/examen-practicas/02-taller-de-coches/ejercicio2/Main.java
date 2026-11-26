package ejercicio2;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread empleado1 = new Thread(new Chapa("Marcos", 3000));
        Thread empleado2 = new Thread(new Mecanico("Alvaro", 4000));
        Thread empleado3 = new Thread(new Pintura("Armando", 2500));

        System.out.println("Hoy en el taller hay varias tareas pendientes");

        empleado1.start();
        empleado2.start();
        empleado3.start();

        empleado1.join();
        empleado2.join();
        empleado3.join();

        System.out.println("Trabajo acabado, cerrando taller");
    }
}
