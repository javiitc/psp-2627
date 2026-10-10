package actividad1;

import java.time.LocalTime;

public class Chef {

    private String name;

    public Chef(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void executeStep (ReceiptStep step) {
        long startTimer = System.currentTimeMillis();

        System.out.println("[" + LocalTime.now().withNano(0) + "] " + name + " empieza: " + step.getDescription());
        System.out.println("    Utensilio: " + step.getContainer().getContainerName());
        System.out.println("    Ingredientes: " + step.getIngredients());
        System.out.println("    Cocinando...");

        step.stepInProgress();

        long elapsedMillis = System.currentTimeMillis() - startTimer;

        System.out.println("[" + LocalTime.now().withNano(0) + "] " + name + " termina: " + step.getDescription() + " (" + elapsedMillis / 1000.0 + " s)");
        System.out.println("    Estado: " + step.getContainer());
        System.out.println();

    }
}
